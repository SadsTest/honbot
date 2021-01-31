package ru.hon.honbot.listener.commands;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.hon.honbot.entity.ApiResponse;
import ru.hon.honbot.util.ValidCommandUtils;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class RegCommand {

    public static Mono<Void> send(Message eventMessage, RestTemplate restTemplate, String apiUrl) {
//        return Mono.just(eventMessage)
//                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
//                .flatMap(message -> {
//                    String command = message.getContent().trim();
//                    if (ValidCommandUtils.validate(command)) {
//                        String nickname = command.split(" ")[1];
//                        ResponseEntity<ApiResponse> response;
//                        try {
//                            response = restTemplate.getForEntity(apiUrl + nickname, ApiResponse.class);
//                        } catch (Exception e) {
//                            return message.getChannel().flatMap(channel ->
//                                    channel.createMessage("Пользователь с ником " + nickname + " не найден!"));
//                        }
//                        if (response.getStatusCodeValue() == 200 && Objects.nonNull(response.getBody()) && Objects.nonNull(response.getBody().getLastActivity())) {
//                            ApiResponse res = response.getBody();
//                            Optional<User> author = message.getAuthor();
//                            try {
//                                author.ifPresent(user -> message.getGuild().map(g -> g.getMemberById(user.getId()).map(e -> e.edit(a -> a.setNickname(res.getNickname())))).then());
//                            } catch (Exception e){
//                                e.printStackTrace();
//                            }
                            return Mono.empty();
//                        } else {
//                            return message.getChannel().flatMap(channel ->
//                                    channel.createMessage("Статистика " + nickname + " пуста!"));
//                        }
//                    } else {
//                        return message.getChannel().flatMap(channel ->
//                                channel.createMessage("Неверная команда: «" + message.getContent() + '»'));
//                    }
//                })
//                .then();
    }
}
