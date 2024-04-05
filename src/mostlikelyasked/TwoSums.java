package mostlikelyasked;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSums {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = IntStream.rangeClosed(0, nums.length)
                .boxed()
                .collect(
                        Collectors.toMap(
                                i -> i,
                                i -> nums[i]
                        )
                );

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }

        return new int[0];
    }

}
