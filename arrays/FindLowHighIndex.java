package arrays;

// Importing required functions
import java.util.*;

class FindLowHighIndex {
    // Finding the low index of the target element
    static int findLowIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int midElem = nums[mid];

            // Target value is less than the middle value
            if (midElem < target) {
                low = mid + 1;
            }

            // Target value is greater than or equal to the middle value
            else {
                high = mid - 1;
            }
        }

        if (low < nums.length && nums[low] == target) {
            return low;
        }

        return -1;
    }

    // Finding the high index of the target element
    static int findHighIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;
            int midElem = nums[mid];

            // Target value is less than or equal to the middle value
            if (midElem <= target) {
                low = mid + 1;
            }

            // Target value is greater than the middle value
            else {
                high = mid - 1;
            }

            // Updating the mid value
        }

        if (high == -1) {
            return high;
        }

        if (high < nums.length && nums[high] == target) {
            return high;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6 };
        System.out.println("Original List: " + Arrays.toString(nums) + "\n");

        int target = 5;
        int low = findLowIndex(nums, target);
        int high = findHighIndex(nums, target);
        System.out.println("Low Index of " + target + ": " + low);
        System.out.println("High Index of " + target + ": " + high);

        System.out.println();

        target = -2;
        low = findLowIndex(nums, target);
        high = findHighIndex(nums, target);
        System.out.println("Low Index of " + target + ": " + low);
        System.out.println("High Index of " + target + ": " + high);
    }
}
