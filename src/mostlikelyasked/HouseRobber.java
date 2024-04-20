package mostlikelyasked;

public class HouseRobber {

    public static void main(String[] args) {
        int ret =
                new HouseRobber()
                        .rob(new int[]{1, 2, 3, 1});

        System.out.println(ret);
    }

    public int rob(int[] nums) {

        // dp problem
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }

        return dp[nums.length];
    }

}
