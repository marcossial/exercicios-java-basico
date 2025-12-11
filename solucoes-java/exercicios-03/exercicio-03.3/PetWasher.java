public class PetWasher {
    private Pet pet;
    private double shampoo;
    private double water;
    private boolean clean;

    public PetWasher() {
        shampoo = 10;
        water = 30;
        clean = true;
    }

    public boolean showerPet() {
        if (!hasPet()) {
            System.out.println("Máquina vazia, não há pet para dar banho");
            return false;
        } else {
            if (!pet.isClean()) {
                pet.setClean();
                water -= 10;
                shampoo -= 2;
                return true;
            } else {
                System.out.printf("%s já está limpo\n", pet.getName());
                return false;
            }
        }
    }

    public void fillWater() {
        water += 2;
        if (water >= 30) {
            water = 30;
            System.out.println("Limite de 30l de água atingido");
        } else {
            System.out.printf("Encheu o tanque. Máquina está com %.1fl de água\n", water);
        }
    }

    public void fillShampoo() {
        shampoo += 2;
        if (shampoo >= 10) {
            shampoo = 10;
            System.out.println("Limite de 10l de shampoo atingido");
        } else {
            System.out.printf("Encheu o tanque. Máquina está com %.1fl de shampoo\n", shampoo);
        }
    }

    public double waterLevel() {
        return water;
    }

    public double shampooLevel() {
        return shampoo;
    }

    public boolean hasPet() {
        return pet != null;
    }

    public void putPet(Pet pet) {
        if (!clean) {
            System.out.println("Máquina suja, realize a limpeza primeiro");
            return;
        }
        this.pet = pet;
    }

    public void removePet() {
        clean = pet.isClean();
        pet = null;
    }

    public void cleanWasher() {
        if (!clean) {
            water -= 3;
            shampoo -= 1;
            clean = true;
        } else {
            System.out.println("Máquina já está limpa");
        }
    }

    public Pet getPet() {
        return pet;
    }

}
