package ru.hon.honbot.util;

import discord4j.core.object.entity.GuildEmoji;
import ru.hon.honbot.enums.Hero;

import java.util.List;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class FormingEmoji {

    public static String getEmoji(String nameEmoji, List<GuildEmoji> list) {
        return list.stream()
                .filter(e -> e.getName().equals(nameEmoji.toLowerCase()))
                .findAny()
                .orElse(list.stream().filter(e -> e.getName().equals(Hero.Hero_Unknown.name.toLowerCase())).findAny().get())
                .asFormat();
    }
}
