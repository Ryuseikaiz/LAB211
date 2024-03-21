package Controller;

import Model.BodyCalModel;
import Model.CalcModel;
import View.BodyCalView;
import View.CalcView;
import View.Menu;

public class ComputerController extends Menu {

    public ComputerController() {
        super("=========== Calculator Program ===========", new String[]{"Normal Calculator", "BMI Calculator", "Exit"});
    }

    CalcView calView = new CalcView();
    CalcModel calModel = new CalcModel();

    BodyCalView bodyView = new BodyCalView();
    BodyCalModel bodyModel = new BodyCalModel();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                calView.normalCalculator(calModel);
                break;
            case 2:
                bodyView.getInfoBody(bodyModel);
                bodyView.calBMI(bodyModel);
                bodyView.showInfo(bodyModel);
                break;
            case 3:
                System.exit(0);
                break;
        }
    }

}
