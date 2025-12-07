import java.util.Scanner;

public class Exercise11 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Insira seu nome: ");
        String name = scanner.nextLine();

        System.out.print("Insira sua idade: ");
        int age = scanner.nextInt();

        System.out.println("Olá, " + name + " você tem " + age + " anos");
    }
}