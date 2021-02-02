package ru.hon.honbot.enums;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public enum RoleWIN {

    WIN10("WIN 10%"),
    WIN20("WIN 20%"),
    WIN30("WIN 30%"),
    WIN40("WIN 40%"),
    WIN50("WIN 50%"),
    WIN60("WIN 60%"),
    WIN70("WIN 70%"),
    WIN80("WIN 80%"),
    WIN90("WIN 90%"),
    WIN100("WIN 100%");

    public final String value;

    RoleWIN(String value) {
        this.value = value;
    }
}
