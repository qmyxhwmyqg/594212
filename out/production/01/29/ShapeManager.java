import java.util.ArrayList;
import java.util.List;
public class ShapeManager {
    private List<Shape> shapes;
    public ShapeManager() {
        shapes = new ArrayList<>();
    }
    public void addShape(Shape shape) {
        shapes.add(shape);
    }
    public void displayAllShapes() {
        System.out.println("=== 所有图形信息 ===");
        for (Shape shape : shapes) {
            shape.displayInfo();
        }
    }
    public double getTotalArea() {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculateArea();
        }
        return total;
    }
    public double getTotalPerimeter() {
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.calculatePerimeter();
        }
        return total;
    }
    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        Shape circle = new Circle(5.0);
        Shape rectangle = new Rectangle(4.0, 6.0);
        Shape triangle = new Triangle(3.0);
        manager.addShape(circle);
        manager.addShape(rectangle);
        manager.addShape(triangle);
        manager.displayAllShapes();
        System.out.printf("总面积: %.2f%n", manager.getTotalArea());
        System.out.printf("总周长: %.2f%n", manager.getTotalPerimeter());
        System.out.println("\n=== 多态特性演示 ===");
        Shape[] shapeArray = {circle, rectangle, triangle};
        for (Shape shape : shapeArray) {
            System.out.printf("%s的面积是: %.2f%n",
                    shape.getShapeName(), shape.calculateArea());
        }
    }
}