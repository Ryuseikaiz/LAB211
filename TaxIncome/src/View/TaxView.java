package View;

import Common.Validation;
import Model.Child;
import Model.Dependent;
import Model.DependentType;
import Model.Income;
import Model.Parent;
import Model.Person;
import java.util.Scanner;

public class TaxView {

    private Scanner scanner;

    public TaxView() {
        scanner = new Scanner(System.in);
    }

    public Person getPersonDetails() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = Validation.getInt();
        System.out.print("Is only child (Y/N): ");
        boolean isOnlyChild = Validation.checkYN();

        return new Person(name, age, isOnlyChild);
    }

    public Income getIncomeDetails() {
        System.out.print("Enter income amount: ");
        double amount = Validation.getDouble();
        System.out.print("Enter income source: ");
        String source = scanner.nextLine();

        return new Income(amount, source);
    }

    public Dependent getDependentDetails() {
        System.out.print("Enter dependent type (1 for Child, 2 for Parent): ");
        int type = Validation.getInt();

        if (type == 1) {
            System.out.print("Enter child name: ");
            String name = scanner.nextLine();
            System.out.print("Enter child age: ");
            int age = Validation.getInt();
            System.out.print("Is child studying (Y/N): ");
            boolean isStudying = Validation.checkYN();

            return new Child(name, age, isStudying);
        } else {
            System.out.print("Enter parent name: ");
            String name = scanner.nextLine();
            System.out.print("Enter parent age: ");
            int age = Validation.getInt();
            System.out.print("Enter relationship: ");
            String relationship = scanner.nextLine();

            return new Parent(name, age, relationship);
        }
    }

    public int getIntInput(String message) {
        System.out.print(message);
        return Validation.getInt();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
