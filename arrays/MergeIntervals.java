package arrays;

// Importing required functions
import java.util.*;

// Creating a tuple class as java does not support returning
// multiple arguments
class Interval {
    public int first;
    public int second;

    public Interval(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

class MergeIntervals {
    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> v) {

        // If the list is empty
        if (v == null || v.size() == 0) {
            return null;
        }

        ArrayList<Interval> result = new ArrayList<Interval>();

        // Adding interval in the result list
        result.add(new Interval(v.get(0).first, v.get(0).second));

        for (int i = 1; i < v.size(); i++) {
            // Getting the recent added interval in the result list
            Interval recentAddedInterval = result.get(result.size() - 1);

            // Getting and initializing input interval
            int currStart = v.get(i).first;
            int currEnd = v.get(i).second;

            // Getting and initializing recently added interval from result list
            int prevEnd = recentAddedInterval.second;

            // Overlapping condition
            if (prevEnd >= currStart) {
                recentAddedInterval.second = Math.max(currEnd, prevEnd);
            }

            // No overlapping
            else {
                result.add(new Interval(currStart, currEnd));
            }
        }

        return result;

        // int arrListSize = v.size();

        // if (arrListSize < 2) {
        // return v;
        // }

        // int l = 0, r = 1;

        // while (r < arrListSize) {
        // Interval left = v.get(l);
        // Interval right = v.get(r);

        // if (left.second >= right.first) {
        // right.first = left.first;
        // if (right.second < left.second) {
        // right.second = left.second;
        // }
        // v.remove(l);
        // arrListSize--;
        // } else {
        // r++;
        // l++;
        // }
        // }

        // return v;
    }

    public static void main(String[] args) {
        Interval[] v1 = { new Interval(1, 5), new Interval(3, 7), new Interval(4, 6) };
        Interval[] v2 = { new Interval(1, 5), new Interval(4, 6), new Interval(6, 8), new Interval(11, 15) };
        Interval[] v3 = { new Interval(3, 7), new Interval(6, 8), new Interval(10, 12), new Interval(11, 15) };
        Interval[] v4 = { new Interval(1, 5) };
        Interval[][] vList = { v1, v2, v3, v4 };

        for (int i = 0; i < vList.length; i++) {
            ArrayList<Interval> v = new ArrayList<Interval>(Arrays.asList(vList[i]));
            System.out.print(i + 1);
            ArrayList<Interval> result = mergeIntervals(v);
            String result_str = "";
            for (int j = 0; j < result.size(); j++) {
                result_str += "[" + result.get(j).first + ", " + result.get(j).second + "] ";
            }
            System.out.println("   Merged intervals:\t" + result_str);
            System.out.println(
                    "----------------------------------------------------------------------------------------------------\n");
        }
    }
}