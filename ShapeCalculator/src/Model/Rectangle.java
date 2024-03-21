package Model;

public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public void printResult() {
        System.out.println("\n");
        System.out.println("-----Rectangle-----");
        System.out.println("Width: " + String.format("%.2f", width));
        System.out.println("Length: " + String.format("%.2f", length));
        System.out.println("Area: " + String.format("%.2f", getArea()));
        System.out.println("Perimeter: " + String.format("%.2f", getPerimeter()));
    }
}
