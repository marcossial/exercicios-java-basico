public class BankAccount {
    private double balance;
    private double overdraft;

    public BankAccount(double balance) {
        if (balance < 0) balance = 0;
        this.balance = balance;
        this.overdraft = balance <= 500 ? 50 : balance * 0.5;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}
