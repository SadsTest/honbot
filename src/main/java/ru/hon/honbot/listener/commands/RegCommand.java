package ru.hon.honbot.listener.commands;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.hon.honbot.entity.ApiResponse;
import ru.hon.honbot.util.ValidCommandUtils;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class RegCommand {

    public static Mono<Void> send(Message eventMessage, RestTemplate restTemplate, String apiUrl) {
//        Optional<Role> first = eventMessage.getGuild().block().getRoles().collectList().block().stream().filter(e -> e.getName().toLowerCase().equals("silver")).findFirst();
//        if (eventMessage.getAuthor().map(user -> !user.isBot()).orElse(false)) {
//            return Mono.just(eventMessage)
//                    .flatMap(message -> {
//                        String command = message.getContent().trim();
//                        if (ValidCommandUtils.validate(command)) {
//                            String nickname = command.split(" ")[1];
//                            ResponseEntity<ApiResponse> response;
//                            try {
//                                response = restTemplate.getForEntity(apiUrl + nickname, ApiResponse.class);
//                            } catch (Exception e) {
//                                return message.getChannel().flatMap(channel ->
//                                        channel.createMessage("Пользователь с ником " + nickname + " не найден!"));
//                            }
//                            if (response.getStatusCodeValue() == 200 && Objects.nonNull(response.getBody()) && Objects.nonNull(response.getBody().getLastActivity())) {
//                                ApiResponse res = response.getBody();
//                                try {
//                                    Mono<Member> member = message.getAuthorAsMember();
//
//                                    // TODO: 01.02.2021 не работает
//                                    return member.flatMap(m -> m.edit(e -> {e.setNickname("sdfsdf");e.setRoles(Collections.singleton(first.get().getId()));})).then();
////                                    return Mono.empty();
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                    return Mono.empty();
//                                }
//                            } else {
//                                return message.getChannel().flatMap(channel ->
//                                        channel.createMessage("Статистика " + nickname + " пуста!"));
//                            }
//                        } else {
//                            return message.getChannel().flatMap(channel ->
//                                    channel.createMessage("Неверная команда: «" + message.getContent() + '»'));
//                        }
//                    })
//                    .then();
//        }
        return Mono.empty();
    }
}
