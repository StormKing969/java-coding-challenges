package LeetCode.Add_Binary;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println("100 => " + addBinary("11", "1"));
        System.out.println("10101 => " + addBinary("1010", "1011"));
        System.out.println("1010 => " + addBinary("1010", ""));
        System.out.println("10 => " + addBinary("1", "1"));
        System.out.println("0 => " + addBinary("0", "0"));
    }

    public static String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        if (len1 == 0 && len2 == 0) {
            return "";
        }

        if (len1 == 0) {
            return b;
        }

        if (len2 == 0) {
            return a;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (len1 >= 0 || len2 >= 0 || carry > 0) {
            int valueA = len1 > 0 ? Character.getNumericValue(a.charAt(len1 - 1)) : 0;
            int valueB = len2 > 0 ? Character.getNumericValue(b.charAt(len2 - 1)) : 0;
            int sum = valueA + valueB + carry;
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
            len1--;
            len2--;
        }

        sb.reverse();
        if (sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
