package com.wallet.service;

import com.wallet.domain.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Walletserviceimp implements Walletservice{
    private List<Wallet> wallets = new ArrayList<>();
    @Override
    public Optional<Wallet> createwallet(Wallet wallet) {
        Optional<Wallet> optwallet = getwallte(wallet.getMobile());
        if(optwallet.isPresent()){
            return Optional.empty();
        }
        Long id = ThreadLocalRandom.current().nextLong(1111,9999);
        wallet.setId(id);
        wallets.add(wallet);
        return Optional.of(wallet);
    }

    @Override
    public Optional<Wallet> getwallte(String mobile) {
        for(Wallet w: wallets){
            if(w.getMobile().equals(mobile)){
                return Optional.of(w);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Wallet> getallwallets() {
        return wallets;
    }

    @Override
    public Optional<Wallet> loadammount(String mobile, double amount) {
        Optional<Wallet> optwallet = getwallte(mobile);
        if(optwallet.isPresent()){
            Wallet wallet = optwallet.get();
            wallet.setBalance(wallet.getBalance()+amount);
            return Optional.of(wallet);
        }

        return Optional.empty();
    }

    @Override
    public boolean transferammount(String frommobile, String tomobile, double amount) {
        Optional<Wallet> optwallet1 = getwallte(frommobile);
        Optional<Wallet> optwallet2 = getwallte(tomobile);
        if(optwallet1.isPresent() && optwallet2.isPresent()){
            Wallet fromwallet = optwallet1.get();
            Wallet towallet = optwallet2.get();
            if(fromwallet.getBalance()>=amount){
                fromwallet.setBalance(fromwallet.getBalance()-amount);
                towallet.setBalance(towallet.getBalance()+amount);
                return true;
            }
        }
        return false;
    }
}
