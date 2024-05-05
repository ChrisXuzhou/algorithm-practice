package topinterview;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int ret = new FirstMissingPositive()
                .firstMissingPositive(
                        new int[]{2, 1}
                );

        System.out.println(ret);
    }

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        // mark non-positive numbers as n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        // mark present numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        // find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

}
