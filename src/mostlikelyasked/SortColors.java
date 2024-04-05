package mostlikelyasked;

import sortandsearch.Sort;

import java.util.HashMap;
import java.util.Map;

public class SortColors {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors()
                .sortColors(nums);

        System.out.println(nums.length);
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (mid <= right) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, mid, left);
                    left++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;

                case 2:
                    swap(nums, mid, right);
                    right--;
                    break;
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


/*










Map<Integer, Integer> colorsMap = new HashMap<>();
        for (int num : nums) {
            colorsMap.put(
                    num,
                    colorsMap.getOrDefault(num, 0) + 1
            );
        }

        int k = 0;
        for (int i = 0; i < 3; i++) {
            int cnt = colorsMap.getOrDefault(i, 0);
            for (int j = 0; j < cnt; j++) {
                nums[k] = i;
                k++;
            }
        }
 */