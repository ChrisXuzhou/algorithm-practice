package topinterview;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        int added = 0;
        while (l1 != null || l2 != null) {

            ListNode curr = new ListNode();

            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + added;
            int val = sum % 10;
            added = sum / 10;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            curr.val = val;
            prev.next = curr;
            prev = curr;
        }

        if (added != 0) {
            prev.next = new ListNode(added);
        }

        return dummy.next;
    }

}
