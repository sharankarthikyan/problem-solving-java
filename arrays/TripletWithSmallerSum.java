package arrays;

import java.util.*;

class TripletWithSmallerSum {

    public static int searchTriplets(int[] arr, int targetSum) {
        if (arr == null || arr.length < 3)
            throw new IllegalArgumentException();

        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int l = i + 1, r = arr.length - 1;
            while (l < r) {
                int currentSum = arr[i] + arr[l] + arr[r];
                if (currentSum < targetSum) {
                    count += r - l;
                }

                if (currentSum < targetSum) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }
}