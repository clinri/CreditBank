package com.company;

public class CreditAccount extends Account {
    //Кредитный счет
    protected int limit;
    protected int balance;

    public CreditAccount(int limit) {
        balance = 0;
        this.limit = limit;
    }

    @Override
    int getBalance() {
        return balance;
    }

    @Override
    void pay(int amount) {
        super.pay(amount);
        if ((balance - amount) >= (-limit)) {
            int startBalanse = balance;
            balance -= amount;
            System.out.println("Оплачено с кредитного счета с балансом " + startBalanse +
                    " на сумму " + amount + ". Текущий баланс: " + balance + ". Лимит :" + limit);
        } else {
            System.out.println("[PAY " + amount + " from " +
                    this.getClass().getSimpleName() + "] " +
                    "Лимита кредитного счета " + this.getClass().getSimpleName() +
                    " не достаточно для оплаты, остаток кредитных средств " + (limit + balance) + ". Оплата отменена");
        }
    }

    @Override
    void transfer(Account account, int amount) {
        super.transfer(account, amount);
        System.out.println("Перевод средств с кредитного счета " + this.getClass().getSimpleName() + " запрещен");
    }

    @Override
    void addMoney(int amount) {
        super.addMoney(amount);
        if ((balance + amount) <= 0) {
            int startBalanse = balance;
            balance += amount;
            System.out.println("Кредитный счет, с балансом " + startBalanse +
                    " пополнен на " + amount + ". Текущий баланс: " + balance);
        } else {
            System.out.println("Невозможно пополнить кредитный счет " + this.getClass().getSimpleName() +
                    ", допустимая максимальная сумма для пополнения: " + balance);
        }
    }
}