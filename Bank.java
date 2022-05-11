package com.company;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private int balance = 100;
    private int previousTransaction;
    private String customerId;
    private String password;

    private List<Account> accounts = new ArrayList<>();
    String ADMIN_ID = "Admin";
    String ADMIN_PASSWORD = "Admin123";

    Bank() {

    }

    void LogIn(String cid, String pass) {
        customerId = cid;
        password = pass;

    }

    boolean isLoggedIn(){
        if(customerId.equals(ADMIN_ID) && password.equals(ADMIN_PASSWORD)){
            return true;
        }
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId()) && password.equals(it.getCustomerPassword())){
                return true;
            }
        }

        return false;
    }

    void addAccount(String custName, String custId, String custPass){
        accounts.add(new Account(custName, custId, custPass));
    }

    void displayAllAccounts(){

        for(Account it : accounts){
            System.out.println("Customer name: " + it.getCustomerName());
            System.out.println("Customer id: " + it.getCustomerId());
            System.out.println("Ostatnia transakcja: " + it.getCustomerName());
            System.out.println("Saldo: " + it.getBalance());
            System.out.println();
        }
    }
    void deposit(int amount) {
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())){
                it.deposit(amount);

            }
        }
    }
    void withdraw(int amount) {
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())){
                it.withdraw(amount);
            }
        }

    }
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName(){
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())){
                return it.getCustomerName();
            }
        }
        return "";
    }

    public int getBalance(){
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())){
                return it.getBalance();
            }
        }
        return 0;
    }

    public int getLoan(){
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())){
                return it.getLoan();
            }
        }
        return 0;
    }

    void getPreviousTransaction() {
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())){
                it.printPreviousTransaction();
            }
        }
    }

    void wireTransfer(int amount, String destId){
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())) {
                it.withdraw(amount);

            }

        }
        for(Account it : accounts){
            if(destId.equals(it.getCustomerId())) {
                it.deposit(amount);
            }
        }
    }
    public void takeLoan(int amount){
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())) {
                it.takeLoan(amount);

            }
        }

    }

    public void payBackLoan(int amount){
        for(Account it : accounts){
            if(customerId.equals(it.getCustomerId())) {
                it.payBackLoan(amount);
            }
        }
    }
}
