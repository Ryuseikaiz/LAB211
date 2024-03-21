package Controller;

import Model.Expense;
import View.ExpenseView;
import java.util.ArrayList;
import java.util.List;

public class ExpenseController {
    private List<Expense> expenses = new ArrayList<>();
    private ExpenseView view = new ExpenseView();

    public void start() {
        while (true) {
            System.out.print("=======Handy Expense program======\n");
            int option = view.getMenuOption();
            switch (option) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    displayAllExpenses();
                    break;
                case 3:
                    removeExpense();
                    break;
                case 4:
                    return;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    private void addExpense() {
        String date = view.getDate();
        double amount = view.getAmount();
        String content = view.getContent();
        expenses.add(new Expense(date, amount, content));
    }

    private void displayAllExpenses() {
    double total = 0;
    view.displayMessage("---------Display all expenses------------");
    view.displayMessage("ID\tDate\tAmount\tContent");
    for (Expense expense : expenses) {
        view.displayExpense(expense);
        total += expense.getAmount();
    }
    view.displayTotal(total);
}

    private void removeExpense() {
        int id = view.getExpenseId();
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getId() == id) {
                expenses.remove(i);
                view.displayMessage("Delete an expense successful");
                return;
            }
        }
        view.displayMessage("Delete an expense fail");
    }
}