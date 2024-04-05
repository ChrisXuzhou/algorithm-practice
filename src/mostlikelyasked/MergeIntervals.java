package mostlikelyasked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ret = new MergeIntervals()
                .merge(intervals);

        System.out.println(ret.length);
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));

        List<int[]> newIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newIntervals.isEmpty()) {
                newIntervals.add(interval);
            } else {
                int[] _interval = newIntervals.getLast();
                if (interval[0] <= _interval[1]) {
                    _interval[1] = Math.max(_interval[1], interval[1]);
                } else  {
                    newIntervals.add(interval);
                }
            }
        }

        int[][] arrays = new int[newIntervals.size()][];
        for (int i = 0; i < newIntervals.size(); i++) {
            arrays[i] = newIntervals.get(i);
        }

        return arrays;
    }

}
