package linkedlist;

public class MergeAndSort {

    // Given two sorted linked lists, merge them into a single sorted linked list.
    public ListNode merge(ListNode a, ListNode b){

        ListNode head = new ListNode(-1);
        ListNode c = head;
        while (a != null && b != null) {
            // iterate and merge
            if (a.val < b.val) {
                c.next = a;
                a = a.next;
            } else {
                c.next = b;
                b = b.next;
            }
            c = c.next;
        }

        if (a != null) {
            // append the suffix
            c.next = a;
        }

        if (b != null) {
            // append and merge
            c.next = b;
        }

        return head.next;
    }

}
