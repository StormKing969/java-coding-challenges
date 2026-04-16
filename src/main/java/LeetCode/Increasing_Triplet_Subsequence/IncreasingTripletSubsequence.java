package LeetCode.Increasing_Triplet_Subsequence;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}));
        System.out.println(increasingTriplet(new int[]{1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,-1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0}));
    }

    public static boolean increasingTriplet(int[] numbers) {
        if (numbers == null || numbers.length == 0) return false;

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            if (list.isEmpty()) {
                list.add(number);
            } else {
                if (list.getFirst() >= number) {
                    list.set(0, number);
                } else {
                    if (list.size() != 2) {
                        list.add(number);
                    } else {
                        if (list.get(1) >= number) {
                            list.set(1, number);
                        } else {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
}
