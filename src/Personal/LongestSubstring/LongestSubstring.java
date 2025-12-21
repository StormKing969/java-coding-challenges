package Personal.LongestSubstring;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstring {
    public static void main(String[] args) {
        // Example input string
        String[] stringList = {" ", "dvdf", "c", "", "ca", "cwafdwgrtytefafwfapoutcbjk", "abcabcbb"};

        for(String s : stringList) {
            int length = lengthOfLongestSubstring(s);
            System.out.println("Input String: " + s + " Output: " + length);
            int highestCount = getHighestCount(s);
            System.out.println("Input String: " + s + " Highest Count: " + highestCount);
            System.out.println("===========");
        }

    }

    /**
     * Returns the length of the longest substring without repeating characters.
     * Uses a sliding window approach with an array to track the last seen index of each character.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    public static int lengthOfLongestSubstring(String s) {
        int wordLength = s.length(); // Length of the input string
        int result = 0; // Stores the maximum length found
        int[] index = new int[128]; // Array to store the last seen position of each ASCII character

        // Sliding window: 'i' is the start, 'j' is the end of the current window
        for (int j = 0, i = 0; j < wordLength; j++) {
            // Update the start of the window to the next position after the last occurrence of s.charAt(j)
            i = Math.max(index[s.charAt(j)], i);

            // Update the result if the current window is larger
            result = Math.max(result, j - i + 1);

            // Store the index of the next character (j + 1) for s.charAt(j)
            index[s.charAt(j)] = j + 1;
        }
        return result;
    }

    public static int getHighestCount(String input) {
        int highestCount = 0;
        List<Character> temp = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            return 0;
        }

        for(int i = 0; i < input.length(); i++) {
            if (!temp.contains(input.charAt(i))) {
                temp.add(input.charAt(i));
                if (temp.size() > highestCount) {
                    highestCount = temp.size();
                }
            } else {
                while (temp.contains(input.charAt(i))) {
                    temp.removeFirst();
                }
                temp.add(input.charAt(i));
            }

        }

        return highestCount;
    }
}
