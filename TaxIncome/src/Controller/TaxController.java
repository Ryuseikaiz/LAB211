package Controller;

import View.Menu;
import View.TaxView;
import java.util.ArrayList;
import java.util.List;
import Model.Dependent;
import Model.Income;
import Model.Person;

public class TaxController extends Menu {

    private final TaxView view;
    static String[] options = {"Proceed to calculate tax", "Exit"};

    public TaxController() {
        super("========== Tax Calculating Program =========", options);
        view = new TaxView();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                Person person = view.getPersonDetails();
                List<Income> incomes = new ArrayList<>();
                List<Dependent> dependents = new ArrayList<>();

                int numIncomes = view.getIntInput("Enter number of incomes: ");
                for (int i = 0; i < numIncomes; i++) {
                    incomes.add(view.getIncomeDetails());
                }
                person.setIncomes(incomes);

                int numDependents = view.getIntInput("Enter number of dependents: ");
                for (int i = 0; i < numDependents; i++) {
                    dependents.add(view.getDependentDetails());
                }
                person.setDependents(dependents);

                double taxableIncome = person.calculateTaxableIncome();
                double taxAmount = person.calculateTaxAmount();

                System.out.printf("Taxable Income: %.2f VND%n", taxableIncome);
                System.out.printf("Tax Amount: %.2f VND%n", taxAmount);
                break;
            case 2:
                System.out.println("Exit.");
                break;
            default:
                System.out.println("Invalid!");
        }
    }
}
