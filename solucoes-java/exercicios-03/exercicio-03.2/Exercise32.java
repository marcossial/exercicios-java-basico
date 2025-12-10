import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise32 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        Car car = new Car();
        while (true) {
            System.out.println("=== Painel de Controle do Carro ===");
            System.out.println("1. Ligar Carro");
            System.out.println("2. Desligar Carro");
            System.out.println("3. Acelerar [+1km/h]");
            System.out.println("4. Desacelerar [-1km/h]");
            System.out.println("5. Virar para esquerda [<-]");
            System.out.println("6. Virar para direita  [->]");
            System.out.println("7. Verificar velocidade [km/h]");
            System.out.println("8. Trocar marcha [0, 1, 2, 3, 4, 5, 6]");
            System.out.println("0. Terminar aplicação");
            System.out.println("==================================");


            short option;
            try {
                option = scanner.nextShort();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida.");
                scanner.next();
                continue;
            }
            switch (option) {
                case 0 -> System.exit(0);
                case 1 -> car.turnOn();
                case 2 -> car.turnOff();
                case 3 -> car.accelerate();
                case 4 -> car.deaccelerate();
                case 5 -> car.turnLeft();
                case 6 -> car.turnRight();
                case 7 -> car.verifySpeed();
                case 8 -> {
                    if (scanner.hasNextShort()) {
                        short gear = scanner.nextShort();
                        car.changeGear(gear);
                    } else {
                        System.out.println("Entrada inválida.");
                        scanner.next();
                    }
                }
                default -> System.out.println("Ação inválida.");
            }
        }
    }
}
