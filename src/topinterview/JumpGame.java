package topinterview;

public class JumpGame {

    public boolean canJump(int[] nums) {

        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            if (i > max) {
                break;
            }

            int step = nums[i];
            max = Math.max(step + i, max);
            if (max >= nums.length - 1) {
                return true; // If last index is reachable
            }
        }
        return false;
    }

}
