package View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class BankView {

    private final Scanner in = new Scanner(System.in);

    private final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
    private final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};

    String checkInputString(Locale language) {
        while (true) {
            String result = in.nextLine();
            if (result.length() == 0) {
                getWordLanguage(language, "errCheckInputIntLimit");
                System.out.println();
            } else {
                return result;
            }
        }
    }

    public int checkInputAccount(Locale language) {
        String result = in.nextLine();
        if (result.matches(ACCOUNT_NUMBER_VALID)) {
            return Integer.parseInt(result);
        } else {
            getWordLanguage(language, "errCheckInputAccount");
            System.out.println();
            return -1;
        }
    }

    public String checkInputPassword(Locale language) {
        String result = checkInputString(language);
        if (isValidPassword(result, language)) {
            return result;
        } else {
            return null;
        }
    }

    boolean isValidPassword(String password, Locale language) {
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {
            getWordLanguage(language, "errCheckLengthPassword");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            for (int i = 0; i < lengthPassword; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {
                getWordLanguage(language, "errCheckAlphanumericPassword");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    public boolean checkInputCaptcha(String captchaGenerated, Locale language) {
        System.out.println(captchaGenerated);
        getWordLanguage(language, "enterCaptcha");
        String captchaInput = checkInputString(language);
        return captchaGenerated.equals(captchaInput);
    }

    String generateCaptchaText() {
        String randomStrValue = "";
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }

    void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words = ResourceBundle.getBundle("Resources/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }

    public void LoginBank(Locale language) {
        int accountNumber;
        do {
            getWordLanguage(language, "enterAccountNumber");
            accountNumber = checkInputAccount(language);
        } while (accountNumber == -1);
        String passString;
        do {
            getWordLanguage(language, "enterPassword");
            passString = checkInputPassword(language);
        } while (passString == null);

        String captchaGenerated;
        boolean isCaptchaCorrect;
        do {
            captchaGenerated = generateCaptchaText();
            isCaptchaCorrect = checkInputCaptcha(captchaGenerated, language);
        } while (!isCaptchaCorrect);

        getWordLanguage(language, "loginSuccess");
        System.out.println();
    }
}
