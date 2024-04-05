package mostlikelyasked;

public class SwapNodesInPairs {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;

        while (true) {
            if (curr.next != null && curr.next.next != null) {

                // do swap
                ListNode next = curr.next.next.next;
                ListNode tail = curr.next;
                curr.next = curr.next.next;
                curr.next.next = tail;
                tail.next = next;
                curr = tail;
            } else {
                break;
            }
        }

        return dummy.next;
    }

}
