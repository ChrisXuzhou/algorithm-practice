package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ret = new Permutations()
                .permute(nums);

        System.out.println(ret.size());
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        int n = nums.length;
        if (n < 1) {
            return results;
        }

        boolean[] marks = new boolean[nums.length];
        permute(results, new ArrayList<>(), nums, marks, n - 1);
        return results;
    }

    private void permute(List<List<Integer>> results, List<Integer> temp,
                         int[] nums, boolean[] marks, int cnt) {
        if (cnt < 0) {
            results.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < marks.length; i++) {
            boolean mark = marks[i];
            if (!mark) {
                temp.add(nums[i]);
                marks[i] = true;

                permute(results, temp, nums, marks, cnt - 1);

                marks[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }


}
