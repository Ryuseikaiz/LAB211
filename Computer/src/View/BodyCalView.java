package View;

import Model.BodyCalModel;
import Common.Inputter;

public class BodyCalView {

    Inputter input = new Inputter();

    public BodyCalView() {
    }

    public void getInfoBody(BodyCalModel bodyModel) {
        bodyModel.setWeight(input.getInputDouble("Enter Weight(kg)"));
        bodyModel.setHeight(input.getInputDouble("Enter Height(cm)"));
    }

    public void calBMI(BodyCalModel bodyModel) {
        bodyModel.setBmi(bodyModel.getHeight(), bodyModel.getWeight());
        double bmi = bodyModel.getBmi();
        if (bmi >= 0 && bmi < 19) {
            bodyModel.setStatus("Under-standard");
        } else if (bmi < 25) {
            bodyModel.setStatus("Standard");
        } else if (bmi < 30) {
            bodyModel.setStatus("Overweight");
        } else if (bmi < 40) {
            bodyModel.setStatus("Fat - shold lose weight");
        } else {
            bodyModel.setStatus("Very-fat");
        }
    }

    public void showInfo(BodyCalModel bodyModel) {
        System.out.println("BMI Number: " + bodyModel.getBmi());
        System.out.println("BMI Status: " + bodyModel.getStatus());
    }
}
