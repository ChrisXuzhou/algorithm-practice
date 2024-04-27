package mostlikelyasked;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> highHalf;
    private PriorityQueue<Integer> lowHalf;

    public MedianFinder() {
        highHalf = new PriorityQueue<>(Collections.reverseOrder());
        lowHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        highHalf.offer(num);
        lowHalf.offer(highHalf.poll());

        if (highHalf.size() < lowHalf.size()) {
            highHalf.offer(lowHalf.poll());
        }
    }

    public double findMedian() {
        if (highHalf.size() == lowHalf.size()) {
            return (highHalf.peek() + lowHalf.peek()) / 2.0;
        } else {
            return highHalf.peek();
        }
    }
}
