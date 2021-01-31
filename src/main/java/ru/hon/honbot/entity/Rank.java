package ru.hon.honbot.entity;

import discord4j.rest.util.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rank {

    private String name;
    private String image;
    private Color color;
}
