package LeetCode.Guess_Number_Higher_Or_Lower;

public class GuessNumberHigherOrLower {
    private static int pickedNumber;

    public GuessNumberHigherOrLower(int pickedNumber) {
        GuessNumberHigherOrLower.pickedNumber = pickedNumber;
    }

    public static void main(String[] args) {
        new GuessNumberHigherOrLower(6);
        System.out.println(guessNumber(10)); // search range 1..10
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int res = guess(mid);

            if (res == 0) return mid;       // found
            else if (res < 0) high = mid - 1; // mid is too high
            else low = mid + 1;               // mid is too low
        }

        return -1; // should never happen
    }

    public static int guessNumberV2(int n) {
        return search(1, n);
    }

    private static int search(int low, int high) {
        if (low > high) return -1; // should never happen

        int mid = low + (high - low) / 2;
        int res = guess(mid);

        if (res == 0) return mid;          // found
        else if (res < 0) return search(low, mid - 1);  // mid too high
        else return search(mid + 1, high);               // mid too low
    }


    private static int guess(int num) {
        return Integer.compare(pickedNumber, num);
    }
}
