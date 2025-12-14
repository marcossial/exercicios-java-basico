public class Exercise43 {
    public static void main(String[] args) {
        Clock brazilianClock = new BrazilianClock(0, 20, 40);
        System.out.println(brazilianClock);

        Clock americanClock = new AmericanClock(14, 20, 40);
        System.out.println(americanClock);

        americanClock.setTime(new BrazilianClock(12, 30, 0));
        brazilianClock.setTime(new AmericanClock(15, 0, 20));

        System.out.println(americanClock);
        System.out.println(brazilianClock);
    }
}
