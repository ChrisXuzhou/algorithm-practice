package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        traverse(root, 0, ret);

        return ret;
    }

    private void traverse(TreeNode node, int level, List<Integer> ret) {

        if (node == null) return;

        if (ret.size() == level) {
            ret.add(node.val);
        }

        traverse(node.right, level + 1, ret);
        traverse(node.left, level + 1, ret);
    }

}
