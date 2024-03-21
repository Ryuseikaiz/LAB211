package Common;
import java.util.Scanner;

public class Validation {
    private static final Scanner in = new Scanner(System.in);
    public static double checkInputDouble() {
        while (true) {
            try {
                return Double.parseDouble(in.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter again");
            }
        }
    }
}