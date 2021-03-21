package ru.hon.honbot.listener.commands;

import discord4j.common.util.Snowflake;
import discord4j.core.object.entity.Guild;
import discord4j.core.object.entity.Member;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.hon.honbot.entity.ApiResponse;
import ru.hon.honbot.util.ArithmeticUtils;
import ru.hon.honbot.util.RankUtils;
import ru.hon.honbot.util.RequestApiForStat;
import ru.hon.honbot.util.RoleUtils;
import ru.hon.honbot.util.ValidCommandUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class RegCommand {

    public static Mono<Void> send(Message eventMessage, RestTemplate restTemplate, String apiUrl) {

        List<Role> rolesArr = Objects.requireNonNull(eventMessage.getGuild()
                .map(Guild::getRoles)
                .map(Flux::collectList)
                .block()).block();

        if (eventMessage.getAuthor().map(user -> !user.isBot()).orElse(false)) {
            return Mono.just(eventMessage)
                    .flatMap(message -> {
                        String command = message.getContent().trim();
                        if (ValidCommandUtils.validate(command)) {
                            String nickname = command.split(" ")[1];
                            ApiResponse res;
                            try {
                                res = RequestApiForStat.request(nickname);
                            } catch (Exception e) {
                                return message.getChannel().flatMap(channel ->
                                        channel.createMessage("Пользователь с ником " + nickname + " не найден!"));
                            }
                            if (Objects.nonNull(res) && Objects.nonNull(res.getLastActivity())) {
                                try {
                                    Mono<Member> member = message.getAuthorAsMember();
                                    return member.flatMap(m -> m.edit(e -> {
                                        e.setNickname(res.getNickname());
                                        Set<Snowflake> roles = new HashSet<>();

                                        String[] kda = res.getKda().split("/");
                                        float kd = Float.parseFloat(kda[0]) / Float.parseFloat(kda[1]);

                                        rolesArr.forEach(role -> {
                                            if (role.getName().equals(RankUtils.getRankName(res.getRank()))) {
                                                roles.add(role.getId());
                                            }
                                            if (role.getName().equals(RoleUtils.getKD(ArithmeticUtils.getKDA(kd)))) {
                                                roles.add(role.getId());
                                            }
                                            if (role.getName().equals(RoleUtils.getWIN(ArithmeticUtils.getWins(res.getWins(), res.getMatches())))) {
                                                roles.add(role.getId());
                                            }
                                            if (role.getName().equals(RoleUtils.getGPM(ArithmeticUtils.roundedPerSec(res.getGold(), res.getSecAllTime())))) {
                                                roles.add(role.getId());
                                            }
                                        });

                                        e.setRoles(roles);
                                    })).then();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return Mono.empty();
                                }
                            } else {
                                return message.getChannel().flatMap(channel ->
                                        channel.createMessage("Статистика " + nickname + " пуста!"));
                            }
                        } else {
                            return message.getChannel().flatMap(channel ->
                                    channel.createMessage("Неверная команда: «" + message.getContent() + '»'));
                        }
                    })
                    .then();
        }
        return Mono.empty();
    }
}
