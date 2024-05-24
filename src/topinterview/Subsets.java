package topinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        track(results, new HashSet<>(), nums, 0);
        return results;
    }

    private void track(List<List<Integer>> results,
                       Set<Integer> current, int[] nums, int i) {

        if (i == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        // 1. track down without current element.
        track(results, current, nums, i + 1);

        // 2. track down with current elements
        current.add(nums[i]);
        track(results, current, nums, i + 1);
        current.remove(nums[i]);
    }
}
