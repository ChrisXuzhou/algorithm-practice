package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequent = new HashMap<>();
        for (int num : nums) {
            frequent.put(
                    num,
                    frequent.getOrDefault(num, 0)
            );
        }

        PriorityQueue<Integer> queue =
                new PriorityQueue<>((o1, o2) -> frequent.get(o2) - frequent.get(o1));

        for (int num: frequent.keySet()) {
            queue.add(num);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] f = new int[k];
        int i = 0;
        while (i < k) {
            f[i] = queue.poll();
            i++;
        }

        return f;
    }
}
