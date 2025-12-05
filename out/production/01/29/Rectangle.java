public class Rectangle implements Shape {
    private double length;
    private double width;
    private String name;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.name = "矩形";
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    @Override
    public String getShapeName() {
        return name;
    }
    @Override
    public void displayInfo() {
        System.out.printf("图形: %s, 长: %.2f, 宽: %.2f, 面积: %.2f, 周长: %.2f%n",
                name, length, width, calculateArea(), calculatePerimeter());
    }
}