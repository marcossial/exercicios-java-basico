public class Manager extends Employee {
    private static final boolean IS_ADMIN = true;
    public Manager(String name, String email, String password) {
        super(name, email, password, IS_ADMIN);
    }
}
