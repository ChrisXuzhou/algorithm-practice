package mostlikelyasked;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        final PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));

        for (ListNode list: lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (!queue.isEmpty()) {
            ListNode curr = queue.poll();
            prev.next = curr;
            prev = curr;

            if (curr.next != null) {
                queue.offer(curr.next);
            }
        }

        return dummy.next;
    }

}
