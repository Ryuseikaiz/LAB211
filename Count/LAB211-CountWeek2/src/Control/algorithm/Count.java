/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author HELLO
 */
public class Count {

    public Map<String, Integer> countWords(String input) {
        Map<String, Integer> result = new HashMap<>();

        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String word = st.nextToken().toLowerCase();
            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        return result;
    }

    public Map<String, Integer> countCharacters(String input) {
        Map<String, Integer> result = new HashMap<>();

        for (char c : input.toLowerCase().toCharArray()) {
            String character = String.valueOf(c);
            if (!Character.isWhitespace(c)) {
                result.put(character, result.getOrDefault(character, 0) + 1);
            }
        }

        return result;
    }
}
