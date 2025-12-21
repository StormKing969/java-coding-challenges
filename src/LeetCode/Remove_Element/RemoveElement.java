package LeetCode.Remove_Element;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr1 = {3,2,2,3};
        System.out.println("2, [2,2,_,_] => " + removeElement(arr1, 3));
    }

    public static int removeElement(int[] numbers, int val) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int indexCounter = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != val) {
                numbers[indexCounter] = numbers[i];
                indexCounter++;
            }
        }

        return indexCounter;
    }
}
