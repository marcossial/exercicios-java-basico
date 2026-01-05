import java.util.Scanner;

public class Exercise61v1 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Operation operation;
        String input;
        short option;


        System.out.println("-- Calculadora --");
        System.out.println("Escolha a operação");
        System.out.println("1 - Adição");
        System.out.println("2 - Subtração");

        if (scanner.hasNextShort()) {
            option = scanner.nextShort();
            scanner.nextLine();
        } else {
            System.out.println("Entrada inválida");
            return;
        }

        switch (option) {
            case 1 -> operation = Operation.ADDITION;
            case 2 -> operation = Operation.SUBTRACTION;
            default -> {
                System.out.println("Opção inválida");
                return;
            }
        }

        System.out.printf("Insira os números que deverão ser %s separados por vírgula(,):\n",
                operation == Operation.ADDITION ? "somados" : "subtraídos");
        input = scanner.nextLine();

        System.out.printf("Resultado da %s: %d",operation == Operation.ADDITION ? "soma" : "subtração", operate(input, operation));
    }

    private static int operate(String in, Operation operation) {
        String[] nums = in.split(",");
        int out = Integer.parseInt(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            String num = nums[i];
            out = operation.getCalculate().apply(out, Integer.parseInt(num));
        }
        return out;
    }

}
