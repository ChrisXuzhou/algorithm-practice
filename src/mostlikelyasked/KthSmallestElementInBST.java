package mostlikelyasked;

import java.util.Stack;

public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;

        while (true) {

            while (n != null) {
                stack.push(n);
                n = n.left;
            }

            n = stack.pop();
            k --;

            if (k == 0) return n.val;

            n = n.right;
        }
    }

}
