import java.util.Scanner;

public class Exercise13 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Insira a base do retângulo: ");
        double width = scanner.nextDouble();

        System.out.print("Insira a altura do retângulo: ");
        double height = scanner.nextDouble();

        double area = width * height;
        System.out.println("A área do retângulo é: " + area);
    }
}
