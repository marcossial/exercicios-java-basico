public class FamilyTicket extends Ticket{
    private final int familyMembers;

    public FamilyTicket(double basePrice, String movieTitle, boolean isDubbed, int familyMembers) {
        super(basePrice, movieTitle, isDubbed);
        if (familyMembers < 1) {
            throw new IllegalArgumentException("Quantidade de integrantes da familia deve ser maior que zero");
        }
        this.familyMembers = familyMembers;
    }

    @Override
    public double getRealPrice() {
        double realPrice = getBasePrice() * familyMembers;
        if (familyMembers > 3) {
            realPrice = realPrice - (realPrice * 0.05);
        }
        return realPrice;
    }

    public int getFamilyMembers() {
        return familyMembers;
    }

    @Override
    public String toString() {
        String discountApplied = familyMembers > 3 ? " (5% Desconto)" : "";
        return "Ingresso familia (" + familyMembers + " pessoas) " +
                discountApplied + super.toString() +
                String.format(" | preço final: %.2f%s", getRealPrice(), discountApplied);
    }
}
