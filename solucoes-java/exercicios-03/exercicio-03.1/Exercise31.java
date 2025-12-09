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
                case 2 -> checkOverDraft(bankAccount);
                case 3 -> depositMoney(bankAccount);
                case 4 -> withdrawMoney(bankAccount);
                case 5 -> payBill(bankAccount);
                case 6 -> verifyOverdraft(bankAccount);
                default -> System.out.println("Ação inválida");
            }
        }
    }

    private static void verifyOverdraft(BankAccount bankAccount) {
        if (bankAccount.getBalance() > 0) {
            System.out.println("Está usando cheque especial");
        } else {
            System.out.println("Está usando saldo");
        }
    }

    private static void payBill(BankAccount bankAccount) {
        System.out.print("Insira o valor do boleto: R$ ");
        double bill = scanner.nextDouble();
        if (bill < 0) bill = 0;
        double balance = bankAccount.getBalance();
        double overdraft = bankAccount.getOverdraft();
        if (bill > balance) {
            double diff = bill - balance;
            balance = balance - bill + diff;
            overdraft = overdraft - diff;
        }
        bankAccount.setBalance(balance);
        bankAccount.setOverdraft(overdraft);
    }

    private static void withdrawMoney(BankAccount bankAccount) {
        System.out.print("Insira quantia a sacar: R$ ");
        double money = scanner.nextDouble();
        if (money < 0) money = 0;
        double balance = bankAccount.getBalance();
        double overdraft = bankAccount.getOverdraft();
        if (money > balance) {
            double diff = money - balance;
            balance = balance - money + diff;
            overdraft = overdraft - diff;
        }
        bankAccount.setBalance(balance);
        bankAccount.setOverdraft(overdraft);
    }

    private static void depositMoney(BankAccount bankAccount) {
        System.out.print("Insira quantia a depositar: R$ ");
        double money = scanner.nextDouble();
        if (money < 0) money = 0;
        if (bankAccount.getOverdraft() <= 0) {
            money = money - money * 0.2;
        }
        bankAccount.setBalance(bankAccount.getBalance() + money);
        bankAccount.setOverdraft(bankAccount.getOverdraft() + (money <= 500 ? 50 : money * 0.5));
    }

    private static void checkOverDraft(BankAccount bankAccount) {
        System.out.println("Cheque especial atual: R$ " + bankAccount.getOverdraft());
    }

    private static void checkBalance(BankAccount bankAccount) {
        System.out.println("Saldo atual: R$ " + bankAccount.getBalance());
    }
}
