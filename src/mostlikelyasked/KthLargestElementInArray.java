package mostlikelyasked;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int num: nums) {
            queue.add(num);
            if (queue.size() > k) {
                // pop out the top element which is the smallest number.
                queue.poll();
            }
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

}
