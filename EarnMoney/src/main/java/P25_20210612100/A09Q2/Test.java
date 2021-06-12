package P25_20210612100.A09Q2;

/**
 * @author : ZWH 6/12/21
 * @version : 1.0
 */
public class Test {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(33000,6.7);
        bankAccount.withdraw(1500);
        bankAccount.deposit(1000);
        bankAccount.displayInfo();
    }
}