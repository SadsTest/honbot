package ru.hon.honbot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    public void setLastActivity(String lastActivity) {
        this.lastActivity = lastActivity.isEmpty() ? "0/0/0" : lastActivity;
    }
}
