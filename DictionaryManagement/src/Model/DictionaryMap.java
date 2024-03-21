package Model;

import java.util.HashMap;
import java.util.Map;

public class DictionaryMap {

    private Map<String, String> dictionary = new HashMap<>();

    public void addWord(String word, String translation) {
        dictionary.put(word, translation);
    }

    public void removeWord(String word) {
        dictionary.remove(word);
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public boolean containsKey(String key) {
        return dictionary.containsKey(key);
    }
}
