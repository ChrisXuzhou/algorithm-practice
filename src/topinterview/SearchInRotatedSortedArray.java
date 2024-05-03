package topinterview;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int ret = new SearchInRotatedSortedArray()
                .search(
                        new int[]{4, 5, 6, 7, 0, 1, 2},
                        0
                );

        System.out.println(ret);
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int start, int end) {

        if (start > end) return -1;
        int mid = start + (end - start) / 2;

        if (nums[mid] == target) return mid;

        if (target < nums[mid]) {

            // left side consideration:
            if (nums[start] < nums[mid] && nums[start] <= target) {
                return search(nums, target, start, mid - 1);
            } else if (nums[start] > nums[mid]) {
                return search(nums, target, start, mid - 1);
            } else {
                // right side
                return search(nums, target, mid + 1, end);
            }
        } else {
            // target > nums[mid]

            // right side
            if (nums[mid] < nums[end] && target <= nums[end]) {
                return search(nums, target, mid + 1, end);
            } else if (nums[mid] > nums[end]) {
                return search(nums, target, mid + 1, end);
            } else {
                // left side
                return search(nums, target, start, mid - 1);
            }
        }
    }

}
