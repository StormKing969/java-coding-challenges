package Question06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q6_Attempt_1 {
    public static String isPalindrome(String word) {
        int wordSize = word.length();
        int firstIndex = 0;
        int lastIndex = wordSize - 1;
        char[] wordToCheck = word.toCharArray();
        boolean isTrue = false;

        while (firstIndex < wordSize / 2 && lastIndex > wordSize / 2) {
            if (wordToCheck[firstIndex] != wordToCheck[lastIndex]) {
                isTrue = false;
                break;
            }

            firstIndex++;
            lastIndex--;
            isTrue = true;
        }

        if (isTrue) {
            return Arrays.toString(wordToCheck);
        } else {
            return null;
        }

    }

    public static List<String> allPalindromes(String word) {
        List<String> result = new ArrayList<>();
        int wordSize = word.length();
        int counter = 0;

        while (counter < (wordSize - 1) / 2) {
            String checkWord = word.substring(counter, wordSize - counter);
            String testOutput = isPalindrome(checkWord);

            if (testOutput != null) {
                result.add(testOutput);
            }

            counter++;
        }

        return result;
    }
}
