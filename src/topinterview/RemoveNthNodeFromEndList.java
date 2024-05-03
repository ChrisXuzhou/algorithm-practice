package topinterview;

public class RemoveNthNodeFromEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null) {

            fast = fast.next;
            if (n + 1 > 0) {
                n--;
            } else {
                slow = slow.next;
            }
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
