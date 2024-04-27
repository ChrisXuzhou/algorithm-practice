package mostlikelyasked;

public class BinaryTreeMaximumPathSum {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    private int calculateMaxPathSum(TreeNode node) {
        if (node == null) return 0;

        // Recursively calculate the maximum path sum in the left and right subtrees
        int leftSum = Math.max(0, calculateMaxPathSum(node.left));
        int rightSum = Math.max(0, calculateMaxPathSum(node.right));

        // Update the maximum path sum found so far
        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

        // Return the maximum path sum starting from the current node
        return Math.max(leftSum, rightSum) + node.val;
    }

}
