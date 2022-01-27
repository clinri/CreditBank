package com.company;

public class SavingsAccount extends Account{
    // Сберегательный счет;
    int balance;

    public SavingsAccount() {
        this.balance = 0;
    }

    @Override
    int getBalance() {
        return balance;
    }

    @Override
    void pay(int amount) {
        System.out.println("Оплата со сберегательного счета " + this.getClass().getSimpleName() + "запрещена");
    }

    @Override
    void transfer(Account account, int amount) {
        if ((balance - amount) >= 0) {
            int startBalanse = balance;
            balance -= amount;
            System.out.println("Со сберегательного счета, с балансом " + startBalanse +
                    " осуществлен перевод на сумму " + amount + ". Текущий баланс: " + balance);
            account.addMoney(amount);
        } else {
            System.out.println("Не достаточно средств на сберегательном счете счете " + this.getClass().getSimpleName() +
                    " остаток " + balance);
        }
    }

    @Override
    void addMoney(int amount) {
        int startBalanse = balance;
        balance += amount;
        System.out.println("Сберегательный счет, с балансом " + startBalanse +
                " пополнен на " + amount + ". Текущий баланс: " + balance);

    }
}
