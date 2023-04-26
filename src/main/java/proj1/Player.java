package proj1;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private String name;
    private String role;
    private double amount;
    private String country;
    private String team;
}


