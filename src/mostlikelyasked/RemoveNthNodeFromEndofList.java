package mostlikelyasked;

import java.util.stream.IntStream;

public class RemoveNthNodeFromEndofList {

    public static void main(String[] args) {

        ListNode h = new ListNode(-1);
        ListNode prev = h;
        for (int i = 1; i < 2; i++) {
            ListNode n = new ListNode(i);
            prev.next = n;
            prev = n;
        }

        new RemoveNthNodeFromEndofList()
                .removeNthFromEnd(h.next, 1);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummpy = new ListNode(-1);
        dummpy.next = head;
        ListNode fast = dummpy;
        ListNode slow = dummpy;


        // make fast n step further
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

//        System.out.println(slow.val);
        slow.next = slow.next.next;

        return dummpy.next;
    }

}
