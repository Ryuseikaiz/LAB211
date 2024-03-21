package Common;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    private final Pattern OPERATOR_PATTERN = Pattern.compile("[+\\-*/^=]");

    public boolean validOperator(String operator) {
        while (true) {
            if (operator.isEmpty()) {
                System.err.println("Input cannot be empty");
            } else if (OPERATOR_PATTERN.matcher(operator).matches()) {
                return true;
            } else {
                System.err.println("Please input (+, -, *, /, ^, =)");
            }
            System.out.print("Enter Operator: ");
        }
    }
}
