package LeetCode.Find_The_Difference_Of_Two_Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] list1 = {1,2,3,3};
        int[] list2 = {1,1,2,2};
        System.out.println(findDifference(list1, list2));

        int[] list3 = {-80,-15,-81,-28,-61,63,14,-45,-35,-10};
        int[] list4 = {-1,-40,-44,41,10,-43,69,10,2};
        System.out.println(findDifference(list3, list4));

        int[] list5 = {1,2,3};
        int[] list6 = {2,4,6};
        System.out.println(findDifference(list5, list6));
    }

    public static List<List<Integer>> findDifference(int[] number1, int[] number2) {
        Map<Integer, String> map1 = new HashMap<>();
        for (int element : number1) {
            map1.put(element, "List1");
        }

        for (int element : number2) {
            if (map1.containsKey(element)) {
                if (map1.get(element).equals("List1")) {
                    map1.put(element, "List1&List2");
                }
            } else {
                map1.put(element, "List2");
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            if (entry.getValue().equals("List1")) {
                list1.add(entry.getKey());
            }

            if (entry.getValue().equals("List2")) {
                list2.add(entry.getKey());
            }
        }

        return List.of(list1, list2);
    }
}
