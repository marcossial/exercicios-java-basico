import java.util.Scanner;

public class Exercise12 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Insira lado do quadrado: ");
        double side = scanner.nextDouble();
        double area = Math.pow(side, 2);

        System.out.println("A área do quadrado é: " + area);
    }
}
