public record Square(double side) implements Shapes {
    public double getArea() {
        return Math.pow(side, 2);
    }
}
