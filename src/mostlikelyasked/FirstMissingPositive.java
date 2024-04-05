package mostlikelyasked;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(
                new FirstMissingPositive()
                        .firstMissingPositive(nums)
        );
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1) return 1;

        int n = nums.length;
        int i = 0;
        while (i < n) {
            // the slot of idx i - 1 has the value of i.
            if (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }

        }

        i = 0;
        while (i < n) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
            i++;
        }

        return i + 1;
    }
}




/*
















        if (nums == null || nums.length < 1) {
            return 0;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // put nums[i] into the position of idx being nums[i] - 1
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
 */