package arrays;

class MaxInBitonicArray {

  public static int findMax(int[] arr) {
    int low = 0, high = arr.length - 1;

    while (low < high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] > arr[mid + 1])
        high = mid;
      else
        low = mid + 1;
    }
    return arr[low];
  }

  public static void main(String[] args) {
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
  }
}