package com.wallet.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wallet {
    private long id;
    private String mobile;
    private String name;
    private double balance;
}