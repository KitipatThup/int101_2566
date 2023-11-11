package work04;

import work04.Person;

public class BankAccount {

    private int number;
    private Person owner;
    private double balance;

    public BankAccount(int number, Person owner) {
        this.number = number;
        this.owner = owner;
        this.balance = 0.0;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        return this.balance = balance + amount;
    }

    public double withdraw(double amount) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("You cannot withdraw");
        }
        return this.balance = balance-amount;
    }

    public void transfer(double amount, BankAccount account) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("You cannot transfer.");
        } else {
            this.balance -= amount;
            account.balance = account.deposit(amount); 
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" + "id = " + number + "}";
    }
}
