package common;

import java.util.Scanner;

public class Validation {
    Scanner in = new Scanner(System.in);
    
    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public boolean checkSquareNumber(int n) {
        if (Math.sqrt(n) * Math.sqrt(n) == n) {
            return true;
        }
        return false;
    }
}
