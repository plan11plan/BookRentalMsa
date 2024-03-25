package com.msa.member.framework.kafkaAdapter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.member.application.usecase.SavePointUsecase;
import com.msa.member.application.usecase.UsePointUsecase;
import com.msa.member.domain.event.ItemRented;
import com.msa.member.domain.event.ItemReturned;
import com.msa.member.domain.event.OverdueCleared;
import com.msa.member.domain.model.vo.IDName;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberEventConsumers {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SavePointUsecase savePointUsecase;
    private final UsePointUsecase usePointUsecase;

    @KafkaListener(topics = "${spring.consumer.topic1.name}", groupId = "${spring.consumer.groupid.name}")
    public void consumeRent(ConsumerRecord<String, String> record) throws IOException {
        System.out.printf("rental_rent:" + record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        savePointUsecase.savePoint(itemRented.getIdName(), itemRented.getPoint());
    }

    @KafkaListener(topics = "${spring.consumer.topic2.name}", groupId = "${spring.consumer.groupid.name}")
    public void consumeReturn(ConsumerRecord<String, String> record) throws IOException {
        System.out.printf("rental_return:" + record.value());
        ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        savePointUsecase.savePoint(itemReturned.getIdName(), itemReturned.getPoint());
    }

    @KafkaListener(topics = "${spring.consumer.topic3.name}", groupId = "${spring.consumer.groupid.name}")
    public void consumeClear(ConsumerRecord<String, String> record) throws Exception {
        System.out.printf(record.value());
        OverdueCleared overdueCleared = objectMapper.readValue(record.value(), OverdueCleared.class);
        usePointUsecase.userPoint(overdueCleared.getIdName(), overdueCleared.getPoint());
    }
}