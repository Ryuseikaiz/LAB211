/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author HELLO
 */
public class Order {

    private String customerName;
    private ArrayList<Fruit> fruits;

    public Order(String customerName, ArrayList<Fruit> fruits) {
        this.customerName = customerName;
        this.fruits = fruits;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public double calculateTotal() {
        double total = 0;
        for (Fruit fruit : fruits) {
            total += fruit.getPrice() * fruit.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder orderDetails = new StringBuilder("Customer: " + customerName + "\n");
        orderDetails.append("Product | Quantity | Price | Amount\n");
        
        for (int i = 0; i < fruits.size(); i++) {
            Fruit fruit = fruits.get(i);
            orderDetails.append(String.format("%d. %-15s %8d %10.2f$ %10.2f$%n",
                    i + 1, fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity()));
        }

        orderDetails.append("Total: ").append(calculateTotal()).append("$\n");

        return orderDetails.toString();
    }

}
