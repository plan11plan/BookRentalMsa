package com.msa.rental.framework.kafkadapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.rental.application.outport.EventOutputPort;
import com.msa.rental.domain.event.ItemRented;
import com.msa.rental.domain.event.ItemReturned;
import com.msa.rental.domain.event.OverdueCleared;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentalKafkaProducer implements EventOutputPort {


    @Value("${spring.kafka.producers.topic1.name}")
    private String TOPIC_RENT;

    @Value("${spring.kafka.producers.topic2.name}")
    private String TOPIC_RETURN;

    @Value("${spring.kafka.producers.topic3.name}")
    private String TOPIC_CLEAR;
//    @Value(value = "${producers.topic4.name}")
//    private String TOPIC_POINT;
    private final KafkaTemplate<String, ItemRented> kafkaTemplate1;
    private final KafkaTemplate<String, ItemReturned> kafkaTemplate2;
    private final KafkaTemplate<String, OverdueCleared> kafkaTemplate3;
//    private final KafkaTemplate<String, PointUseCommand> kafkaTemplate4;

    @Override
    public void occurRentalEvent(ItemRented itemRented) throws JsonProcessingException {
        var future = (ListenableFuture<SendResult<String, ItemRented>>) this.kafkaTemplate1.send(TOPIC_RENT, itemRented);
        future.addCallback(new ListenableFutureCallback<SendResult<String, ItemRented>>() {

            @Override
            public void onSuccess(SendResult<String, ItemRented> result) {
                ItemRented g = result.getProducerRecord().value();
                log.info(
                        "Sent message=[" + g.getItem().getNo() + "] with offset=[" + result.getRecordMetadata().offset()
                                + "]");
            }

            @Override
            public void onFailure(Throwable t) {
                // needed to do compensation transaction.
                log.error("Unable to send message=[" + itemRented.getItem().getNo() + "] due to : " + t.getMessage(),
                        t);
            }
        });
    }

    @Override
    public void occurReturnedEvent(ItemReturned itemReturned) throws JsonProcessingException {
        ListenableFuture<SendResult<String, ItemReturned>> future = (ListenableFuture<SendResult<String, ItemReturned>>) this.kafkaTemplate2.send(
                TOPIC_RETURN, itemReturned);
        future.addCallback(new ListenableFutureCallback<SendResult<String, ItemReturned>>() {
            @Override
            public void onSuccess(SendResult<String, ItemReturned> result) {
                ItemReturned g = result.getProducerRecord().value();
                log.info("Sent message=[" + g.getItem().getNo() + "] with offset[" + result.getRecordMetadata().offset()
                        + "]");

            }

            @Override
            public void onFailure(Throwable t) {
                log.error(
                        "Unable to esnde message =[" + itemReturned.getItem().getNo() + "] due to : " + t.getMessage(),
                        t);

            }


        });

    }

    @Override
    public void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException {
        ListenableFuture<SendResult<String, OverdueCleared>> future = (ListenableFuture<SendResult<String, OverdueCleared>>)
                this.kafkaTemplate3.send(TOPIC_CLEAR, overdueCleared);
        future.addCallback(new ListenableFutureCallback<SendResult<String, OverdueCleared>>() {
            @Override
            public void onSuccess(SendResult<String, OverdueCleared> result) {
                OverdueCleared g = result.getProducerRecord().value();
                log.info("Sent message=[" + g.getIdName().getId() + "] with offset[" + result.getRecordMetadata()
                        .offset()
                        + "]");

            }

            @Override
            public void onFailure(Throwable t) {
                log.error("Unable to esnde message =[" + overdueCleared.getIdName().getId() + "] due to : " + t.getMessage(),
                        t);

            }


        });
    }
}
