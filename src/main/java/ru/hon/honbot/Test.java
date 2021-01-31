package ru.hon.honbot;

import ru.hon.honbot.enums.Commands;

import java.util.Arrays;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class Test {
    public static void main(String[] args) {
        String a = ".stat ";
        Commands[] commands = Commands.values();
        System.out.println(a.substring(1, a.indexOf(' ')));
        Arrays.stream(commands).forEach(e -> System.out.println(e.name()));
    }
}
