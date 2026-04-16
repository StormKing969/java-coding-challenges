package LeetCode.Sqrt;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println("2 => " + mySqrt(4));
        System.out.println("2 => " + mySqrt(8));
    }

    public static int mySqrt(int x) {
        return (int) Math.floor(Math.sqrt(x));
    }
}
