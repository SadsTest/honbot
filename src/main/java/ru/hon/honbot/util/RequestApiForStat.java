package ru.hon.honbot.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import discord4j.core.object.entity.Message;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import ru.hon.honbot.entity.ApiResponse;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class RequestApiForStat {

    public static ApiResponse request(String nickname) {
        final ResponseEntity<String> exchange = new RestTemplate().exchange("http://masterserver.naeu.heroesofnewerth.com/client_requester.php?f=show_stats&nickname="+nickname+"&table=campaign", HttpMethod.GET, null, String.class);
        String res = exchange.getBody();
        ApiResponse apiResponse = null;
        if (res != null) {
            if (res.toLowerCase().contains("not found")) {
                throw new ResponseStatusException(HttpStatus.OK, "Nickname not found");
            } else {
                res = '{' + res.substring(res.indexOf('"'));
                res = res.replaceAll(";s:\\d+:", ":");
                res = res.replaceAll(";i|;d", "");
                res = res.replaceAll(";N:", ":\"\":");
                int j = 0;
                StringBuilder newStr = new StringBuilder(res);
                newStr.delete(newStr.indexOf("\"my_upgrades\""), newStr.indexOf("\"timestamp\""));
                newStr.delete(newStr.indexOf("\"quest_stats\""), newStr.indexOf("\"highest_level_current\""));
                newStr.delete(newStr.indexOf("\"con_reward\""), newStr.indexOf("\"vested_threshold\""));
                newStr.delete(newStr.indexOf("\"latest_season_cam_games_played\""), newStr.indexOf("\"vested_threshold\""));
                final char[] chars = newStr.toString().toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] == ':') {
                        if (j % 2 != 0) {
                            newStr.replace(i, i + 1, ",");
                        }
                        j++;
                    }
                }
                final String str = newStr.substring(0, newStr.lastIndexOf(",")) + '}';

                try {
                    apiResponse = new ObjectMapper().readValue(str, ApiResponse.class);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                System.out.println(apiResponse);
            }
        }
        return apiResponse;
    }
}
