package LeetCode.Reverse_Integer;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("123 => 321 = " + reverse(123));
        System.out.println("-123 => -321 = " + reverse(-123));
        System.out.println("120 => 21 = " + reverse(120));
        System.out.println("964632435 => 534236469 = " + reverse(964632435));
    }

    public static int reverse(int x) {
        int reverse = 0;
        boolean negative = false;
        if (x < 10 && x > -10) {
            return x;
        }

        if (x < 10) {
            negative = true;
        }

        String number = String.valueOf(Math.abs(x));
        StringBuffer sb = new StringBuffer(number).reverse();
        try {
            if (negative) {
                reverse += Integer.parseInt(sb.toString()) * -1;
            } else {
                reverse += Integer.parseInt(sb.toString());
            }
        } catch (NumberFormatException e) {
            return 0;
        }

        return reverse;
    }
}
