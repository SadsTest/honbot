package ru.hon.honbot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ApiResponse {

    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("current_level")
    private Integer rank;
    @JsonProperty("highest_level_current")
    private Integer highestRank;
    @JsonProperty("k_d_a")
    private String kda;
    @JsonProperty("last_activity")
    private String lastActivity;
    @JsonProperty("cam_gold")
    private Long gold;
    @JsonProperty("cam_secs")
    private Long secAllTime;
    @JsonProperty("cam_wins")
    private Double wins;
    @JsonProperty("cam_games_played")
    private Double matches;
    @JsonProperty("cam_teamcreepkills")
    private Double creepsKills;
    @JsonProperty("cam_denies")
    private Double creepsDenies;
    @JsonProperty("cam_wards")
    private Double wards;

}
