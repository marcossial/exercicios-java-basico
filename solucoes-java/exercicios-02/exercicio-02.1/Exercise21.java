import java.util.Scanner;

public class Exercise21 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Tabuada");
        System.out.print("Quero saber a tabuada do: ");
        var num = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s x %s = %s\n", num, i, (num * i));
        }

        scanner.close();
    }
}