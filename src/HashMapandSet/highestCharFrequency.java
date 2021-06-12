package HashMapandSet;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class highestCharFrequency {
    //Time Complexity: 0(n)
    //Space Complexity: 0(n)
    static char highestfreq(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        //store frequency in hashmap
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charMap.containsKey(ch)) {
                int count = charMap.get(ch);
                count++;
                charMap.put(ch, count);
            } else {
                charMap.putIfAbsent(ch, 1);
            }
        }

        //traverse over hashmap and max freq
        Set<Character> keys = charMap.keySet();

        int maxFreq = Integer.MIN_VALUE;
        char maxChar = ' ';

        for (char key : keys) {
            if (charMap.get(key) > maxFreq) {
                maxFreq = charMap.get(key);
                maxChar = key;
            }
        }

        return maxChar;

    }

    public static void main(String[] args) {

    }
}
