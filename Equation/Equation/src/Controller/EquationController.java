package Controller;

import Model.QuadraEqual;
import Model.SuperEqual;
import View.Menu;
import View.EquationView;

public class EquationController extends Menu {

    public EquationController() {
        super("======== Equation Program ========", new String[]{"Superlative Equation", "Quadratic Equation", "Exit"});
    }

    SuperEqual sper = new SuperEqual();
    QuadraEqual quad = new QuadraEqual();
    EquationView eView = new EquationView();

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                eView.getCoefficientsSuperlative(sper);
                eView.superlativeEquation(sper);
                break;
            case 2:
                eView.getCoefficientsQuadratic(quad);
                eView.quadraticEquation(quad);
                break;
            case 3:
                System.exit(0);
                break;
            default:
                break;

        }
    }
}