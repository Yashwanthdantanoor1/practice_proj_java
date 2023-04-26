package proj1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class exe {

    public static void main(String[] args) {
        List<Player> list = getPlayers();
        List<String> playernames = getPlayerNames(list);
        System.out.println(playernames);
    }
    public static List<String> getPlayerNames(List<Player> players){
//        List<String> list = new ArrayList<>();
//        for(Player player:players){
//            list.add(player.getName());
//        }
//        return list;
        return players
                .stream()
                .map(p->p.getName())
                .toList();
    }

    public static List<Player> getPlayers(){
        List<Player> list = new ArrayList<>();
        try {
             list = CsvReaderUtil.loadPlayers();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
