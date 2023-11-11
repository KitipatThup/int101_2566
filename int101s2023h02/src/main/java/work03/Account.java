package work03;

import java.util.Objects;
import work02.Person;
import work01.Utilitor;

public class Account {

    private static long NextNO = 1_000_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException();
        }
        this.no = Utilitor.computeIsbn10(NextNO);
        NextNO += 10;
        this.owner = owner;
        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        this.balance += Utilitor.testPositive(amount);
        return balance;
    }

    public double withdraw(double amount) {
        this.balance -= Utilitor.testPositive(amount);
        return Utilitor.testPositive(balance);
    }

    public void transfer(double amount, Account account) {
        if (account == null || amount > this.balance) {
            throw new IllegalArgumentException();
        }
        this.balance -= amount;
        account.balance += amount;
    }

    @Override
    public String toString() {
        return "Account{" + "no=" + no + ", balance=" + balance + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.no != other.no) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return Objects.equals(this.owner, other.owner);
    }

}
