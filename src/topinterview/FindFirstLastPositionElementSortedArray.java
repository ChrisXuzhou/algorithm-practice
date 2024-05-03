package topinterview;

import java.util.Arrays;

public class FindFirstLastPositionElementSortedArray {

    public static void main(String[] args) {

        int[] range =
                new FindFirstLastPositionElementSortedArray()
                        .searchRange(
                                new int[]{5, 7, 7, 8, 8, 10}, 8
                        );

        System.out.println(Arrays.toString(range));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                firstOf(nums, target, 0, nums.length - 1),
                endOf(nums, target, 0, nums.length - 1),
        };
    }

    private int firstOf(int[] nums, int target, int start, int end) {

        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            } else {
                // not the left side
                return firstOf(nums, target, start, mid - 1);
            }
        }

        if (target < nums[mid]) {
            return firstOf(nums, target, start, mid - 1);
        } else {
            // target > nums[mid]
            return firstOf(nums, target, mid + 1, end);
        }

    }

    private int endOf(int[] nums, int target, int start, int end) {

        if (start > end) return -1;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            if( mid == nums.length - 1 ||
                    (mid + 1 < nums.length && nums[mid + 1] != target)
            ) {
                return mid;
            } else {
                return endOf(nums, target, mid + 1, end);
            }
        }

        if (target < nums[mid]) {
            return endOf(nums, target, start, mid - 1);
        } else {
            // target > nums[mid]
            return endOf(nums, target, mid + 1, end);
        }
    }


}
