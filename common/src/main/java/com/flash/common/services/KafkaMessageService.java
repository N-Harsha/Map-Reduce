package com.flash.common.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaMessageService implements MessageService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private String topic = "map-007";

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
        kafkaTemplate.send(topic, payload).whenComplete((x,y)->{
            System.out.println("Message sent to Kafka");
        });
    }

    private String toJson(List<List<String>> message) {
        try {
            return objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to serialize message to JSON", e);
        }
    }


}
