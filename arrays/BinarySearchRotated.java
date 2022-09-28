package arrays;

public class BinarySearchRotated {
    public static int bsr(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        if (start > end)
            return -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[start] <= arr[mid]) {
                if (arr[start] <= target && target < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(bsr(new int[] { 6, 7, 1, 2, 3, 4, 5 }, 7));
    }
}
