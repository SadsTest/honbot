package ru.hon.honbot.util;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class ChannelUtils {

    public static boolean checkChannel(String name) {
        name = name.toLowerCase();
        return name.equals("test") || name.equals("статистика");
    }
}
