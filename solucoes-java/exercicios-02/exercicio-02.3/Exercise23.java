import java.util.Scanner;

public class Exercise23 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro número:");
        int a = scanner.nextInt();

        System.out.println("Digite o segundo número:");
        int b = scanner.nextInt();

        System.out.println("Par ou ímpar? (p/i):");
        String opt = scanner.next();

        if (opt.equalsIgnoreCase("p")) {
            for (int i = a; i <= b; i++) {
                if (i % 2 != 0) continue;
                System.out.println(i);
            }
        } else if (opt.equalsIgnoreCase("i")) {
            for (int i = a; i <= b; i++) {
                if (i % 2 == 0) continue;
                System.out.println(i);
            }
        } else {
            System.out.println("Opção inválida");
        }
        scanner.close();
    }
}