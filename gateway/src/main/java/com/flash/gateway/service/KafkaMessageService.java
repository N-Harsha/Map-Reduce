package com.flash.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessageService implements MessageService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
//    @Value("${app.kafka.topic.name}")
    private String topic = "map-007";

    private static int counter = 0;
    public KafkaMessageService(
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper objectMapper
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(List<List<String>> message) {
        String payload = toJson(message);
        counter++;
        kafkaTemplate.send(topic, payload).whenComplete((result, error) -> System.out.println("done "+counter));
    }

    private String toJson(List<List<String>> message) {
        try {
            return objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to serialize message to JSON", e);
        }
    }


}
