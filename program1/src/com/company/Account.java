package com.company;


class Account
{
    private int balance;
    private int loan;
    private String previousTransaction;
    private String customerName;
    private String customerId;
    private String customerPassword;



    Account(String cname, String cid, String customerPass)
    {
        customerName = cname;
        customerId = cid;
        customerPassword = customerPass;
        balance = 0;
        loan = 0;
        previousTransaction = "";

    }

    public String getPreviousTransaction() {
        return previousTransaction;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public int getBalance() {
        return balance;
    }

    public int getLoan() {
        return loan;
    }

    void deposit(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
            previousTransaction = "Wpłata: " + amount;
        }
        else {
            System.out.println("Nieprawidłowa wartość!");
        }
    }

    void withdraw(int amount) {
        if(amount > 0 ) {
            if(amount < balance) {
                balance = balance - amount;
                previousTransaction = "Wypłata: " + amount;
            }
            else {
                System.out.println("Brak wystarczających środków na koncie");
            }

        }
        else {
            System.out.println("Nieprawidłowa wartość!");
        }

    }

    public void printPreviousTransaction() {
        System.out.println(previousTransaction);
    }

    public void takeLoan(int amount){
        balance = balance + amount;
        loan = loan + amount;
        previousTransaction = "Zaciągnięto kredyt: " + amount;

    }

    public void payBackLoan(int amount){
        if(amount < balance) {
            balance = balance - amount;
            loan = loan - amount;
            previousTransaction = "Spałcono kredyt w kwocie: " + amount;
        }
        else {
            System.out.println("Brak wystarczających środków na koncie");
        }


    }


}


