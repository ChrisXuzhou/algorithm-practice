package mostlikelyasked;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow is the middle element in this list

        ListNode reversed = reverse(slow.next);
        slow.next = null;

        while (reversed != null) {

            if (reversed.val != head.val) {
                return false;
            }

            reversed = reversed.next;
            head = head.next;
        }

        return  true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

}
