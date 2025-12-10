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
                case 0 -> System.exit(0);
                case 1 -> checkBalance(bankAccount);
                case 2 -> checkOverDraftLimit(bankAccount);
                case 3 -> depositMoney(bankAccount);
                case 4 -> withdrawMoney(bankAccount);
                case 5 -> payBill(bankAccount);
                case 6 -> verifyOverdraft(bankAccount);
                default -> System.out.println("Ação inválida");
            }
        }
    }

    private static void verifyOverdraft(BankAccount bankAccount) {
        if (bankAccount.getBalance() < 0) {
            System.out.printf("Está usando Cheque Especial. Valor usado R$ %.2f\n", bankAccount.getBalance());
        } else {
            System.out.println("Está usando o próprio Saldo");
        }
        System.out.printf("Limite de Cheque Especial restante: R$ %.2f\n", bankAccount.getOverdraftRemaining());
    }

    private static void payBill(BankAccount bankAccount) {
        System.out.print("Insira o valor do boleto: R$ ");
        if (scanner.hasNextDouble()) {
            double bill = scanner.nextDouble();
            if (bill <= 0) {
                System.out.println("O valor do boleto deve ser positivo.");
                return;
            }

            if (bankAccount.withdraw(bill)) {
                System.out.printf("Pagamento de boleto de R$ %.2f realizado. Novo Saldo: R$ %.2f\n", bill, bankAccount.getBalance());
            } else {
                System.out.println("Transação negada. Saldo/Limite de Cheque Especial insuficiente para pagar o boleto.");
            }
        } else {
            System.out.println("Entrada inválida.");
            scanner.next();
        }
    }

    private static void withdrawMoney(BankAccount bankAccount) {
        System.out.print("Insira quantia a sacar: R$ ");
        if (scanner.hasNextDouble()) {
            double money = scanner.nextDouble();
            if (money <= 0) {
                System.out.println("O valor do saque deve ser positivo.");
                return;
            }

            if (bankAccount.withdraw(money)) {
                System.out.printf("Saque de R$ %.2f realizado. Novo Saldo: R$ %.2f\n", money, bankAccount.getBalance());
            } else {
                System.out.println("Transação negada. Saldo/Limite de Cheque Especial insuficiente.");
            }
        } else {
            System.out.println("Entrada inválida.");
            scanner.next();
        }
    }

    private static void depositMoney(BankAccount bankAccount) {
        System.out.print("Insira quantia a depositar: R$ ");
        if (scanner.hasNextDouble()) {
            double money = scanner.nextDouble();
            if (money <= 0) {
                System.out.println("O valor do depósito deve ser positivo.");
                return;
            }

            double currentBalance = bankAccount.deposit(money);
            System.out.printf("Depósito de R$ %.2f realizado. Novo Saldo: R$ %.2f\n", money, currentBalance);
        } else {
            System.out.println("Entrada inválida.");
            scanner.next();
        }
    }

    private static void checkOverDraftLimit(BankAccount bankAccount) {
        System.out.printf("Limite total do Cheque Especial: R$ %.2f", bankAccount.getOverdraftLimit());
    }

    private static void checkBalance(BankAccount bankAccount) {
        System.out.printf("Saldo atual: R$ %.2f", bankAccount.getBalance());
        System.out.printf("Valor disponível: R$ %.2f", bankAccount.getBalance() + bankAccount.getOverdraftRemaining());
    }
}
