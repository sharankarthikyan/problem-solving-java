package arrays;

import java.util.*;

class Interval3 {
    int start;
    int end;

    public Interval3(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval3[] intervals) {
        // sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // find any overlapping appointment
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                // please note the comparison above, it is "<" and not "<="
                // while merging we needed "<=" comparison, as we will be merging the two
                // intervals having condition "intervals[i].start == intervals[i - 1].end" but
                // such intervals don't represent conflicting appointments as one starts right
                // after the other
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Interval3[] intervals = { new Interval3(1, 4), new Interval3(2, 5), new Interval3(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval3[] intervals1 = { new Interval3(6, 7), new Interval3(2, 4), new Interval3(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval3[] intervals2 = { new Interval3(4, 5), new Interval3(2, 3), new Interval3(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
