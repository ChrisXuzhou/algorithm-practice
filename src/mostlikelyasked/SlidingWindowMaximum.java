package mostlikelyasked;

import java.util.*;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < k) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // record the indexes in the window

        for (int i = 0; i < n; i++) {

            // from i - k + 1 to i is the window (i is included)
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

}
