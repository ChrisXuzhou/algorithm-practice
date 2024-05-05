package topinterview;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, results, curr, used);

        return results;
    }

    private void backtrack(int[] nums,
                           List<List<Integer>> results,
                           List<Integer> curr,
                           boolean[] used
                           ) {

        if (curr.size() == nums.length) {
            results.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {

                used[i] = true;
                curr.add(nums[i]);
                backtrack(nums, results, curr, used);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }

}
