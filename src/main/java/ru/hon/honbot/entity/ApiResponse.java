package ru.hon.honbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import discord4j.core.object.entity.GuildEmoji;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hon.honbot.enums.Hero;
import ru.hon.honbot.util.FormingEmoji;

import java.util.List;
import java.util.Objects;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("level")
    private Integer level = 0;
    @JsonProperty("current_level")
    private Integer rank = 0;
    @JsonProperty("highest_level_current")
    private Integer highestRank = 0;
    @JsonProperty("k_d_a")
    private String kda = "0/0/0";
    @JsonProperty("last_activity")
    private String lastActivity = "0/0/0";
    @JsonProperty("cam_gold")
    private Long gold = 0L;
    @JsonProperty("cam_secs")
    private Long secAllTime = 0L;
    @JsonProperty("cam_wins")
    private Double wins = 0.0;
    @JsonProperty("cam_games_played")
    private Double matches = 0.0;
    @JsonProperty("cam_teamcreepkills")
    private Double creepsKills = 0.0;
    @JsonProperty("cam_denies")
    private Double creepsDenies = 0.0;
    @JsonProperty("cam_wards")
    private Double wards = 0.0;
    @JsonProperty("favHero1_2")
    private Hero favHero1 = Hero.Hero_Unknown;
    @JsonProperty("favHero1Time")
    private Long favHero1Percentages = 0L;
    @JsonProperty("favHero2_2")
    private Hero favHero2 = Hero.Hero_Unknown;
    @JsonProperty("favHero2Time")
    private Long favHero2Percentages = 0L;
    @JsonProperty("favHero3_2")
    private Hero favHero3 = Hero.Hero_Unknown;
    @JsonProperty("favHero3Time")
    private Long favHero3Percentages = 0L;
    @JsonProperty("favHero4_2")
    private Hero favHero4 = Hero.Hero_Unknown;
    @JsonProperty("favHero4Time")
    private Long favHero4Percentages = 0L;
    @JsonProperty("favHero5_2")
    private Hero favHero5 = Hero.Hero_Unknown;
    @JsonProperty("favHero5Time")
    private Long favHero5Percentages = 0L;

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity.isEmpty() ? "0/0/0" : lastActivity;
    }

    public void setFavHero1Percentages(Double favHero1Percentages) {
        this.favHero1Percentages = Objects.nonNull(favHero1Percentages) ? Math.round(favHero1Percentages) : 0L;
    }

    public void setFavHero2Percentages(Double favHero2Percentages) {
        this.favHero2Percentages = Objects.nonNull(favHero2Percentages) ? Math.round(favHero2Percentages) : 0L;
    }

    public void setFavHero3Percentages(Double favHero3Percentages) {
        this.favHero3Percentages = Objects.nonNull(favHero3Percentages) ? Math.round(favHero3Percentages) : 0L;
    }

    public void setFavHero4Percentages(Double favHero4Percentages) {
        this.favHero4Percentages = Objects.nonNull(favHero4Percentages) ? Math.round(favHero4Percentages) : 0L;
    }

    public void setFavHero5Percentages(Double favHero5Percentages) {
        this.favHero5Percentages = Objects.nonNull(favHero5Percentages) ? Math.round(favHero5Percentages) : 0L;
    }

    public void setFavHero1(String favHero1) {
        this.favHero1 = Objects.nonNull(favHero1) && !favHero1.isEmpty() ? Hero.valueOf(favHero1) : Hero.Hero_Unknown;
    }

    public void setFavHero2(String favHero2) {
        this.favHero2 = Objects.nonNull(favHero2) && !favHero2.isEmpty() ? Hero.valueOf(favHero2) : Hero.Hero_Unknown;
    }

    public void setFavHero3(String favHero3) {
        this.favHero3 = Objects.nonNull(favHero3) && !favHero3.isEmpty() ? Hero.valueOf(favHero3) : Hero.Hero_Unknown;
    }

    public void setFavHero4(String favHero4) {
        this.favHero4 = Objects.nonNull(favHero4) && !favHero4.isEmpty() ? Hero.valueOf(favHero4) : Hero.Hero_Unknown;
    }

    public void setFavHero5(String favHero5) {
        this.favHero5 = Objects.nonNull(favHero5) && !favHero5.isEmpty() ? Hero.valueOf(favHero5) : Hero.Hero_Unknown;
    }

    public String getFavoriteHeroes(List<GuildEmoji> list) {
        StringBuilder str = new StringBuilder("");
        if (favHero1 != Hero.Hero_Unknown) {
            appendText(str, favHero1, favHero1Percentages, list);
        }
        if (favHero2 != Hero.Hero_Unknown) {
            appendText(str, favHero2, favHero2Percentages, list);
        }
        if (favHero3 != Hero.Hero_Unknown) {
            appendText(str, favHero3, favHero3Percentages, list);
        }
        if (favHero4 != Hero.Hero_Unknown) {
            appendText(str, favHero4, favHero4Percentages, list);
        }
        if (favHero5 != Hero.Hero_Unknown) {
            appendText(str, favHero5, favHero5Percentages, list);
        }
        return str.toString().isEmpty() ? "Пусто" : str.toString();
    }

    private void appendText(StringBuilder str, Hero favHero, Long percentage, List<GuildEmoji> list){
        str.append(FormingEmoji.getEmoji(favHero.name, list))
                .append(" **")
                .append(favHero.name)
                .append(' ')
                .append(percentage)
                .append("%**\n");

    }
}
