import java.util.Scanner;

public class Exercise51 {
    public static void main(String[] args) {
        Message message = null;
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
            System.out.println("Insira o método para enviar mensagem: ");
            System.out.println("1. SMS");
            System.out.println("2. Email");
            System.out.println("3. Rede Social");
            System.out.println("4. WhatsApp");
            System.out.println("0. Sair do programa");

            if (scanner.hasNextShort()) {
                option = scanner.nextShort();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Entrada inválida");
                continue;
            }

            switch (option) {
                case 0 -> System.exit(0);
                case 1 -> message = new Sms();
                case 2 -> message = new Email();
                case 3 -> message = new SocialMedia();
                case 4 -> message = new WhatsApp();
                default -> {
                    System.out.println("Ação inválida");
                    continue;
                }
            }

            System.out.print("Mensagem: ");
            String msg = scanner.nextLine();

            message.send(msg);
        }
    }
}
