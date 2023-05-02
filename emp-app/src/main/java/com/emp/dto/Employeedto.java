package com.emp.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employeedto {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private String currency;
    private double salary;
    private String formatedsalary;
}
