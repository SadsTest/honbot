package ru.hon.honbot.enums;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public enum RoleKD {

    KD_0_5("K/D 0.5+"),
    KD_1_0("K/D 1.0+"),
    KD_1_5("K/D 1.5+"),
    KD_2_0("K/D 2.0+"),
    KD_2_5("K/D 2.5+"),
    KD_3_0("K/D 3.0+"),
    KD_3_5("K/D 3.5+"),
    KD_4_0("K/D 4.0+"),
    KD_4_5("K/D 4.5+"),
    KD_5_0("K/D 5.5+");

    public final String value;

    RoleKD(String value) {
        this.value = value;
    }
}
