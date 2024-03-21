package Controller;

import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.ShapeView;

public class ShapeController {

    ShapeView view = new ShapeView();
    Rectangle rectangle = view.inputRectangle();
    Circle circle = view.inputCircle();
    Triangle triangle = view.inputTriangle();

    public static void display(Rectangle rectangle, Circle circle, Triangle triangle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
