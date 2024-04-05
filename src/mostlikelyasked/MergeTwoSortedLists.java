package mostlikelyasked;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode prev = dummy;

        while (curr1 != null && curr2 != null) {
             if (curr1.val > curr2.val) {
                 prev.next = curr2;
                 prev = curr2;
                 curr2 = curr2.next;
             } else {
                 prev.next = curr1;
                 prev = curr1;
                 curr1 = curr1.next;
             }
        }

        if (curr1 != null) {
            prev.next = curr1;
        }

        if (curr2 != null) {
            prev.next = curr2;
        }

        return dummy.next;
    }

}
