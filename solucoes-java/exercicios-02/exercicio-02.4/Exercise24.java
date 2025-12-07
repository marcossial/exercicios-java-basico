import java.util.Scanner;

public class Exercise24 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int a, b;
        System.out.println("Insira o primeiro número:");
        a = scanner.nextInt();
        do {
            System.out.println("Insira o segundo número:");
            b = scanner.nextInt();
        } while (b % a == 0 || b < a);
    }
}