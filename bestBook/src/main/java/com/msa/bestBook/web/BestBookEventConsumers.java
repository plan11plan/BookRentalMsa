package com.msa.bestBook.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.bestBook.domain.BestBookService;
import com.msa.bestBook.domain.event.ItemRented;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BestBookEventConsumers {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final BestBookService bestBookService;

    @KafkaListener(topics = "rental_rent", groupId = "bestbook")
    public void consume(ConsumerRecord<String, String> record) throws IOException {
        ItemRented itemRented = objectMapper.readValue(record.value(), ItemRented.class);
        bestBookService.dealBestBook(itemRented.getItem());
    }
}
