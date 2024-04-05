package mostlikelyasked;

import java.util.LinkedList;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        LinkedList<ListNode> cache = new LinkedList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        ListNode curr = head;

        while (curr != null) {
            cache.add(curr);
            curr = curr.next;

            if (cache.size() == k) {
                while (!cache.isEmpty()) {
                    prev.next = cache.removeLast();
                    prev = prev.next;
                    prev.next = null;
                }
            }
        }

        while (!cache.isEmpty()) {
            prev.next = cache.removeFirst();
            prev = prev.next;
            prev.next = null;
        }

        return dummy.next;
    }

}
