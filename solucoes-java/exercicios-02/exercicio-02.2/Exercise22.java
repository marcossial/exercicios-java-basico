import java.util.Scanner;

public class Exercise22 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Insira sua altura: ");
        double altura = scanner.nextDouble();

        System.out.print("Insira seu peso: ");
        double peso = scanner.nextDouble();

        double imc = peso / (Math.pow(altura, 2));
        String msg;
        if (imc <= 18.5) {
            msg = "abaixo do peso";
        } else if (imc <= 24.9) {
            msg = "com peso ideal";
        }  else if (imc <= 29.9) {
            msg = "levemente acima do peso";
        } else if (imc <= 34.9) {
            msg = "com obesidade grau I";
        }  else if (imc <= 39.9) {
            msg = "com obesidade grau II (Severa)";
        } else {
            msg = "com obesidade grau III (Mórbida)";
        }
        System.out.printf("Você está %s", msg);
        scanner.close();
    }
}