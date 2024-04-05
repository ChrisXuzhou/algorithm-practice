package mostlikelyasked;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 1};
        System.out.println(
                new SearchRotatedSortedArray()
                        .search(nums, 1)
        );
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int l, int r) {
        if (l > r) return -1;

        int mid = (l + r) / 2;
        if (target == nums[mid]) return mid;

        if (nums[l] <= nums[mid]) {
            // pivot is on the right.
            if (target >= nums[l] && target < nums[mid]) {
                return search(nums, target, l, mid - 1);
            }
            return search(nums, target, mid + 1, r);
        } else {
            // pivot is on the left.
            if (target > nums[mid] && target <= nums[r]) {
                return search(nums, target, mid + 1, r);
            }
            return search(nums, target, l, mid - 1);
        }
    }

}
