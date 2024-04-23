package mostlikelyasked;

import java.util.Arrays;

public class LongestIncreasingSubsequence2 {

    public static void main(String[] args) {
        new LongestIncreasingSubsequence2()
                .lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6});
    }

    public int lengthOfLIS(int[] nums) {

        int max = 0;
        int[] records = new int[nums.length];
        Arrays.fill(records, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    records[i] = Math.max(records[i], records[j] + 1);
                    max = Math.max(max, records[i]);
                }
            }
        }

        return max;
    }
}
