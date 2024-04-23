package mostlikelyasked;

import java.util.Arrays;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                break;
            }
        }
        return nums[i];
    }

}
