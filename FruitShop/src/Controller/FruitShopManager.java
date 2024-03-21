/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Common.Library;
import Model.Fruit;
import Model.Order;
import View.Menu;
import java.util.ArrayList;

/**
 *
 * @author HELLO
 */
public class FruitShopManager extends Menu<String> {

    private ArrayList<Fruit> createdFruits = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Fruit> availableFruits = new ArrayList<>();

    static String[] menu = {"Create Fruit", "View orders", "Shopping (for buyer)", "Exit"};
    Library lb;

    public FruitShopManager() {
        super("FRUIT SHOP SYSTEM", menu);
        lb = new Library();
        availableFruits.add(new Fruit(1, "Coconut", 2.0, 99, "Vietnam"));
        availableFruits.add(new Fruit(2, "Orange", 3.0, 99, "US"));
        availableFruits.add(new Fruit(3, "Apple", 4.0, 99, "Thailand"));
        availableFruits.add(new Fruit(4, "Grape", 6.0, 99, "France"));
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                createFruit();
                break;
            case 2:
                viewOrders();
                break;
            case 3:
                shopping();
                break;
            case 4:
                System.out.println("Exiting.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid selection. Please choose a valid option.");
        }
    }

    public void createFruit() {
        int fruitId = createdFruits.size() + 1;
        String fruitName = lb.getString("Enter the name of the fruit: ");
        double price = lb.getDouble("Enter the price of the fruit", 0, Double.MAX_VALUE);
        int quantity = lb.getInt("Enter the quantity of the fruit", 0, Integer.MAX_VALUE);
        String origin = lb.getString("Enter the origin of the fruit: ");

        Fruit newFruit = new Fruit(fruitId, fruitName, price, quantity, origin);
        createdFruits.add(newFruit);
        availableFruits.add(newFruit);

        System.out.println("Fruit created successfully!");

        char continueChoice = lb.getChar("Do you want to continue (Y/N)? ");
        if (continueChoice == 'Y' || continueChoice == 'y') {
            createFruit();
        }
    }

    private void displayFruits() {
        for (Fruit fruit : createdFruits) {
            System.out.println(fruit);
        }
    }

    private void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            System.out.println("List of Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    private void shopping() {
        System.out.println("List of Fruit:");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
        for (int i = 0; i < availableFruits.size(); i++) {
            Fruit fruit = availableFruits.get(i);
            System.out.printf("%15d %21s %16s %16.2f$%n", i + 1, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
        }

        int selectedFruitIndex = lb.getInt("Select a fruit (Enter the Item number)", 1, availableFruits.size()) - 1;
        Fruit selectedFruit = availableFruits.get(selectedFruitIndex);

        System.out.println("You selected: " + selectedFruit.getFruitName());

        int quantity = lb.getInt("Please input quantity", 1, Integer.MAX_VALUE);

        System.out.println("Do you want to order now (Y/N)?");
        char orderChoice = lb.getChar("");

        if (orderChoice == 'Y' || orderChoice == 'y') {
            processOrder(selectedFruit, quantity);
        } else {
            shopping();
        }
    }

    private void processOrder(Fruit selectedFruit, int quantity) {
        if (quantity > selectedFruit.getQuantity()) {
            System.out.println("Sorry, not enough quantity of " + selectedFruit.getFruitName() + " available.");
            return;
        }

        System.out.printf("Product | Quantity | Price | Amount%n");
        System.out.printf("%-10s %8d %10.2f$ %10.2f$%n",
                selectedFruit.getFruitName(), quantity, selectedFruit.getPrice(), quantity * selectedFruit.getPrice());

        double totalAmount = quantity * selectedFruit.getPrice();
        System.out.println("Total: " + totalAmount + "$");

        String customerName = lb.getString("Input your name: ");

        ArrayList<Fruit> selectedFruits = new ArrayList<>();
        selectedFruits.add(new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(), selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));
        Order order = new Order(customerName, selectedFruits);
        orders.add(order);

        selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

        System.out.println("Order placed successfully!");
    }
}
