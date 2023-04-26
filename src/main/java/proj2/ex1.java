package proj2;

import proj1.CsvReaderUtil;
import proj1.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ex1 {
    public static void main(String[] args) throws IOException {
        List<Player> players = CsvReaderUtil.loadPlayers();

        Map<String,List<Player>> map = new HashMap<>();
        for(Player player: players){
            map.putIfAbsent(player.getTeam(),new ArrayList<>());
            List<Player> list = map.get(player.getTeam());
            list.add(player);
            map.put(player.getTeam(),list);
        }
        map.entrySet().forEach(ele -> {
            System.out.println(ele.getKey()+" "+ele.getValue());
        });
    }
}
