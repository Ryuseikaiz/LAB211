package View;

import Common.Inputter;
import Common.Validator;
import java.util.ArrayList;
import Model.QuadraEqual;
import Model.SuperEqual;

public class EquationView {

    Inputter inputter = new Inputter();
    Validator val = new Validator();

    public void getCoefficientsSuperlative(SuperEqual sper) {
        System.out.println("\n------- Calculate Equation --------");
        sper.setA(inputter.getInputFloat("Enter A"));
        sper.setB(inputter.getInputFloat("Enter B"));
    }

    public void superlativeEquation(SuperEqual sper) {
        float a = sper.getA();
        float b = sper.getB();
        sper.setX(-b / a);
        float x = sper.getX();
        System.out.println("Solution: x=" + x);
        System.out.print("Number is odd: ");
        ArrayList<Float> arr = new ArrayList();
        arr.add(a);
        arr.add(b);
        arr.add(x);
        System.out.print("Number is odd: ");
        for (float num : arr) {
            if (val.checkOdd(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is even: ");
        for (float num : arr) {
            if (val.checkEven(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        for (float num : arr) {
            if (val.checkSquareNumber(num)) {
                System.out.print(num + " ");
            }
        }
    }

    public void getCoefficientsQuadratic(QuadraEqual quad) {
        System.out.println("\n------- Calculate Quadratic Equation --------");
        quad.setA(inputter.getInputFloat("Enter A"));
        quad.setB(inputter.getInputFloat("Enter B"));
        quad.setC(inputter.getInputFloat("Enter C"));
    }

    public void quadraticEquation(QuadraEqual quad) {
        float a = quad.getA();
        float b = quad.getB();
        float c = quad.getC();
        float delta = b * b - 4 * a * c;            
        quad.setX1((float) (-b + Math.sqrt(delta)) / (2 * a));
        quad.setX2((float) (-b - Math.sqrt(delta)) / (2 * a));
        float x1 = quad.getX1();
        float x2 = quad.getX2();
        System.out.println("Solution: x1 = " + x1 + " and x2 = " + x2);
        ArrayList<Float> arr = new ArrayList();
        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(x1);
        arr.add(x2);
        System.out.print("Number is odd: ");
        for (float num : arr) {
            if (val.checkOdd(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is even: ");
        for (float num : arr) {
            if (val.checkEven(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.print("Number is perfect square: ");
        for (float num : arr) {
            if (val.checkSquareNumber(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}