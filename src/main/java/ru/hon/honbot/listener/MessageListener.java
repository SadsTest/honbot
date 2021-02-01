package ru.hon.honbot.listener;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.TextChannel;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.hon.honbot.listener.commands.RegCommand;
import ru.hon.honbot.listener.commands.StatCommand;
import ru.hon.honbot.util.ChannelUtils;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public abstract class MessageListener {

    public Mono<Void> processCommand(Message eventMessage, RestTemplate restTemplate, String apiUrl) {
        return eventMessage.getChannel().flatMap(channel -> {
          if (channel instanceof TextChannel) {
              String channelName = ((TextChannel) channel).getName();
              if (ChannelUtils.checkChannel(channelName) && !eventMessage.getContent().isEmpty() && eventMessage.getContent().charAt(0) == '.') {
                  System.out.println("Request :: " + eventMessage.getContent());
                  if (eventMessage.getContent().contains(".stat")) {
                      return StatCommand.send(eventMessage, restTemplate, apiUrl);
                  }
                  if (eventMessage.getContent().contains(".reg")) {
                      return RegCommand.send(eventMessage, restTemplate, apiUrl);
                  } else {
                      return channel.createMessage("Неизвестная команда «" + eventMessage.getContent() + "». Используйте (.stat | .reg)");
                  }
              }
          }
          return Mono.empty();
        }).onErrorReturn(Mono.empty()).then();
    }
}