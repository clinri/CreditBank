package com.company;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList();
        accounts.add(new CreditAccount(1000));
        accounts.add(new CheckingAccount());
        accounts.add(new SavingsAccount());
        accounts.get(0).pay(100);
        accounts.get(0).pay(900);
        accounts.get(0).addMoney(1000);
        accounts.get(1).addMoney(4000);
        accounts.get(1).pay(300);
        accounts.get(0).transfer(accounts.get(1), 100);
        accounts.get(1).transfer(accounts.get(0), 100);
        accounts.get(1).transfer(accounts.get(2), 1000);
        for (Account account : accounts) {
            System.out.println("Баланс счета " + account.getClass().getSimpleName() + ": " + account.getBalance());
        }
    }
}
