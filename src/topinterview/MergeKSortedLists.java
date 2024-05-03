package topinterview;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode leftNode = mergeList(lists, left, mid);
        ListNode rightNode = mergeList(lists, mid + 1, right);

        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

}
