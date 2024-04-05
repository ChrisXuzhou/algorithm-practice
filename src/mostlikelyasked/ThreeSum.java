package mostlikelyasked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // remove duplication, using the left one
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // nums[i] is the first number.
            int left = i + 1;
            int right = n - 1;
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // find the answer
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // find next
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                    
                } else if (sum < 0) {
                    // the smaller number should be bigger
                    left++;
                } else {
                    // sum > 0: the bigger number should be smaller
                    right--;
                }


            }

        }


        return ret;
    }

}

/*











        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        // pivot the first one, then find the other two left numbers
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // remove the duplications
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    // sum <0
                    left++;
                }
            }
        }
        return ret;
 */
