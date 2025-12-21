package LeetCode.Zigzag_Conversion;

public class ZigzagConversion {
    public static void main(String[] args) {
//        System.out.println("B => " + convert("B", 2));
//        System.out.println("AB => " + convert("AB", 1));
//        System.out.println("A => " + convert("A", 1));
//        System.out.println("ABCD => " + convert("ABCD", 2));
        System.out.println("PAYPALISHIRING => " + convert("PAYPALISHIRING", 3));
//        System.out.println("PAYPALISHIRING => " + convert("PAYPALISHIRING", 4));
//        System.out.println("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers. => " + convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 2));
    }

    public static String convert(String sentence, int numRows) {
        StringBuilder result = new StringBuilder();
        char[][] letterGrid = new char[numRows][sentence.length()];
        int currentRow = 0;
        int currentCol = 0;
        int direction = 1;
        boolean reverseFlag = false;

        if (numRows == 1 || numRows >= sentence.length()) {
            return sentence;
        }

        for (int i = 0; i < sentence.length(); i++) {
            letterGrid[currentRow][currentCol] = sentence.charAt(i);
            if (currentRow == 0) {
                direction = 1;
                reverseFlag = false;
            }

            if (currentRow == numRows - 1) {
                direction = -1;
                reverseFlag = true;
            }

            currentRow += direction;

            if (reverseFlag) {
                currentCol += 1;
            }
        }

        for (char[] array : letterGrid) {
            for(char c : array) {
                if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isWhitespace(c) || "!?,.;:'\"-()".indexOf(c) >= 0) { result.append(c); }
            }
        }

        return result.toString();
    }
}
