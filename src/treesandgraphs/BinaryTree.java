package treesandgraphs;

public class BinaryTree {

    // Given a binary tree, determine if it is a valid binary search tree (BST).
    public boolean check(Node root) {
        if (root == null) {
            return false;
        }

        // left side is not a binary search tree
        if (root.left != null && !check(root.left)) {
            return false;
        }

        // right side is not either.
        if (root.right != null && !check(root.right)) {
            return false;
        }

        // left < root
        if (root.left != null && root.left.val > root.val) {
            return false;
        }

        // root < right
        if (root.right != null && root.right.val < root.val) {
            return false;
        }

        return true;
    }
}
