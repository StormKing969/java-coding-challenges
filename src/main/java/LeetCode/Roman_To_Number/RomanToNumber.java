package LeetCode.Roman_To_Number;

import java.util.Map;

public class RomanToNumber {
    public static void main(String[] args) {
        System.out.println("III => 3 = " + romanToInt("III"));
        System.out.println("IV => 4 = " + romanToInt("IV"));
        System.out.println("LVIII => 58 = " + romanToInt("LVIII"));
        System.out.println("MCMXCIV => 1994 = " + romanToInt("MCMXCIV"));
        System.out.println("DCXXI => 621 = " + romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        int value = 0;
        Map<Character, Integer> map = Map.of(
                'I', 1, 'V', 5, 'X', 10,
                'L', 50, 'C', 100, 'D', 500, 'M', 1000
        );

        for (int i = 0; i < s.length(); i++) {
           if (i == s.length() - 1) {
               value += map.get(s.charAt(i));
           } else {
               if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                   value -= map.get(s.charAt(i));
               } else if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                   value -= map.get(s.charAt(i));
               } else if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                   value -= map.get(s.charAt(i));
               } else {
                   value += map.get(s.charAt(i));
               }
           }
        }

        return value;
    }
}
