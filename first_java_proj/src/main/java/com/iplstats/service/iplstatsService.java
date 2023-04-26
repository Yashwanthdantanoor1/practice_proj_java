package com.iplstats.service;

import com.iplstats.dto.*;

import java.util.List;

public interface iplstatsService {
    List<teamBasicDto> getTeamBasicDetails();
    List<playerDto> getPlayers(String team);
    List<teamAmountDto> getTeamstats();
    List<roleAmountDto> getRolestats();
    List<teamRoleCountDto> getRoleCountstats(String team);
    List<playerDto> getPlayers(String team, String role);



}
