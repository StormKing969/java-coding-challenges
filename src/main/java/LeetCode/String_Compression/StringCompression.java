package LeetCode.String_Compression;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        char[] list = new char[]{'a','a','b','b','c','c','c'};
        System.out.println("6, ['a','2','b','2','c','3'] => " + compress(list));
        char[] list2 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println("4, ['a','b','1','2'] => " + compress(list2));
    }

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;

        char[] arr = chars.clone();
        int counter = 1;
        int currentIndex = 0;
        char currentChar = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (currentChar == arr[i]) {
                counter++;
            } else {
                chars[currentIndex] = currentChar;
                currentIndex++;
                if (counter > 1) {
                    if (counter < 10) {
                        chars[currentIndex] = (char) ('0' + counter);
                        currentIndex++;
                    } else {
                        char[] counterValue = String.valueOf(counter).toCharArray();
                        for (char ch : counterValue) {
                            chars[currentIndex] = ch;
                            currentIndex++;
                        }
                    }
                }

                currentChar = arr[i];
                counter = 1;
            }
        }

        chars[currentIndex] = currentChar;
        if (counter > 1) {
            if (counter < 10) {
                currentIndex++;
                chars[currentIndex] = (char) ('0' + counter);
            } else {
                char[] counterValue = String.valueOf(counter).toCharArray();
                for (char ch : counterValue) {
                    currentIndex++;
                    chars[currentIndex] = ch;
                }
            }
        }

        chars = Arrays.copyOf(chars, currentIndex + 1);
        return chars.length;
    }
}
