package com.msa.book.framework.kafkaAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.book.application.usecase.MakeAvailableUsecase;
import com.msa.book.application.usecase.MakeUnAvailableUsecase;
import com.msa.book.domain.event.ItemRented;
import com.msa.book.domain.event.ItemReturned;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookEventConsumers {
    //Todo 오브젝트 매퍼를 이용해서 이벤트 스트림이 있는 메세지를 객체로 만들 예정
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MakeAvailableUsecase makeAvailableUsecase;
    private final MakeUnAvailableUsecase makeUnavailable;

    @KafkaListener(topics = "${spring.kafka.consumer.topic1.name}", groupId = "${spring.kafka.consumer.groupid.name}")
    public void consumeRental(ConsumerRecord<String, String> record) throws IOException {
        System.out.printf("rental_rent:" + record.value());
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        makeUnavailable.unavailable(itemRented.getItem().getNo());
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic2.name}", groupId = "${spring.kafka.consumer.groupid.name}")
            public void consumeReturn(ConsumerRecord < String, String>record) throws

    IOException {
        System.out.printf("rental_return:" + record.value());
        ItemReturned itemReturned = objectMapper.readValue(record.value(), ItemReturned.class);
        makeAvailableUsecase.available(itemReturned.getItem().getNo());
    }
}