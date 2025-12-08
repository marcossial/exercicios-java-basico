import java.util.Scanner;

public class Exercise31 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("[Abrir conta] Insira o saldo inicial: R$ ");
        var bankAccount = new BankAccount(scanner.nextDouble());

        System.out.println();
        while (true) {
            System.out.println("--- Selecione uma ação ---");
            System.out.println(" 1. Consultar Saldo");
            System.out.println(" 2. Consultar Cheque Especial");
            System.out.println(" 3. Depositar Dinheiro");
            System.out.println(" 4. Sacar Dinheiro");
            System.out.println(" 5. Pagar Boleto");
            System.out.println(" 6. Verificar se a conta está usando Cheque Especial");
            System.out.println(" 0. Terminar Programa");
            System.out.println("--------------------------");

            int option = scanner.nextInt();
            
            switch (option) {
                default -> System.out.println("Ação inválida");
                case 0 -> System.exit(0);
                case 1 -> checkBalance(bankAccount);
                case 2 -> checkOverDraft(bankAccount);
                case 3 -> depositMoney(bankAccount);
            }
            
        }
    }

    private static void depositMoney(BankAccount bankAccount) {
        System.out.print("Insira quantia a depositar: R$ ");
        double money = scanner.nextDouble();
    }

    private static void checkOverDraft(BankAccount bankAccount) {
        System.out.println("Cheque especial atual: R$ " + bankAccount.getOverdraft());
    }

    private static void checkBalance(BankAccount bankAccount) {
        System.out.println("Saldo atual: R$ " + bankAccount.getBalance());
    }
}
