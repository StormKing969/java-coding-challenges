package LeetCode.Search_Insert_Position;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] numbers = {1,3,5,6};
        System.out.println("2 => " + searchInsert(numbers, 5));

        int[] numbers2 = {1,3,5,6};
        System.out.println("4 => " + searchInsert(numbers2, 7));

        int[] numbers3 = {1,3};
        System.out.println("1 => " + searchInsert(numbers3, 3));
    }

    public static int searchInsert(int[] numbers, int target) {
        int answer = 0;
        if (target < numbers[0]) {
            return answer;
        }

        if (target > numbers[numbers.length - 1]) {
            return numbers.length;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < target && numbers[i + 1] <  target) {
                continue;
            }

            if (numbers[i] < target && numbers[i + 1] > target) {
                answer = i + 1;
            }

            if (numbers[i] == target) {
                answer = i;
            }

            if (numbers[i + 1] == target) {
                answer = i + 1;
            }
        }

        return answer;
    }
}
