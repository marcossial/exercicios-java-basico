import java.util.Scanner;

public class Exercise14 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Insira o nome da primeira pessoa: ");
        String name1 = scanner.nextLine();

        System.out.print("Insira a idade da primeira pessoa: ");
        int age1 = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Insira o nome da segunda pessoa: ");
        String name2 = scanner.nextLine();

        System.out.print("Insira a idade da segunda pessoa: ");
        int age2 = scanner.nextInt();

        int ageDiff = Math.abs(age1 - age2);
        System.out.printf("%s é %s anos mais %s que %s", name1, ageDiff, (age1 > age2 ? "velho" : "novo"), name2);
    }
}
