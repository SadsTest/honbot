package ru.hon.honbot.util;

import discord4j.rest.util.Color;
import ru.hon.honbot.entity.Rank;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class RankUtils {

    public static Rank getRank(int pos) {
        switch (pos) {
            case 0:
                return new Rank("Unranked", "https://i.imgur.com/h0RcR5h.png", Color.GRAY);
            case 1:
                return new Rank("Bronze V", "https://i.imgur.com/XW9tUlV.png", Color.of(43, 25, 0));
            case 2:
                return new Rank("Bronze IV", "https://i.imgur.com/OfOolSK.png", Color.of(43, 25, 0));
            case 3:
                return new Rank("Bronze III", "https://i.imgur.com/Q4fHFT1.png", Color.of(43, 25, 0));
            case 4:
                return new Rank("Bronze II", "https://i.imgur.com/lH6LCnT.png", Color.of(43, 25, 0));
            case 5:
                return new Rank("Bronze I", "https://i.imgur.com/3vTVsdC.png", Color.of(43, 25, 0));
            case 6:
                return new Rank("Silver V", "https://i.imgur.com/gGjhDIM.png", Color.of(140, 140, 140));
            case 7:
                return new Rank("Silver IV", "https://i.imgur.com/cx6YPn7.png", Color.of(140, 140, 140));
            case 8:
                return new Rank("Silver III", "https://i.imgur.com/nBTQSM3.png", Color.of(140, 140, 140));
            case 9:
                return new Rank("Silver II", "https://i.imgur.com/rcDllgP.png", Color.of(140, 140, 140));
            case 10:
                return new Rank("Silver I", "https://i.imgur.com/slkd8EJ.png", Color.of(140, 140, 140));
            case 11:
                return new Rank("Gold IV", "https://i.imgur.com/5l7a5Vl.png", Color.of(225, 128, 0));
            case 12:
                return new Rank("Gold III", "https://i.imgur.com/rfb0SAn.png", Color.of(225, 128, 0));
            case 13:
                return new Rank("Gold II", "https://i.imgur.com/p3M9lFF.png", Color.of(225, 128, 0));
            case 14:
                return new Rank("Gold I", "https://i.imgur.com/aMVvZ40.png", Color.of(225, 128, 0));
            case 15:
                return new Rank("Diamond III", "https://i.imgur.com/lt7m4zE.png", Color.of(0, 179, 255));
            case 16:
                return new Rank("Diamond II", "https://i.imgur.com/gZGYIVa.png", Color.of(0, 179, 255));
            case 17:
                return new Rank("Diamond I", "https://i.imgur.com/j3tcf3d.png", Color.of(0, 179, 255));
            case 18:
                return new Rank("Legendary II", "https://i.imgur.com/0M6ht3c.png", Color.of(128, 0, 255));
            case 19:
                return new Rank("Legendary I", "https://i.imgur.com/OttPTfr.png", Color.of(128, 0, 255));
            case 20:
                return new Rank("Immortal", "https://i.imgur.com/em0NhHz.png", Color.of(255, 0, 0));
            default:
                return new Rank("Неизвестно", "https://images-ext-2.discordapp.net/external/DmmBtcyCPyzGgYLDjbMgrPP3b-Ct2J0Uhz5rlTYeu7Q/https/s3.amazonaws.com/naeu-icb2/icons/default/account/default.png", Color.GRAY);
        }
    }
}
