package ru.hon.honbot.service;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.hon.honbot.listener.EventListener;
import ru.hon.honbot.listener.MessageListener;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

@Service
public class MessageCreateListener extends MessageListener implements EventListener<MessageCreateEvent> {

    private final RestTemplate restTemplate;
    @Value("${api.url}")
    private String apiUrl;

    public MessageCreateListener(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processCommand(event.getMessage(), restTemplate, apiUrl);
    }
}
