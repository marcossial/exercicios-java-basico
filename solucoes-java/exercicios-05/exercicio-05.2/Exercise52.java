import java.util.List;

public class Exercise52 {
    public static void main(String[] args) {
        // Alimentação
        Product p1 = new Product("2kg Arroz", 13, price -> price * 0.01);
        // Saúde e bem-estar
        Product p2 = new Product("Vitamina C", 50, price -> price * 0.015);
        // Vestuário
        Product p3 = new Product("Calça", 139.89, price -> price * 0.025);
        // Cultura
        Product p4 = new Product("Livro", 96.69, price -> price * 0.04);

        List<Product> products = List.of(p1, p2, p3, p4);
        products.forEach((p) -> System.out.println(p));
    }
}
