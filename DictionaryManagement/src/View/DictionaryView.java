package View;

import Repository.Validation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import Model.DictionaryMap;

public class DictionaryView {

    private DictionaryMap dictionaryMap;

    public DictionaryView() {
        this.dictionaryMap = new DictionaryMap();
    }

    public void addWord() {
        System.out.println("------------- Add -------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (!checkKeywordExist(english)) {
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        dictionaryMap.addWord(english, vietnam);
        System.err.println("Successfully Added .");
        System.out.println("\n");
    }

    public void removeWord() {
        System.out.println("------------ Delete ----------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        dictionaryMap.removeWord(english);
        System.err.println("Successfully Deleted .");
        System.out.println("\n");
    }

    public void translate() {
        System.out.println("------------- Translate ------------");
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        String vietnamese = dictionaryMap.translate(english);
        if (vietnamese != null) {
            System.out.println("Vietnamese: " + vietnamese);
        } else {
            System.err.println("Not found");
        }
    }

    public boolean checkKeywordExist(String english) {
        return !dictionaryMap.containsKey(english);
    }
}
