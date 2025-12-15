public class Product {
    private String name;
    private double price;
    private TaxFunction taxStrategy;

    public Product(String name, double price, TaxFunction taxStrategy) {
        this.name = name;
        this.price = price;
        this.taxStrategy = taxStrategy;
    }

    public double calculateTax() {
        return taxStrategy.apply(price);
    }

    @Override
    public String toString() {
        return String.format("Produto: %s | Preço %.2f | Imposto: R$ %.2f", name, price, calculateTax());
    }
}
