package com.iplstats;

import com.iplstats.service.iplstatsService;
import com.iplstats.service.iplstatsimpl;

public class iplStatsManager {
    public static void main(String[] args) {
        iplstatsService iplstatsService = new iplstatsimpl();
//        iplstatsService.getTeamBasicDetails().forEach(ele->{
//            System.out.println(ele.getTeamName()+ "  " + ele.getTeam());
//        });
//        iplstatsService.getPlayers("CSK").forEach(ele->
//                System.out.println(ele.getName()+"," +ele.getTeam()+"," +ele.getTeamName()+"," +ele.getCountry()+"," +ele.getAmount()));
//    }
//        iplstatsService.getTeamstats().forEach(ele -> {
//            System.out.println(ele.getTeam() + "," + ele.getTeamName() + "," + ele.getTotalAmount());
//
//        } );

        iplstatsService.getRolestats().forEach(ele->{
            System.out.println(ele.getRole()+","+ele.getTotalAmount());
        });
    }
}
