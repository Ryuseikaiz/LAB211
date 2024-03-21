package View;

import Model.CalcModel;
import Common.Inputter;

public class CalcView {

    Inputter input = new Inputter();

    public CalcView() {
    }

    public void normalCalculator(CalcModel calModel) {
        System.out.println("-------- Normal Calculator -------");
        calModel.setNum1(input.getInputDouble("Enter number"));
        calModel.setTempMem(calModel.getNum1());
        boolean flag = true;
        while (flag) {
            String operator = input.getOperator("Enter Operator");
            switch (operator) {
                case "+":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() + calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "-":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() - calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "*":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() * calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "/":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(calModel.getTempMem() / calModel.getNum2());
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "^":
                    calModel.setNum2(input.getInputDouble("Enter number"));
                    calModel.setTempMem(Math.pow(calModel.getTempMem(), calModel.getNum2()));
                    System.out.println("Memory: " + calModel.getTempMem());
                    break;
                case "=":
                    System.out.println("Result: " + calModel.getTempMem());
                    flag = false;
                    break;
            }
        }
    }
}
