package LeetCode.Length_Of_Last_Word;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println("Hello World => " + lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }
}
