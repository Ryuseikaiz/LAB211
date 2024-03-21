package Model;

public class Expense {
    private static int idCounter = 0;
    private int id;
    private String date;
    private double amount;
    private String content;

    public Expense(String date, double amount, String content) {
        this.id = ++idCounter;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getContent() {
        return content;
    }
}