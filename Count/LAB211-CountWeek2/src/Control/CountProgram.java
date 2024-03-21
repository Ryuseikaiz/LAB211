/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Control.algorithm.Count;
import Model.Text;
import View.Menu;
import java.util.Scanner;

/**
 *
 * @author HELLO
 */
public class CountProgram extends Menu<String> {

    private Count countController;
    private Scanner scanner;
    private Text text;

    public CountProgram() {
        super("Count Program", new String[]{"Enter a string", "Count words", "Count characters", "Exit"});
        countController = new Count();
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.println("Enter a string:");
                text = new Text(scanner.nextLine());
                break;
            case 2:
                if (text != null) {
                    var result = countController.countWords(text.getContent());
                    System.out.println("Word counts: " + result);
                } else {
                    System.out.println("Please enter a string first!");
                }
                break;
            case 3:
                if (text != null) {
                    var result = countController.countCharacters(text.getContent());
                    System.out.println("Character counts: " + result);
                } else {
                    System.out.println("Please enter a string first!");
                }
                break;
            case 4:
                System.out.println("Exiting.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }
}
