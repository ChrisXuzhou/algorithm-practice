package mostlikelyasked;

public class SortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode r = new SortList().sortList(n1);
        System.out.println(r.val);

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Find the middle of the list
        ListNode mid = findMiddle(head);

        // Split the list into two halves
        ListNode secondHalf = mid.next;
        mid.next = null;

        // Recursively sort each half
        ListNode sortedFirstHalf = sortList(head);
        ListNode sortedSecondHalf = sortList(secondHalf);

        // Merge the sorted halves
        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null)
            current.next = l1;
        if (l2 != null)
            current.next = l2;

        return dummy.next;
    }
}
