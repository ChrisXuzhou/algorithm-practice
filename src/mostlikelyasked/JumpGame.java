package mostlikelyasked;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(
                new JumpGame()
                        .canJump(nums)
        );
    }

    public boolean canJump(int[] nums) {
        int farthest = 0;
        int n = nums.length;
        int i = 0;

        while (i < n) {
            farthest = Math.max(nums[i] + i, farthest);

            if (farthest >= n - 1) {
                break;
            } else if (i < farthest) {
                i++;
            } else {
                break;
            }
        }
        return farthest >= n - 1;
    }

}
