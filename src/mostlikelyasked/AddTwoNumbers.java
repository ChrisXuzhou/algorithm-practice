package mostlikelyasked;

public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cl1 = l1;
        ListNode cl2 = l2;

        ListNode ans = new ListNode(0);
        ListNode prev = ans;

        int tmp = 0;
        while (cl1 != null || cl2 != null || tmp != 0) {

            ListNode curr = new ListNode(0);
            prev.next = curr;

            int v1= cl1 != null ? cl1.val : 0;
            int v2 = cl2 != null ? cl2.val : 0;
            int sum = tmp + v1 + v2;

            curr.val = sum % 10;
            tmp = sum / 10;

            cl1 = cl1 != null ? cl1.next : null;
            cl2 = cl2 != null ? cl2.next : null;
            prev = curr;
        }

        return ans.next;
    }
}