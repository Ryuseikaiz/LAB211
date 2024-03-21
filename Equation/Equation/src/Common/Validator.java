package Common;

public class Validator {

    public boolean checkOdd(double n) {
        if (n % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkSquareNumber(double n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return true;
        } else {
            return false;
        }
    }
}
