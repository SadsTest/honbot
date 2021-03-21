package ru.hon.honbot.listener.commands;

import discord4j.core.object.entity.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.hon.honbot.entity.ApiResponse;
import ru.hon.honbot.util.ArithmeticUtils;
import ru.hon.honbot.util.RankUtils;
import ru.hon.honbot.util.RequestApiForStat;
import ru.hon.honbot.util.ValidCommandUtils;

import java.time.Instant;
import java.util.Objects;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class StatCommand {

    public static Mono<Void> send(Message eventMessage, RestTemplate restTemplate, String apiUrl) {
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
                            if (Objects.nonNull(res) && Objects.nonNull(res.getMatches())) {
                                String author = message.getAuthor().isPresent() ? message.getAuthor().get().getUsername() : "Пользователь";
                                String[] kda = res.getKda().split("/");
                                float kd = Float.parseFloat(kda[0]) / Float.parseFloat(kda[1]);
                                float kad = (Float.parseFloat(kda[0]) + Float.parseFloat(kda[2])) / Float.parseFloat(kda[1]);
                                return message.getChannel().flatMap(channel ->
                                        channel.createEmbed(spec ->
                                                spec.setColor(RankUtils.getRank(res.getRank()).getColor())
                                                        .setAuthor(res.getNickname(), "", RankUtils.getRank(res.getRank()).getImage())
                                                        .setDescription(
                                                                "Уровень: " + res.getLevel() + '\n' +
                                                                "Ранг: " + RankUtils.getRank(res.getRank()).getName() + '\n' +
                                                                "Макс. ранг: " + RankUtils.getRank(res.getHighestRank()).getName() + '\n')
                                                        .addField("Средние показатели:",
                                                         "WIN: " + ArithmeticUtils.getWins(res.getWins(), res.getMatches()) + "%\n" +
                                                                "K/D: " + ArithmeticUtils.getKDA(kd) + '\n' +
                                                                "K/D+A: " + ArithmeticUtils.getKDA(kad) + '\n' +
                                                                "GPM: " + ArithmeticUtils.roundedPerSec(res.getGold(), res.getSecAllTime()) + '\n' +
                                                                "Creep kills: " + ArithmeticUtils.roundedPerGame(res.getCreepsKills(), res.getMatches(), 0) + "\n" +
                                                                "Creep denies: " + ArithmeticUtils.roundedPerGame(res.getCreepsDenies(), res.getMatches(), 0) + "\n" +
                                                                "Wards: " + ArithmeticUtils.roundedPerGame(res.getWards(), res.getMatches(), 1),
                                                                false)
                                                        .addField("Последний матч:", res.getLastActivity(), false)
                                                        .setThumbnail(RankUtils.getRank(res.getRank()).getImage())
                                                        .setFooter(author, message.getAuthor().get().getAvatarUrl())
                                                        .setTimestamp(Instant.now())
                                        ));
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
