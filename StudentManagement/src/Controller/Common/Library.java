/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Common;

import java.util.Scanner;

/**
 *
 * @author HELLO
 */
public class Library {
    protected Scanner sc;
    
    public Library() {
        sc = new Scanner(System.in);
    }
    
    public String getString (String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
    
    public int getInt (String st, int x, int y) {
        int a = -1;
        while (true) {
            System.out.print(st + ": ");
            try{
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= x && a <= y) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between" + x + " and " + y);
            }
        }
        return a;
    }
}
