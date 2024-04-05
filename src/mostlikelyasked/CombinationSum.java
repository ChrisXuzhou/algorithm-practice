package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, new ArrayList<>(), candidates, target, 0);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tempList,
                           int[] candidates, int target, int start) {

        if (target < 0) {
            return;
        }
        if (target == 0) {
            ret.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(ret, tempList, candidates, target - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
