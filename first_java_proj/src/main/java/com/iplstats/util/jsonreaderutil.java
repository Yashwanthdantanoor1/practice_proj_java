package com.iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iplstats.domain.Player;
import com.iplstats.domain.Team;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public final class jsonreaderutil {
    private jsonreaderutil(){

    }
    public static List<Player> loadPlayers(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Player>> type = new TypeReference<List<Player>>() {};
        try {
            List<Player> players = objectMapper.readValue(jsonreaderutil.class.getResource("/players.json"),type);
            return players;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static List<Team> loadTeams(){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Team>> type = new TypeReference<List<Team>>() {};
        try {
            List<Team> teams = objectMapper.readValue(jsonreaderutil.class.getResource("/team.json"),type);
            return teams;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
