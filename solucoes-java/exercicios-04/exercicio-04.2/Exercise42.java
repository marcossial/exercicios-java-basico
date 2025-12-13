import java.util.ArrayList;

public class Exercise42 {
    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();
        Manager manager = new Manager("Claudio", "claudio@email.com", "1234");
        Salesman salesman = new Salesman("Sérgio", "sergio@email.com", "19950203", 10);
        Attendant attendant = new Attendant("Vera", "vera@email.com", "32847%$njksdfg@#8di", 89.87);

        employees.add(manager);
        employees.add(salesman);
        employees.add(attendant);

        for (Employee employee: employees) {
            Controller.login(employee);
            if (employee instanceof Manager m) {
                Controller.generateFinancialReport(m, employees);
            }
            if (employee instanceof Salesman s) {
                Controller.makeSales(s, 10);
            }
            if (employee instanceof Attendant a) {
                Controller.receivePayment(a, 125.92);
                Controller.closeCash(a);
            }
        }
    }
}
