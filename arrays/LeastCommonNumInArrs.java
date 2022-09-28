package arrays;

public class LeastCommonNumInArrs {
    static int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                return arr1[i];
            } else {
                if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k])
                    i++;
                else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k])
                    j++;
                else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j])
                    k++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findLeastCommonNumber(new int[] { 1, 5, 6, 7, 17, 20 }, new int[] { 3, 4, 7, 9, 12, 16, 50 },
                new int[] { 5, 6, 7, 10, 16, 25 }));
    }
}
