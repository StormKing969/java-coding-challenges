package LeetCode.Kids_With_The_Greatest_Number_Of_Candies;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] list1 = {2,3,5,1,3};
        System.out.println(kidsWithCandies(list1, 3));
        System.out.println(kidsWithCandiesV2(list1, 3));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            for (int j = 0; j < candies.length; j++) {
                if (i == j) {
                    continue;
                }

                if (candies[i] + extraCandies < candies[j]) {
                    res.add(false);
                    break;
                }
            }

            if (res.size() != i + 1) {
                res.add(true);
            }
        }

        return res;
    }

    public static List<Boolean> kidsWithCandiesV2(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int maxValue = 0;
        for (int i : candies) {
            if (i > maxValue) {
                maxValue = i;
            }
        }

        for (int ele : candies) {
            if (ele + extraCandies >= maxValue) {
                res.add(true);
            } else {
                res.add(false);
            }
        }

        return res;
    }
}
