package Common;

public class Validation {

    private final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";

    public boolean checkInt(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid number Int");
            return false;
        }
    }

    public boolean isValidPhone(String num) {
        if (num.matches(VALID_PHONE)) {
            return true;
        }
        return false;
    }
}
