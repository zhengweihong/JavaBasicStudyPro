package P05_2021050620_ExtendsDemo;

//(a)
public class Account {
    private double availableAmount;

    public Account() {}

    public Account(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    //(d)
    public static double averageAmount(Account[] accountArray) {
        double sum = 0;
        for (Account account : accountArray) {
            sum += account.getAvailableAmount();
        }
        return sum / accountArray.length;
    }
}

//(b)
class SavingsAccount extends Account {
    private double interest;

    public SavingsAccount(double availableAmount, double interest) {
        super(availableAmount);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    //(c)
    @Override
    public double getAvailableAmount() {
        return super.getAvailableAmount() + interest;
    }
}

//(e)
class FrozenAccount extends Account {
    @Override
    public double getAvailableAmount() {
        return 0;
    }
}