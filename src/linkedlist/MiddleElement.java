package linkedlist;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleElement {

    // Implement an algorithm to find the middle element of a singly linked list.

    public ListNode find(ListNode list) {

        ListNode slow = list;
        ListNode fast = list;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

        // O(n)
    }

}
