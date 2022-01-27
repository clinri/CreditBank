package com.company;

public class CheckingAccount extends Account {
    //Расчетный счет
    protected int balance;

    public CheckingAccount() {
        this.balance = 0;
    }

    @Override
    int getBalance() {
        return balance;
    }

    @Override
    void pay(int amount) {
        super.pay(amount);
        if ((balance - amount) >= 0) {
            int startBalanse = balance;
            balance -= amount;
            System.out.println("Оплачено с расчетного счета, с балансом " + startBalanse +
                    " на сумму " + amount + ". Текущий баланс: " + balance);
        } else {
            System.out.println("Не достаточно средств на расчетном счете " + this.getClass().getSimpleName() +
                    " остаток " + balance + ". Оплата отменена");
        }
    }

    @Override
    void transfer(Account account, int amount) {
        super.transfer(account, amount);
        if ((balance - amount) >= 0) {
            //проверка счета назначения, если он кредитный то не может быть больше 0
            if (account.getClass().getSimpleName().equals("CreditAccount") && (account.getBalance() + amount) > 0) {
                System.out.println("Невозможно перевести на кредитный счет " + account.getClass().getSimpleName() +
                        ", допустимая максимальная сумма для перевода: " + account.getBalance() + ". Перевод отменен");
            } else {
                int startBalanse = balance;
                balance -= amount;
                System.out.println("С расчетного счета, с балансом " + startBalanse +
                        " осуществлен перевод на сумму " + amount + ". Текущий баланс: " + balance);
                account.addMoney(amount);
            }
        } else {
            System.out.println("Не достаточно средств на расчетном счете " + this.getClass().getSimpleName() +
                    " остаток " + balance);
        }
    }

    @Override
    void addMoney(int amount) {
        super.addMoney(amount);
        int startBalanse = balance;
        balance += amount;
        System.out.println("Расчетный счет, с балансом " + startBalanse +
                " пополнен на " + amount + ". Текущий баланс: " + balance);
    }
}
