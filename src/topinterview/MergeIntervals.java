package topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {

            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                // not overlapped
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] =
                        Math.max(interval[1], merged.get(merged.size() - 1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
