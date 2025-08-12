package Question02;

public class Q2_Attempt_2 {
    public static String clearDigitsV2(String word) {

        // Convert the input string to a character array for in-place modifications
        char[] arr = word.toCharArray();
        int idx = 0; // Index to track the position of non-digit characters

        // Iterate over each character in the input string
        for(char ch : word.toCharArray()){
            if(Character.isDigit(ch)){
                // If the character is a digit, remove the last non-digit character (if any)
                if(idx > 0)
                    idx--;
            } else {
                // If the character is not a digit, store it at the current index and move forward
                arr[idx++] = ch;
            }
        }

        // Construct and return the final string containing only non-digit characters
        return new String(arr, 0, idx);
    }
}
