package NeetCode.Encode_And_Decode_Strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        System.out.println(encode(List.of("1#,23","45,6","7,8,9")));
        System.out.println(decode(encode(List.of("1#,23","45,6","7,8,9"))));

        System.out.println(encode(List.of("we","say",":","yes","!@#$%^&*()")));
        System.out.println(decode(encode(List.of("we","say",":","yes","!@#$%^&*()"))));

        System.out.println(encode(List.of("Hello", "World")));
        System.out.println(decode(encode(List.of("Hello", "World"))));

        System.out.println(encode(List.of("4|t","f%@")));
        System.out.println(decode(encode(List.of("4|t","f%@"))));

        System.out.println(encode(List.of("need","code","love","you")));
        System.out.println(decode(encode(List.of("need","code","love","you"))));
    }

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (String ele : strs) {
            sb.append("#");
            for (int i = 0; i < ele.length(); i++) {
                int asciiValue = ele.charAt(i);
                sb.append("*");
                sb.append(asciiValue);
                sb.append("*");
            }
            sb.append("#");
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        if (str.isEmpty()) return new ArrayList<>();

        List<String> wordList = getStrings(str);

        List<String> returnList = new ArrayList<>();
        for (String encodedWord : wordList) {
            StringBuilder characterValue = new StringBuilder();
            StringBuilder decodedWord = new StringBuilder();
            int starCounter = 2;
            for (Character ele : encodedWord.toCharArray()) {
                if (ele == '*') {
                    starCounter--;
                }

                if (starCounter != 0 && ele != '*') {
                    characterValue.append(ele);
                }

                if (starCounter == 0) {
                    int value = Integer.parseInt(characterValue.toString());
                    char letter = (char) value;
                    decodedWord.append(letter);
                    characterValue = new StringBuilder();
                    starCounter = 2;
                }
            }

            returnList.add(decodedWord.toString());
        }

        return returnList;
    }

    private static List<String> getStrings(String str) {
        List<String> wordList = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        int poundCounter = 2;
        for (Character ele : str.toCharArray()) {
            if (ele == '#') {
                poundCounter--;
            }

            if (poundCounter != 0 && ele != '#') {
                word.append(ele);
            }

            if (poundCounter == 0) {
                wordList.add(word.toString());
                word = new StringBuilder();
                poundCounter = 2;
            }
        }
        return wordList;
    }
}
