package Personal.Sorting;

import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        String[] items = userInput();
        System.out.println("Unsorted list: " + String.join(", ", items));
        bubbleSort(items);
        System.out.println("Sorted list using Bubble Sort: " + String.join(", ", items));

        // For comparison, also perform Quick Sort
        items = userInput(); // Re-input to sort the same unsorted list
        System.out.println("Unsorted list: " + String.join(", ", items));
        quickSort(items, 0, items.length - 1);
        System.out.println("Sorted list using Quick Sort: " + String.join(", ", items));
    }

    public static String[] userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the list you want to sort: ");
        String input = scanner.nextLine();
        scanner.close();
        return input.split(",\\s*");
    }

    private static void bubbleSort(String[] items) {
        boolean needSorting = true;

        while (needSorting) {
            needSorting = false;

            for (int i = 0; i < items.length; i++) {
                String temp;
                if (((i + 1) != items.length) && (Integer.parseInt(items[i]) > Integer.parseInt(items[i + 1]))) {
                    temp = items[i];
                    items[i] = items[i + 1];
                    items[i + 1] = temp;
                    needSorting = true;
                }
            }
        }
    }

    private static void quickSort(String[] items, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(items, low, high);
            quickSort(items, low, pivotIndex - 1);
            quickSort(items, pivotIndex + 1, high);
        }
    }

    private static int partition(String[] items, int low, int high) {
        String pivot = items[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (Integer.parseInt(items[j]) <= Integer.parseInt(pivot)) {
                i++;
                String temp = items[i];
                items[i] = items[j];
                items[j] = temp;
            }
        }

        String temp = items[i + 1];
        items[i + 1] = items[high];
        items[high] = temp;

        return i + 1;
    }
}
