package com.iplstats.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class playerDto {
    private String name;
    private String role;
    private String country;
    private String team;
    private String teamName;
    private double amount;
}
