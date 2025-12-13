import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void login(Employee employee) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insira email: ");
        String email = scanner.next();

        System.out.print("Insira senha: ");
        String password = scanner.next();

        if (email.equalsIgnoreCase(employee.getEmail()) && password.equals(employee.getPassword())) {
            System.out.println("Login realizado com sucesso");
            employee.setLoggedIn(true);
        } else {
            System.out.println("Email ou senha incorreto");
        }
    }

    public static void logoff(Employee employee) {
        if (!employee.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        System.out.println("Logoff realizado com sucesso");
        employee.setLoggedIn(false);
    }

    public static void changePassword(Employee employee) {
        if (!employee.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre nova senha: ");
        String newPass = scanner.next();

        employee.setPassword(newPass);
        System.out.println("Senha alterada com sucesso");
    }

    public static void changeEmail(Employee employee) {
        if (!employee.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre novo email: ");
        String newEmail = scanner.next();

        employee.setEmail(newEmail);
        System.out.println("Email alterado com sucesso");
    }

    public static void changeName(Employee employee) {
        if (!employee.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre novo nome: ");
        String newName = scanner.nextLine();

        employee.setName(newName);
        System.out.println("Nome alterado com sucesso");
    }

    /*
     *  Métodos do Gerente
     */

    public static void generateFinancialReport(Manager manager, ArrayList<Employee> employees) {
        if (!manager.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        for (Employee employee : employees) {
            switch (employee) {
                case Manager m -> System.out.print("");
                case Salesman s -> consultSales(manager, s);
                case Attendant a -> consultCash(manager, a);
                default -> throw new IllegalStateException("Unexpected value: " + employee);
            }
        }
    }

    public static void consultCash(Manager manager, Attendant attendant) {
        if (!manager.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        System.out.printf("%s(%s) possui %.2f em caixa\n",
                attendant.getName(), attendant.getEmail(), attendant.getCashValue());
    }

    public static void consultSales(Manager manager, Salesman salesman) {
        if (!manager.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        System.out.printf("%s(%s) realizou %d venda(s)\n",
                salesman.getName(), salesman.getEmail(), salesman.getSales());
    }

    /*
     *  Métodos Vendedor
     */

    public static void makeSales(Salesman salesman, int amount) {
        if (!salesman.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        System.out.printf("Vendas de %s(%s) subiram de %d para ",
                salesman.getName(), salesman.getEmail(), salesman.getSales());
        salesman.setSales(salesman.getSales() + amount);
        System.out.println(salesman.getSales());
    }

    /*
     *  Métodos Atendente
     */

    public static void receivePayment(Attendant attendant, double amount) {
        if (!attendant.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        System.out.printf("Caixa de %s(%s) subiram de %.2f para ",
                attendant.getName(), attendant.getEmail(), attendant.getCashValue());
        attendant.setCashValue(attendant.getCashValue() + amount);
        System.out.printf("%.2f\n",attendant.getCashValue());
    }

    public static void closeCash(Attendant attendant) {
        if (!attendant.isLoggedIn()) {
            System.out.println("Realize o login");
            return;
        }
        System.out.printf("%s(%s) fechou o caixa com %.2f\n",
                attendant.getName(), attendant.getEmail(), attendant.getCashValue());
    }
}
