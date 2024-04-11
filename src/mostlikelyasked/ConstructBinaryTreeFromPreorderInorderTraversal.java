package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderInorderTraversal {

    int preIdx = 0;
    Map<Integer, Integer> inorder2Idx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || preorder.length == 0 ||
                inorder == null || inorder.length == 0) return null;

        for (int i = 0; i < inorder.length; i++) {
            inorder2Idx.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int l, int r) {

        if (l > r) {
            return null;
        }

        int val = preorder[preIdx++];
        int idx = inorder2Idx.get(val);
        TreeNode node = new TreeNode(val);

        node.left = buildTree(preorder, inorder, l, idx - 1);
        node.right = buildTree(preorder, inorder, idx + 1, r);

        return node;
    }

}
