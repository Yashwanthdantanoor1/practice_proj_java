package proj1;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public final class CsvReaderUtil {
    private CsvReaderUtil(){

    }
    public static List<Player> loadPlayers() throws IOException {
        List<Player> players = new ArrayList<>();
        Reader in = new FileReader("src/main/resources/players.csv");
        //Logic
        //1 Read CSV file
        //2 convert scv to list of players
        final String[] HEADERS = "name,role,amount,country,team".split(",");
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(HEADERS)
                .setSkipHeaderRecord(true)
                .build();
        Iterable<CSVRecord> records = csvFormat.parse(in);
        for(CSVRecord csvRecord: records){
            String name = csvRecord.get("name");
            String role = csvRecord.get("role");
            double amount = Double.parseDouble(csvRecord.get("amount"));
            String country = csvRecord.get("country");
            String team = csvRecord.get("team");
            Player player = Player.builder()
                    .name(name)
                    .amount(amount)
                    .country(country)
                    .role(role)
                    .team(team).build();
            players.add(player);
        }
        return players;
    }
}
