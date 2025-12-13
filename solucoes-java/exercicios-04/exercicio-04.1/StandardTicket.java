public class StandardTicket extends Ticket{

    public StandardTicket(double basePrice, String movieTitle, boolean isDubbed) {
        super(basePrice, movieTitle, isDubbed);
    }

    @Override
    public double getRealPrice() {
        return super.getBasePrice();
    }

    @Override
    public String toString() {
        return "Ingresso padrão - " + super.toString() + String.format(" | preço final: %.2f", getRealPrice());
    }
}
