package mostlikelyasked;

public class MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(
                new MaximumSubarray()
                        .maxSubArray(
                                new int[] {-2,1,-3,4,-1,2,1,-5,4}
                        )
        );
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i< nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }
}
