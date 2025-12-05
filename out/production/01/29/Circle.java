public class Circle implements Shape {
    private double radius;
    private String name;
    public Circle(double radius) {
        this.radius = radius;
        this.name = "圆形";
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public String getShapeName() {
        return name;
    }
    @Override
    public void displayInfo() {
        System.out.printf("图形: %s, 半径: %.2f, 面积: %.2f, 周长: %.2f%n",
                name, radius, calculateArea(), calculatePerimeter());
    }
}
