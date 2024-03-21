
import Controller.ShapeController;
import Model.Circle;
import Model.Rectangle;
import Model.Triangle;
import View.ShapeView;

public class Main {

    public static void main(String[] args) {
        ShapeView view = new ShapeView();
        System.out.println("=====Calculator Shape Program=====");
        Rectangle rectangle = view.inputRectangle();
        Circle circle = view.inputCircle();
        Triangle triangle = view.inputTriangle();
        ShapeController.display(rectangle, circle, triangle);
    }
}
