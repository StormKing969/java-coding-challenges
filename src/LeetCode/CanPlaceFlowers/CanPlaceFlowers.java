package LeetCode.CanPlaceFlowers;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] list1 = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(list1, 1));

        int[] list2 = {1,0,0,0,1};
        System.out.println(canPlaceFlowers(list2, 2));

        int[] list3 = {1,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(list3, 2));

        int[] list4 = {0,0,1,0,0};
        System.out.println(canPlaceFlowers(list4, 1));

        int[] list5 = {0,0,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(list5, 0));

        int[] list6 = {0};
        System.out.println(canPlaceFlowers(list6, 0));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) return false;

        if (flowerbed.length == 1) {
            if (n > 0) {
                return flowerbed[0] == 0;
            } else {
                return true;
            }
        }

        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        if (n <= 0) return true;

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (n <= 0) return true;

            if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }

        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            n--;
        }

        return n == 0;
    }
}
