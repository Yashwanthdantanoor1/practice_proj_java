package com.wallet;

import com.wallet.domain.Wallet;
import com.wallet.service.Walletservice;
import com.wallet.service.Walletserviceimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class walletManager {
    public static void main(String[] args) {
        System.out.println("=========> Welcome to Wallet-App <===========");
        Scanner sc = new Scanner(System.in);
        Walletservice walletservice = new Walletserviceimp();
        while(true){
            System.out.println("-".repeat(100));
            System.out.println("1.Create Wallet 2.Get Wallet 3.Get All Wallets 4.Load Amount 5.Transfer Amount 6.Exit");
            System.out.println("-".repeat(100));
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch){
                case 1:
                    Wallet wallet = getwalletInput();
                    Optional<Wallet> newwallet = walletservice.createwallet(wallet);
                    if(newwallet.isPresent()){
                        System.out.println("New Wallet is created with id: " + newwallet.get().getId());
                    }
                    else {
                        System.out.println("The wallet already exists please use different mobile number");
                    }
                    break;
                case 2:
                    System.out.println("Enter the mobile number: ");
                    String mobile = sc.nextLine();
                    Optional<Wallet> getwallet = walletservice.getwallte(mobile);
                    if(getwallet.isPresent())
                    {
                        showwalletdetails(getwallet.get());
                    }
                    else{
                        System.out.println("No wallet present with the given mobile number!");
                    }
                    break;
                case 3:
                    List<Wallet> allwallets = walletservice.getallwallets();
                    if(allwallets.isEmpty()){
                        System.out.println("No wallets are present please create a wallet");
                    }
                    else{
                        for (Wallet w: allwallets) {
                            showwalletdetails(w);
                            System.out.println("-".repeat(100));
                        }
                    }
                    break;
                case 4:
                    String mobile1 = mobile();
                    System.out.println("Please enter the Amount: ");
                    double amount = sc.nextDouble();
                    Optional<Wallet> w = walletservice.loadammount(mobile1,amount);
                    if(w.isPresent()){
                        showwalletdetails(w.get());
                    }
                    else{
                        System.out.println("No wallet present with the given mobile number!");
                    }
                    break;
                case 5 :
                    System.out.println("Enter From mobile number");
                    String frommobile = sc.nextLine();
                    System.out.println("Enter From mobile number");
                    String tomobile = sc.nextLine();
                    System.out.println("Enter the Amount to Transfer");
                    double transferamount = sc.nextDouble();
                    boolean issuccess = walletservice.transferammount(frommobile,tomobile,transferamount);
                    if(issuccess){
                        System.out.println("Successfully Transfered");
                    }
                    else{
                        System.out.println("transfer failed please try again");
                    }
                    break;
                case 6:
                    System.out.println("Thank you");
                    System.exit(0);
            }
        }
    }

    private static String mobile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the mobile number: ");
        String mobile = sc.nextLine();
        return mobile;
    }

    private static void showwalletdetails(Wallet wallet) {
        System.out.println(String.format("%s-%s-%s",wallet.getName(),wallet.getMobile(),wallet.getBalance()));
    }

    private static Wallet getwalletInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the mobile number: ");
        String mobile = sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Balance: ");
        double balance = sc.nextDouble();
        return Wallet.builder().mobile(mobile).name(name).balance(balance).build();
    }
}
