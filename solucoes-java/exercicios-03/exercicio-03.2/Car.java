public class Car {
    private boolean turnedOn;
    private double speed;
    private short gear;

    public Car() {
        turnedOn = false;
        speed = 0.0;
        gear = 0;
    }

    public void turnOn() {
        if (!turnedOn) {
            System.out.println("Ligou o carro.");
            turnedOn = true;
        } else {
            System.out.println("Carro já está ligado.");
        }
    }

    public void turnOff() {
        if (!turnedOn) {
            System.out.println("Carro já está desligado.");
        } else if (gear == 0 && speed == 0) {
            System.out.println("Desligou o carro.");
            turnedOn = false;
        } else {
            System.out.println("Para desligar, primeiro deixe o carro imóvel e deixe em ponto morto.");
        }
    }

    public void accelerate() {
        if (!turnedOn) {
            System.out.println("Para acelerar, primeiro ligue o carro.");
            return;
        }
        if ((speed >= 0 && gear == 0)||(speed >= 20 && gear == 1) || (speed >= 40 && gear == 2) ||
            (speed >= 60 && gear == 3) || (speed >= 80 && gear == 4) || (speed >= 100 && gear == 5)) {
            System.out.printf("Limite da marcha atingido. Troque para a %d marcha.\n", gear + 1);
        } else {
            speed += 1;
            if (speed <= 120) {
                System.out.printf("Carro acelerou para %.1f km/h.\n", speed);
            } else {
                speed = 120;
                System.out.println("Carro atingiu o limite de 120 km/h.");
            }
        }
    }

    public void deaccelerate() {
        if (!turnedOn) {
            System.out.println("Para desacelerar, primeiro ligue o carro.");
            return;
        }
        if ((speed <= 21 && gear == 2) || (speed <= 41 && gear == 3) || (speed <= 61 && gear == 4) ||
            (speed <= 81 && gear == 5) || (speed <= 101 && gear == 6)) {
            System.out.printf("Limite da marcha atingido. Troque para a %d marcha.\n", gear - 1);
        } else {
            speed -= 1;
            if (speed > 0) {
                System.out.printf("Carro desacelerou para %.1f km/h.\n", speed);
            } else {
                speed = 0;
                System.out.println("Carro está imóvel.");
            }
        }
    }

    public void turnRight() {
        if (!turnedOn) {
            System.out.println("Para virar a direita, primeiro ligue o carro.");
            return;
        }
        if (speed > 40) {
            System.out.println("Impossível virar a direita, diminua a velocidade para 40 km/h.");
        } else if (speed <= 0) {
            System.out.println("Impossível virar a direita, carro está imóvel.");
        } else {
            System.out.println("O carro virou a direita.");
        }
    }

    public void turnLeft() {
        if (!turnedOn) {
            System.out.println("Para virar a esquerda, primeiro ligue o carro.");
            return;
        }
        if (speed > 40) {
            System.out.println("Impossível virar a esquerda, diminua a velocidade para 40 km/h.");
        } else if (speed <= 0) {
            System.out.println("Impossível virar a esquerda, carro está imóvel.");
        } else {
            System.out.println("O carro virou a esquerda.");
        }
    }

    public void verifySpeed() {
        if (speed != 0) {
            System.out.printf("Carro está se movendo a %.1f km/h.\n", speed);
        } else {
            System.out.println("Carro está imóvel.");
        }
    }

    public void changeGear(short gear) {
        if (!turnedOn) {
            System.out.println("Para trocar a marcha, primeiro ligue o carro.");
            return;
        }
        if (gear < 0 || gear > 6) {
            System.out.printf("O carro não possui uma %d marcha.\n", gear);
        } else {
            if (Math.abs(this.gear - gear) > 1) {
                System.out.printf("Não se pode pular da marcha %d pra %d.\n", this.gear, gear);
            } else {
                if (gear == 0 && speed != 0) {
                    System.out.println("Para deixar em ponto morto, primeiro pare o carro.");
                    return;
                }
                this.gear = gear;
                System.out.printf("Trocou para marcha %d.\n", this.gear);
            }
        }
    }
}
