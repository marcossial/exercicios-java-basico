public class Exercise41 {
    public static void main(String[] args) {
        StandardTicket standardTicket = new StandardTicket(20, "Shrek 5", true);
        System.out.println(standardTicket);

        HalfPriceTicket halfPriceTicket = new HalfPriceTicket(20, "Shrek 5", true);
        System.out.println(halfPriceTicket);

        FamilyTicket familyTicket1 = new FamilyTicket(20, "Shrek 5", true, 3);
        System.out.println(familyTicket1);

        FamilyTicket familyTicket2 = new FamilyTicket(20, "Shrek 5", true, 4);
        System.out.println(familyTicket2);

    }
}
