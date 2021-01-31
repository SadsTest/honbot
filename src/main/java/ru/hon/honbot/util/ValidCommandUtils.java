package ru.hon.honbot.util;

import ru.hon.honbot.enums.Commands;

import java.util.Arrays;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class ValidCommandUtils {

    public static boolean validate(String string) {
        long countWhiteSpace = string.chars().filter(s -> s == ' ').count();
        if (countWhiteSpace == 1) {
            if (string.charAt(0) == '.') {
                return equalsCommand(string.substring(1, string.indexOf(' ')));
            }
        }
        return false;
    }

    private static boolean equalsCommand(String string) {
        return Arrays.stream(Commands.values()).anyMatch(e -> e.name().equals(string.toUpperCase()));
    }
}
