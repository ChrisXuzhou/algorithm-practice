package mostlikelyasked;

import java.util.ArrayList;
import java.util.Arrays;

public class FindFirstAndLastPositionElementSortedArray {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(
                Arrays.toString(
                        new FindFirstAndLastPositionElementSortedArray()
                                .searchRange(nums, 6)
                )
        );
    }

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target, 0, nums.length - 1);
        int right = searchRight(nums, target, 0, nums.length - 1);

        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            if (mid == l) {
                return l;
            } else if (nums[mid - 1] < target) {
                return mid;
            } else {
                return searchLeft(nums, target, l, mid - 1);
            }
        } else if (target < nums[mid]) {
            return searchLeft(nums, target, l, mid -1);
        } else {
            return searchLeft(nums, target, mid + 1, r);
        }
    }

    private int searchRight(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int mid = (l + r) / 2;
        if (nums[mid] == target) {
            if (mid == r) {
                return r;
            } else if (target < nums[mid + 1]) {
                return mid;
            } else {
                return searchRight(nums, target, mid + 1, r);
            }
        } else if (target < nums[mid]) {
            return searchRight(nums, target, l, mid -1);
        } else {
            return searchRight(nums, target, mid + 1, r);
        }
    }



}
