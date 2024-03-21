package View;

import Model.Expense;
import java.util.Scanner;

public class ExpenseView {

    private Scanner scanner = new Scanner(System.in);

    public int getMenuOption() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
        System.out.println("Your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String getDate() {
        System.out.println("Enter date:");
        return scanner.next();
    }

    public double getAmount() {
        System.out.println("Enter amount:");
        return scanner.nextDouble();
    }

    public String getContent() {
        System.out.println("Enter content:");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public int getExpenseId() {
        System.out.println("Enter expense ID:");
        return scanner.nextInt();
    }

    public void displayExpense(Expense expense) {
        System.out.println(expense.getId() + "\t" + expense.getDate() + "\t" + expense.getAmount() + "\t" + expense.getContent());
    }

    public void displayTotal(double total) {
        System.out.println("Total: " + total);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

}
