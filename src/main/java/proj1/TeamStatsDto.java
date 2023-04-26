package proj1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamStatsDto {
    private String teamName;
    private Double totalAmount;
}
