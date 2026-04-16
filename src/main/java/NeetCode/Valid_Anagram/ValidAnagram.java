package NeetCode.Valid_Anagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("jar", "jam"));
        System.out.println(isAnagram("racecar", "carrace"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }

        for (Integer ele : map.values()) {
            if (ele != 0) {
                return false;
            }
        }

        return true;
    }
}
