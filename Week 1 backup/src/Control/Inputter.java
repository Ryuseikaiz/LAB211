/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.util.Scanner;

/**
 *
 * @author HELLO
 */
public class Inputter {

    private static final Scanner sc = new Scanner(System.in);

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input a positive number!");
                System.out.print("Enter again: ");
            }
        }
    }
}
