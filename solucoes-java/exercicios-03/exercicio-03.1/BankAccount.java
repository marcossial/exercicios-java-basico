public class BankAccount {
    private double balance;
    private double overdraftUsed;
    private double overdraftLimit;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
        this.overdraftUsed = 0;
        if (initialBalance <= 500)
            overdraftLimit = 50;
        else
            overdraftLimit = initialBalance * 0.5;
    }

    public boolean withdraw(double amount) {
        double totalAvailable = balance + (overdraftLimit - overdraftUsed);

        if (amount > totalAvailable) {
            return false;
        }

        balance -= amount;
        if (balance < 0) {
            double newOverdraftUsed = Math.abs(balance);
            double amountToTax = newOverdraftUsed - overdraftUsed;
            if (amountToTax > 0) {
                double fee = amountToTax + 0.2;
                overdraftUsed += amountToTax + fee;
                System.out.printf("Taxa aplicada de %.2f\n", fee);
            }
        } else {
            overdraftUsed = 0;
        }

        if (overdraftUsed > overdraftLimit) {
            double excess = overdraftUsed - overdraftLimit;
            overdraftUsed = overdraftLimit;
            balance += excess;

            if (balance < 0) {
                balance = -overdraftLimit;
            }
        }

        return true;
    }

    public double deposit(double amount) {
        if (balance < 0) {
            double debt = Math.abs(balance);

            if (amount >= debt) {
                amount -= debt;
                balance = 0;
                overdraftUsed = 0;
            } else {
                balance += amount;
                overdraftUsed += Math.abs(balance);
                amount = 0;
            }
        }

        if (amount > 0) {
            balance += amount;
        }

        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftRemaining() {
        return overdraftLimit - overdraftUsed;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}

