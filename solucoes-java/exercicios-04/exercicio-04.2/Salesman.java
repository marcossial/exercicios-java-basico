public class Salesman extends Employee {
    private static final boolean IS_ADMIN = false;
    private int sales;

    public Salesman(String name, String email, String password, int sales) {
        super(name, email, password, IS_ADMIN);
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
