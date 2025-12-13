public class HalfPriceTicket extends Ticket{

    public HalfPriceTicket(double basePrice, String movieTitle, boolean isDubbed) {
        super(basePrice, movieTitle, isDubbed);
    }

    @Override
    public double getRealPrice() {
        return getBasePrice() / 2;
    }

    @Override
    public String toString() {
        return "Ingresso meia-entrada - " + super.toString() + String.format(" | preço final: %.2f", getRealPrice());
    }
}
