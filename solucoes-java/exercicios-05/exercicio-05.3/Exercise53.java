public class Exercise53 {
    public static void main(String[] args) {
        Shapes shapes = null;

        shapes = createSquare(3);
        System.out.println(shapes.getArea());

        shapes = createRectangle(2, 5);
        System.out.println(shapes.getArea());

        shapes = createCircle(7);
        System.out.println(shapes.getArea());
    }

    private static Shapes createSquare(double side) {
        return new Square(side);
    }

    private static Shapes createRectangle(double height, double width) {
        return new Rectangle(height, width);
    }

    private static Shapes createCircle(double radius) {
        return new Circle(radius);
    }
}
