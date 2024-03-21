package Controller.service;

import Model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Inputter {

    private final static Scanner in = new Scanner(System.in);

    private static final String PHONE_VALID = "^\\d{10}\\d*$";

    private static final String EMAIL_VALID = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Input must not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Not valid");
            System.out.print("Enter again: ");
        }
    }

    public static String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(PHONE_VALID)) {
                return result;
            } else {
                System.err.println("Phone number not valid");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputEmail() {
        while (true) {
            String result = checkInputString();
            if (result.matches(EMAIL_VALID)) {
                return result;
            } else {
                System.err.println("Email not valid");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static int checkInputBirthYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < 1900 || result > currentYear) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Birth year not valid");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Not valid");
                System.out.print("Enter again: ");
            }
        }
    }

    public static boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exists.");
                return false;
            }
        }
        return true;
    }

    public static int checkInputExprience(int birthYear) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthYear;
        while (true) {
            int yearExperience = checkInputIntLimit(1, 100);
            if (yearExperience > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }
}
