package topinterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        List<List<Integer>> ret =
                new ThreeSum()
                        .threeSum(new int[] {-1,0,1,2,-1,-4});

        System.out.println(ret);

    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 2) return ret;

        // sort nums
        Arrays.sort(nums);

        // i, j, k to represent the 3 numbers
        for (int i = 0; i < nums.length - 2; i++) {

            // remove i's redundancy
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ret.add(new ArrayList<>(Arrays.asList(
                            nums[i], nums[j], nums[k]
                    )));
                    j++;
                } else if (sum > 0) {
                    // means that the biggest number k is too big
                    // move k left wards
                    k--;
                    while (i < k && nums[k] == nums[k + 1]) {
                        k -= 1;
                    }
                } else {
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }

        return ret;
    }

}
