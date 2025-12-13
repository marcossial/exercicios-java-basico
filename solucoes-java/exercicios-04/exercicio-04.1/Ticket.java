public abstract class Ticket {
    private final double basePrice;
    private final String movieTitle;
    private final boolean isDubbed;

    public Ticket(double basePrice, String movieTitle, boolean isDubbed) {
        this.basePrice = basePrice;
        this.movieTitle = movieTitle;
        this.isDubbed = isDubbed;
    }

    public abstract double getRealPrice();

    public double getBasePrice() {
        return basePrice;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getLanguageInfo() {
        return isDubbed ? "Dubbed" : "Subtitled";
    }

    @Override
    public String toString() {
        return String.format("Título do Filme: %s (%s) | preço base: R$ %.2f", movieTitle, getLanguageInfo(), basePrice);
    }
}
