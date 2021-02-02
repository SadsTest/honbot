package ru.hon.honbot.enums;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public enum RoleGPM {

    GPM100("GPM 100+"),
    GPM150("GPM 150+"),
    GPM200("GPM 200+"),
    GPM250("GPM 250+"),
    GPM300("GPM 300+"),
    GPM350("GPM 350+"),
    GPM400("GPM 400+"),
    GPM450("GPM 450+"),
    GPM500("GPM 500+");

    public final String value;

    RoleGPM(String value) {
        this.value = value;
    }
}
