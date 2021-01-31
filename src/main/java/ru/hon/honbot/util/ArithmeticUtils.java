package ru.hon.honbot.util;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class ArithmeticUtils {

    public static long roundedPerSec(long data, long sec) {
        return Math.round(data / (sec / 60.0));
    }

    public static double getKDA(float kd) {
        return Math.ceil(kd * Math.pow(10, 2)) / Math.pow(10, 2);
    }

    public static long getWins(double wins, double matches) {
        return Math.round(wins / matches * 100);
    }

    public static double roundedPerGame(double data, double matches, int places) {
        double value = data / matches;
        return places == 0 ? Math.round(value) : Math.ceil(value * Math.pow(10, places)) / Math.pow(10, places);
    }
}
