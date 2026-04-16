package LeetCode.Greatest_Common_Divisor_Of_Strings;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
        System.out.println(gcdOfStrings("AAAAAB", "AAA"));
        System.out.println("TAUXX => " + gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        if (!str2.isEmpty()){
            sb.append(str2);
        }

        if (!(str2 + str1).contentEquals(sb)) {
            return "";
        }

        int str1Length = str1.length();
        int str2Length = str2.length();
        while (str2Length != 0) {
            int temp = str1Length % str2Length;
            str1Length = str2Length;
            str2Length = temp;
        }

        return sb.substring(0, str1Length);
    }
}
