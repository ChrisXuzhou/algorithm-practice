package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sum2Count = new HashMap<>();
        sum2Count.put(0, 1);

        for (int num: nums) {
            sum += num;
            if (sum2Count.containsKey(sum - k)) {
                count += sum2Count.get(sum - k);
            }
            sum2Count.put(sum, sum2Count.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

}
