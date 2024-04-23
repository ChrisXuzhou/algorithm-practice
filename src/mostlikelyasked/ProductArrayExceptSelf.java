package mostlikelyasked;

public class ProductArrayExceptSelf {

        public int[] productExceptSelf(int[] nums) {

            if (nums == null || nums.length == 0 || nums.length == 1) return nums;

            int n = nums.length;

            int[] leftProducts = new int[n];
            int[] rightProducts = new int[n];

            leftProducts[0] = 1;
            rightProducts[n - 1] = 1;

            for (int i = 1; i < n; i++) {
                leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
            }
            for (int j = n - 2; j >= 0; j--) {
                rightProducts[j] = rightProducts[j + 1] * nums[j + 1];
            }

            int[] answer = new int[n];
            for (int i = 0; i < n; i++) {
                answer[i] = leftProducts[i] * rightProducts[i];
            }

            return answer;
        }
}
