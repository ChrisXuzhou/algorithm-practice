package mostlikelyasked;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (node != null) {

            if (node.right != null) {
                stack.add(node.right);
                node.right = null;
            }

            if (node.left != null) {
                node.right = node.left;
                node.left = null;
                node = node.right;

                continue;
            } else if (!stack.isEmpty()){
                TreeNode next = stack.pop();
                node.right = next;
                node = next;

                continue;
            }

            break;
        }
    }
}
