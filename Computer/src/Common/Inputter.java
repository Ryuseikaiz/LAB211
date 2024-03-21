package Common;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Inputter {
    private final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/^=]");
    Scanner sc = new Scanner(System.in);

    public double getInputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number");
            }

        }
    }
    
    public String getOperator(String msg){
        while (true) {
            System.out.print(msg + ": ");
            String operator = sc.nextLine().trim();
            if (operator.isEmpty()) {
                System.err.println("Input cannot be empty");
            } else if (OPERATOR_PATTERN.matcher(operator).matches()) {
                return operator;
            } else {
                System.out.println("Please input (+, -, *, /, ^, =)");
            }
        }
    }
}