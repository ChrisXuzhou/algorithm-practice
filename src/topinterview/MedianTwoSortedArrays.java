package topinterview;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = m;
        int half = (m + n + 1) / 2;

        while (left <= right) {

            int i = (left + right) / 2;
            int j = half - i;

            if (i < m && nums2[j - 1] > nums1[i]) {
                // i is too small.
                left++;
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                // i is too big.
                right--;
            } else {
                // i is in the perfect position
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }

        // from the num2's view, the range of the median is between
        // m + n + 1 /2 - i to

        return 0.0;
    }
}
