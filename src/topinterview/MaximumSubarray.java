package topinterview;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currMax = Math.max(num, currMax + num);
            max = Math.max(max, currMax);
        }

        return max;
    }

}
