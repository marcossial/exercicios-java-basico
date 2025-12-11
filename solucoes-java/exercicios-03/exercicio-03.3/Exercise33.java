import java.util.Scanner;

public class Exercise33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetWasher petWasher = new PetWasher();
        while (true) {
            System.out.println("Painel de Controle PetWasher");
            System.out.println("1. Dar banho no pet");
            System.out.println("2. Abastecer máquina com Água");
            System.out.println("3. Abastecer máquina com Shampoo");
            System.out.println("4. Verificar nível da Água");
            System.out.println("5. Verificar nível do Shampoo");
            System.out.println("6. Verificar se há pet na máquina");
            System.out.println("7. Colocar pet na máquina");
            System.out.println("8. Retirar pet na máquina");
            System.out.println("9. Limpar máquina");
            System.out.println("0. Encerrar programa");

            short option;
            if (scanner.hasNextShort()) {
                option = scanner.nextShort();
            } else {
                System.out.println("Entrada inválida");
                scanner.next();
                continue;
            }

            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    if(petWasher.showerPet()) {
                        System.out.printf("%s limpo(a) com sucesso\n", petWasher.getPet().getName());
                    }
                break;
                case 2:
                    petWasher.fillWater();
                break;
                case 3:
                    petWasher.fillShampoo();
                break;
                case 4:
                    System.out.printf("Máquina atualmente com %.1fl de água\n", petWasher.waterLevel());
                break;
                case 5:
                    System.out.printf("Máquina atualmente com %.1fl de shampoo\n", petWasher.shampooLevel());
                break;
                case 6:
                    if (petWasher.hasPet()) {
                        System.out.printf("Máquina atualmente ocupada por %s\n", petWasher.getPet().getName());
                    } else {
                        System.out.println("Máquina atualmente desocupada");
                    }
                break;
                case 7:
                    if (!petWasher.hasPet()) {
                        System.out.print("Insira o nome do pet: ");
                        if (scanner.hasNext()) {
                            scanner.nextLine();
                        }
                        String petName = scanner.nextLine();
                        petWasher.putPet(new Pet(petName));
                        System.out.printf("%s inserido na máquina\n", petName);
                    } else {
                        System.out.printf("Máquina ocupada, remova %s\n", petWasher.getPet().getName());
                    }
                break;
                case 8:
                    if (!petWasher.hasPet()) {
                        System.out.println("Máquina já está desocupada");
                    } else {
                        System.out.printf("Removendo %s...\n", petWasher.getPet().getName());
                        petWasher.removePet();
                    }
                break;
                case 9:
                    petWasher.cleanWasher();
                break;
                default:
                    System.out.println("Ação inválida");
                break;
            }
        }
    }
}
