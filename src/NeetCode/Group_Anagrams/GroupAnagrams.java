package NeetCode.Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"", ""}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> returnList = new ArrayList<>();
        if (strs.length == 0) return returnList;
        if (strs.length == 1) {
            List<String> simpleList = new ArrayList<>();
            simpleList.add(strs[0]);
            returnList.add(simpleList);
            return returnList;
        }

        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) continue;
            List<String> newList = new ArrayList<>();
            newList.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j] == null) continue;
                if (isAnagram(strs[i], strs[j])) {
                    newList.add(strs[j]);
                    strs[j] = null;
                }
            }

            returnList.add(newList);
        }

        return returnList;
    }

    private static boolean isAnagram(String s, String t) {
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
