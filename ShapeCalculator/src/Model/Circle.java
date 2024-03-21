package Model;

public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    @Override
    public void printResult() {
        System.out.println("\n");
        System.out.println("-----Circle-----");
        System.out.println("Radius: " + String.format("%.2f", this.radius));
        System.out.println("Area: " + String.format("%.2f", getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", getPerimeter()));
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
