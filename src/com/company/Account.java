package com.company;

public abstract class Account {
    abstract int getBalance();

    abstract boolean pay(int amount);
//        System.out.print("[PAY " + amount + " from " + this.getClass().getSimpleName() + "] ");
//    }

    abstract boolean transfer(Account account, int amount);
//        System.out.print("[TRANSFER " + amount + " from " + this.getClass().getSimpleName() +
//                " to " + account.getClass().getSimpleName() + "] ");
//    }

    abstract boolean addMoney(int amount);
//        System.out.print("[ADD " + amount + " to " + this.getClass().getSimpleName() + "] ");
//    }
}