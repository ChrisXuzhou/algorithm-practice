package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        traverse(results, nodes);

        return results;
    }

    private void traverse(List<List<Integer>> results, List<TreeNode> nodes) {
        if (nodes.isEmpty()) return;

        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> result = new ArrayList<>(nodes.size());
        for (TreeNode n : nodes) {

            result.add(n.val);
            if (n.left != null) nextLevel.add(n.left);
            if (n.right != null) nextLevel.add(n.right);
        }

        results.add(result);

        traverse(results, nextLevel);
    }

}
