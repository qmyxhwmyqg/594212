public class Triangle implements Shape {
    private double side;
    private String name;
    public Triangle(double side) {
        this.side = side;
        this.name = "三角形";
    }
    @Override
    public double calculateArea() {
        return Math.sqrt(3) / 4 * side * side;
    }
    @Override
    public double calculatePerimeter() {
        return 3 * side;
    }
    @Override
    public String getShapeName() {
        return name;
    }
    @Override
    public void displayInfo() {
        System.out.printf("图形: %s, 边长: %.2f, 面积: %.2f, 周长: %.2f%n",
                name, side, calculateArea(), calculatePerimeter());
    }
}