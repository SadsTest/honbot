package ru.hon.honbot.listener;

import discord4j.core.object.entity.Message;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.hon.honbot.listener.commands.RegCommand;
import ru.hon.honbot.listener.commands.StatCommand;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public abstract class MessageListener {

    public Mono<Void> processCommand(Message eventMessage, RestTemplate restTemplate, String apiUrl) {
        System.out.println("Request :: " + eventMessage.getContent());
        if (!eventMessage.getContent().isEmpty() && eventMessage.getContent().charAt(0) == '.') {
            if (eventMessage.getContent().contains(".stat")) {
                return StatCommand.send(eventMessage, restTemplate, apiUrl);
            }
            if (eventMessage.getContent().contains(".reg")) {
                return RegCommand.send(eventMessage, restTemplate, apiUrl);
            } else {
                return eventMessage.getChannel().flatMap(channel ->
                        channel.createMessage("Неизвестная команда «" + eventMessage.getContent() + "». Используйте (.stat | .reg)")).then();
            }
        }
        return Mono.empty();
    }
}
