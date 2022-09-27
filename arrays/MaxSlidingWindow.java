package arrays;

import java.util.ArrayDeque;

public class MaxSlidingWindow {
    public static ArrayDeque<Integer> findMaxSlidingWindow(int arr[], int windowSize) {
        if (arr.length > 0) {
            // If window_size is greater than the array size,
            // set the window_size to nums.size()

            ArrayDeque<Integer> result = new ArrayDeque<>();
            ArrayDeque<Integer> index_list = new ArrayDeque<>();

            if (arr.length < windowSize)
                windowSize = arr.length;

            for (int i = 0; i < windowSize; i++) {

                // Removing last smallest element index
                while (!index_list.isEmpty() && arr[i] >= arr[index_list.peekLast()])
                    index_list.removeLast();

                // Adding newly picked element index
                index_list.addLast(i);
            }

            for (int i = windowSize; i < arr.length; i++) {
                result.addLast(arr[index_list.peekLast()]);

                // Removing all the elements indexes which are not in the current window
                while (!index_list.isEmpty() && index_list.peek() <= i - windowSize)
                    index_list.removeFirst();

                // Removing the smaller elements indexes which are not required
                while (!index_list.isEmpty() && arr[i] >= arr[index_list.peekLast()])
                    index_list.removeLast();

                // Adding newly picked element index
                index_list.addLast(i);
            }

            // Adding the max number of the current window in the result
            result.addLast(arr[index_list.peekLast()]);
            return result; // returning result
        } else
            return new ArrayDeque<>();
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ouput = findMaxSlidingWindow(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3);
        System.out.println(ouput);
    }
}