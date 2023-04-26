package com.iplstats.service;

import com.iplstats.domain.Player;
import com.iplstats.domain.Team;
import com.iplstats.dto.*;
import com.iplstats.util.jsonreaderutil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class iplstatsimpl implements iplstatsService{
    private List<Player> players;
    private List<Team> teams;
    private Map<String, Team> teamMap;
    private Map<String, List<Player>> playerMap;
    private Map<String, List<Player>> playerrolemap;
    public iplstatsimpl(){
        players = jsonreaderutil.loadPlayers();
        teams = jsonreaderutil.loadTeams();
        teamMap = teams.stream().collect(Collectors.toMap(ele->ele.getTeam(),ele->ele));
        playerMap = players.stream().collect(Collectors.groupingBy(Player::getTeam));
        playerrolemap = players.stream().collect(Collectors.groupingBy(Player::getRole));
    }
    @Override
    public List<teamBasicDto> getTeamBasicDetails() {
        return teams.stream().map(ele->{
            teamBasicDto obj = new teamBasicDto();
            obj.setTeam(ele.getTeam());
            obj.setTeamName(ele.getTeamName());
            return obj;
        }).toList();

    }

    @Override
    public List<playerDto> getPlayers(String team) {
        Team teamdetails = teamMap.get(team);
        List<Player> teamPlayers = playerMap.get(team);
        List<playerDto> list = teamPlayers.stream().map(ele -> {
            playerDto obj = new playerDto();
            obj.setTeamName(teamdetails.getTeamName());
            obj.setTeam(ele.getTeam());
            obj.setAmount(ele.getAmount());
            obj.setCountry(ele.getCountry());
            obj.setRole(ele.getRole());
            obj.setName(ele.getName());
            return obj;
        }).collect(Collectors.toList());
        return list;
    }

    @Override
    public List<teamAmountDto> getTeamstats() {
        List<teamAmountDto> list = new ArrayList<>();
        teamMap.entrySet().forEach(ele->{
           List<Player> players = playerMap.get(ele.getKey());
           double totalAmount = players.stream().mapToDouble(p->p.getAmount()).sum();
           teamAmountDto obj = new teamAmountDto();
           obj.setTeam(ele.getKey());
           obj.setTeamName(ele.getValue().getTeamName());
           obj.setTotalAmount(totalAmount);
           list.add(obj);
        });
        return list;
    }

    @Override
    public List<roleAmountDto> getRolestats() {
        List<roleAmountDto> list = new ArrayList<>();
        playerrolemap.entrySet().forEach(ele->{
            double totalamount = ele.getValue().stream().mapToDouble(Player::getAmount).sum();
            roleAmountDto obj = new roleAmountDto();
            obj.setRole(ele.getKey());
            obj.setTotalAmount(totalamount);
            list.add(obj);
        });
        return list;
    }

    @Override
    public List<teamRoleCountDto> getRoleCountstats(String team) {
        return null;
    }

    @Override
    public List<playerDto> getPlayers(String team, String role) {
        return null;
    }

}
