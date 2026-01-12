package LeetCode.Find_The_Index_Of_The_First_Occurrence_In_A_String;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println("0 => " + strStr("sadbutsad", "sad"));
        System.out.println("-1 => " + strStr("leetcode", "leeto"));
        System.out.println("4 => " + strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j <= haystack.length(); i++, j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }

        return -1;
    }
}