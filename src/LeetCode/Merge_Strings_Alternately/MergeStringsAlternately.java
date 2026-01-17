package LeetCode.Merge_Strings_Alternately;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
        System.out.println(mergeAlternately("ab", "pqrs"));
        System.out.println(mergeAlternately("abcd", "pq"));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        if (word1.isEmpty()) {
            return word2;
        }

        if (word2.isEmpty()) {
            return word1;
        }

        int counter1 = 0, counter2 = 0;
        for(int i = 0; i < word1.length() + word2.length(); i++){
            if (i % 2 == 0) {
                if (counter1 < word1.length()) {
                    sb.append(word1.charAt(counter1));
                    counter1++;
                } else {
                    sb.append(word2.substring(counter2));
                    break;
                }
            }

            if (i % 2 == 0) {
                if (counter2 < word2.length()) {
                    sb.append(word2.charAt(counter2));
                    counter2++;
                } else  {
                    sb.append(word1.substring(counter1));
                    break;
                }
            }
        }

        return sb.toString();
    }
}
