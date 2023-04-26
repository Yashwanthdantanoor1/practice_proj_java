package proj1;
import java.util.List;
import java.util.function.Predicate;

public interface PlayerService {
    double maxAmount();
    List<Player> getPlayers(Predicate<Player> predicate);

    List<TeamStatsDto> getTeamAmountStats();
    List<RoleAmountDto> getTeamRoleStats(String teamName);
    List<Player> getTopPaidPlayers(int n);

    List<String> getTeamNames();
}
