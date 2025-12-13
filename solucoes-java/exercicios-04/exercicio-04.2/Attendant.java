public class Attendant extends Employee {
    private static final boolean IS_ADMIN = false;
    private double cashValue;

    public Attendant(String name, String email, String password, double cashValue) {
        super(name, email, password, IS_ADMIN);
        this.cashValue = cashValue;
    }

    public double getCashValue() {
        return cashValue;
    }

    public void setCashValue(double cashValue) {
        this.cashValue = cashValue;
    }
}
