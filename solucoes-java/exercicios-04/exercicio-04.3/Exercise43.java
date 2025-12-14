public class Exercise43 {
    public static void main(String[] args) {
        Clock brazilianClock = new BrazilianClock(12, 0 , 1);
        Clock americanClock = new AmericanClock(12, 0, 1);

        System.out.println("BR: " + brazilianClock);
        System.out.println("US: " + americanClock);

        americanClock.setTime(brazilianClock);
        brazilianClock.setTime(americanClock);

        System.out.println("BR: " + brazilianClock);
        System.out.println("US: " + americanClock);
    }
}
