package mostlikelyasked;

public class MaximumProductSubArray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int resultProduct = nums[0];
        int minProduct = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxProduct = Math.max(nums[i], Math.max(minProduct * nums[i], maxProduct * nums[1]));
            minProduct = Math.min(nums[i], Math.min(minProduct * nums[i], maxProduct * nums[1]));

            resultProduct = Math.max(resultProduct, maxProduct);
        }

        return resultProduct;
    }

    public int maxProduct2(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            int tempMin = Math.min(nums[i], Math.min(maxProduct * nums[i], minProduct * nums[i]));

            maxProduct = tempMax;
            minProduct = tempMin;

            result = Math.max(result, maxProduct);
        }

        return result;
    }

}
