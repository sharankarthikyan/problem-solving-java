package arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;
        if (arr[mid] == target)
            return mid;
        else if (arr[mid] >= target)
            return binarySearch(arr, low, mid - 1, target);
        else
            return binarySearch(arr, mid + 1, high, target);

    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40, 50 };
        System.out.println(binarySearch(arr, 0, arr.length, 2));
    }
}
