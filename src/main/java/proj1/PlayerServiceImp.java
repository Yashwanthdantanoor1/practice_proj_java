package proj1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlayerServiceImp implements PlayerService{
   private List<Player> players;
   public PlayerServiceImp() throws IOException {
        players = CsvReaderUtil.loadPlayers();
    };
    @Override
    public double maxAmount() {
        double max = players.get(0).getAmount();
        for(int i =1;i<players.size();i++) {
            Player player = players.get(i);
            if (max < player.getAmount()) {
                max = player.getAmount();
            }
        }
        return max;
    }

    @Override
    public List<Player> getPlayers(Predicate<Player> predicate) {
        List<Player> list = new ArrayList<>();
        for(Player p:players){
            if(predicate.test(p)){
                list.add(p);
            }
        }
        return list;
    }

    @Override
    public List<TeamStatsDto> getTeamAmountStats() {
        List<TeamStatsDto> teamStatsList = new ArrayList<>();
        List<String> teamName = getTeamNames();
        for(String teamname:teamName){
            List<Player> list = getPlayers(player -> player.getTeam().equals(teamname));
            double totalAmount = totalAmount(list);
            TeamStatsDto obj = TeamStatsDto.builder()
                    .teamName(teamname).totalAmount(totalAmount).build();
            teamStatsList.add(obj);
        }

        return teamStatsList;
    }
    private double totalAmount(List<Player> list){
        double total =0;
        for(Player player:list){
            total+=player.getAmount();
        }
        return total;
    }

    @Override
    public List<RoleAmountDto> getTeamRoleStats(String teamName) {

        return null;
    }

    @Override
    public List<Player> getTopPaidPlayers(int n) {
        return null;
    }

    @Override
    public List<String> getTeamNames() {
        List<String> teamNames = new ArrayList<>();
        for(Player player:players){
            String tName = player.getName();
            if(!teamNames.contains(tName)){
                teamNames.add(tName);
            }
        }
        return teamNames;
    }

}
