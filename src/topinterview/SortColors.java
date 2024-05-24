package topinterview;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[] {2,0,2,1,1,0};
        new SortColors()
                .sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
