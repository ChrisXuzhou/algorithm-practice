package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(result, root);

        return result;
    }

    private void traversal(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }

        traversal(result, node.left);
        result.add(node.val);
        traversal(result, node.right);
    }
}
