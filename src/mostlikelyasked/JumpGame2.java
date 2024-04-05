package mostlikelyasked;

public class JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;
        int jumpEnd = 0;
        int farthest = 0;
        int jumps = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (jumpEnd == i) {
                jumpEnd = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}

/*









public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (currentJumpEnd == i) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }

        return jumps;
    }

 */
