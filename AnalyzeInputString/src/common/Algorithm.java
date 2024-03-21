package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.StringModel;

public class Algorithm {
    Validation validation=new Validation();
    StringModel stringModel= new StringModel(); 
    Scanner scanner = new Scanner(System.in);
    String inputString;
    
    public void input(){       
        System.out.print("Input string: ");
        inputString = scanner.nextLine();
        stringModel.setInputString(inputString);
    }
    
    public void result() {  
        System.out.println("-----Result Analysis------");
        HashMap<String, List<Integer>> hmNumber = new HashMap<>();
        HashMap<String, String> hmString = new HashMap<>();

        String number = stringModel.getInputString().replaceAll("\\D+", ",");
        if (!number.isEmpty()) {
            if (number.charAt(0) == ',') {
                number = number.substring(1);
            }
            if (!number.isEmpty() && number.charAt(number.length() - 1) == ',') {
                number = number.substring(0, number.length() - 1);
            }
        }

        String[] listNumber = number.isEmpty() ? new String[0] : number.split(",");
        int lenNumber = listNumber.length;

        List<Integer> liPerfectSquare = new ArrayList<>();
        List<Integer> liOdd = new ArrayList<>();
        List<Integer> liEven = new ArrayList<>();
        List<Integer> liAll = new ArrayList<>();
        for (int i = 0; i < lenNumber; i++) {
            int numberCheck = Integer.parseInt(listNumber[i]);
            if (numberCheck % 2 == 1) {
                liOdd.add(numberCheck);
            }
            if (numberCheck % 2 == 0) {
                liEven.add(numberCheck);
            }
            if (validation.checkSquareNumber(numberCheck)) {
                liPerfectSquare.add(numberCheck);
            }
            liAll.add(numberCheck);
        }
        hmNumber.put("Perfect Square Numbers: ", liPerfectSquare);
        hmNumber.put("Odd Numbers: ", liOdd);
        hmNumber.put("Even Numbers: ", liEven);
        hmNumber.put("All Numbers: ", liAll);

        String uppercase = stringModel.getInputString().replaceAll("\\W|[0-9]|[a-z]", "");
        String lowercase = stringModel.getInputString().replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = stringModel.getInputString().replaceAll("\\w", "");
        String allCharacter = stringModel.getInputString().replaceAll("\\W", "");
        hmString.put("Uppercase: ", uppercase);
        hmString.put("Lowercase: ", lowercase);
        hmString.put("Special: ", special);
        hmString.put("All Character: ", allCharacter);

        for (Map.Entry<String, List<Integer>> m : hmNumber.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        for (Map.Entry<String, String> m : hmString.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

