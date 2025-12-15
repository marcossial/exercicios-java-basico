public record Rectangle(double height, double width) implements Shapes {
    @Override
    public double getArea() {
        return height * width;
    }
}
