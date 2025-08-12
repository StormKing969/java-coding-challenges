package Question02;

import java.util.ArrayList;

public class Q2_Attempt_1 {
    public static String clearDigitsV1(String word) {
        ArrayList<Integer> indexToRemove = new ArrayList<>();

        int removedChar = 0;
        if (!word.isEmpty()) {
            // Check for the first digits and mark its index
            for (int i = 0; i < word.length(); i++) {
                char checkIfDigit = word.charAt(i);
                if (Character.isDigit(checkIfDigit)) {
                    indexToRemove.add(i);
                    removedChar++;

                    // Make sure that we won't go out of bound
                    if (i - 1 != 0) {
                        // Check for the first non-digits on the left and mark its index
                        for (int j = i - 1; j > 0; j--) {
                            // Ignore those that are marked to be already removed
                            if (!indexToRemove.contains(j)) {
                                char checkIfLetter = word.charAt(j);
                                if (!Character.isDigit(checkIfLetter)) {
                                    indexToRemove.add(j);
                                    removedChar--;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        // Sort the list
        indexToRemove.sort(null);

        // Loop through the indexes in reverse order to remove the characters
        for (int i = indexToRemove.size() - 1; i >= 0; i--) {
            int index = indexToRemove.get(i);
            word = word.substring(0, index) + word.substring(index + 1);
        }

        if (!word.isEmpty() && removedChar != 0) {
            if (removedChar < word.length()) {
                word = word.substring(removedChar);
            } else {
                word = "";
            }
        }

        return word;
    }
}
