package P25_20210612100.A09Q2;

/**
 * @author : ZWH 6/12/21
 * @version : 1.0
 */
public class BankAccount {
    private int id;
    private double balance;
    private double annualInterestRate;
    private static int count;

    public BankAccount(double balance, double annualInterestRate) {
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        count++;
        this.id = count;
    }

    public BankAccount() {
        this(0.0,0.0);
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 12.0 / 100;
    }

    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }

    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    public void displayInfo() {
        System.out.println("Account ID: " + this.id);
        System.out.println("Current balance: $" + this.balance);
        System.out.printf("Annual interest rate: %.3f %%\n",getAnnualInterestRate());
        System.out.printf("Monthly interest rate: %.3f %%\n",getAnnualInterestRate()/12.0);
        System.out.printf("Monthly interest: $%.3f %%\n",getMonthlyInterest());
    }
}
