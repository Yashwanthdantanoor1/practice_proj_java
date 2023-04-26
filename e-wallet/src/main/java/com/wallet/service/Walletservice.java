package com.wallet.service;

import com.wallet.domain.Wallet;

import java.util.List;
import java.util.Optional;

public interface Walletservice {
    Optional<Wallet> createwallet(Wallet wallet);
    Optional<Wallet> getwallte(String mobile);
    List<Wallet> getallwallets();
    Optional<Wallet> loadammount(String mobile, double amount);
    boolean transferammount(String frommobile, String tomobile, double amount);
}
