package topinterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TwoSum {

    public static void main(String[] args) {
        int[] ret = new TwoSum()
                .twoSum(new int[]{3, 3}, 6);

        System.out.println(Arrays.toString(ret));
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                return new int[]{map.get(target - num), i};
            }
            map.put(num, i);
        }

        throw new NoSuchElementException();
    }
}
