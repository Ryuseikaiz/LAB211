package utils;

import java.util.Scanner;

public class Inputter {

    private final Scanner sc = new Scanner(System.in);
    Validator valid = new Validator();

    public String getString(String msg) {
        System.out.print(msg + ": ");
        return sc.nextLine();
    }

    public int getInt(String msg) {
        int nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String n = sc.nextLine();
                nInt = Integer.parseInt(n);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Phone number must is number");
            }
        }
        return nInt;
    }

    public double getDouble(String msg) {
        double nInt = 0;
        try {
            System.out.print(msg + ": ");
            String n = sc.nextLine();
            nInt = Double.parseDouble(n);
        } catch (NumberFormatException e) {
            return 0;
        }

        return nInt;
    }

    public int getIntAcceptEnter(String msg) {
        int nInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.print(msg + ": ");
                String input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    isValidInput = true;
                } else {
                    nInt = Integer.parseInt(input);
                    isValidInput = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return nInt;
    }

    public int getIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public double getDoubleLimit(double min, double max) {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please enter within 8h - 17h30");
                System.out.print("Enter again: ");
            }
        }
    }

    public String getStringNotEmpty(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public String getTaskTypeName(String msg) {
        String taskTypeName = "";
        System.out.print(msg + ": ");
        int taskTypeId = getIntLimit(1, 4);
        switch (taskTypeId) {
            case 1:
                taskTypeName = "Code";
            case 2:
                taskTypeName = "Test";
            case 3:
                taskTypeName = "Design";
            case 4:
                taskTypeName = "Review";
        }
        return taskTypeName;
    }

    public String getDate(String msg) {
        while (true) {
            System.out.print(msg + ": ");
            String date = sc.nextLine().trim();
            if (!valid.isValidDate(date)) {
                System.out.println("Follow format dd-MM-yyyy");
            } else {
                return date;
            }
        }
    }

}