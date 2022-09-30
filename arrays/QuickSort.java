package arrays;

import java.util.*;

public class QuickSort {

    public static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int mid = low + (high - low) / 2;

        // taking middle element as a pivot value. we can take any index element as
        // pivot.
        int pivotValue = arr[mid];

        while (i < j) {

            while (i <= high && arr[i] <= pivotValue)
                i++;

            while (arr[j] > pivotValue)
                j--;

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[mid] = arr[j];
        arr[j] = pivotValue;

        return j;
    }

    public static void quickSortRec(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortRec(arr, low, pivotIndex - 1);
            quickSortRec(arr, pivotIndex + 1, high);
        }
    }

    public static void quickSort(int[] arr) {
        quickSortRec(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[][] numsList = { { 55, 23, 26, 2, 18, 78, 23, 8, 2, 3 }, { 1 }, { 9, 8, 7, 2, 3, 1 },
                { 10, 20, 30, -1, -2 } };

        for (int i = 0; i < numsList.length; i++) {
            System.out.println((i + 1) + ". Before Sorting");
            System.out.println("   " + Arrays.toString(numsList[i]));

            quickSort(numsList[i]);

            System.out.println("   After Sorting");
            System.out.println("   " + Arrays.toString(numsList[i]));
            System.out.println(
                    "-----------------------------------------------------------------------------------------------------\n");
        }

    }
}
