package arrays;

class BuildArray {
    public static int[] buildArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + (n * (nums[nums[i]] % n));
        }

        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }
        return nums;
    }

    public static void main(String[] args) {
        buildArray(new int[] { 5, 0, 1, 2, 3, 4 });
    }
}