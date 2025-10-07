package com.example.ms.config;

import com.example.ms.service.MailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RestaurantEventConsumer {
    MailService mailService;

    @KafkaListener(topics = "restaurant-events", groupId = "restaurant-service")
    public void consume(RestoranResponse event) {
        log.info("mail sending -> {}", event);
        mailService.sendMail("feridmustafayev550@gmail.com", event.getName(), event.getAddress());
        log.info("mail sended {}", event.getName());
    }
}
