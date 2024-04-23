package mostlikelyasked;

public class DiameterBinaryTree {

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        lengthOfTree(root);

        return maxDiameter;
    }

    private int lengthOfTree(TreeNode node) {

        if (node == null) return -1;

        int leftLength = lengthOfTree(node.left) + 1;
        int rightLength = lengthOfTree(node.left) + 1;
        int length = Math.max(leftLength, rightLength);
        int diameter = leftLength + rightLength;

        if (diameter > maxDiameter) maxDiameter = diameter;

        System.out.println(node.val + "," + length + "," + diameter + "," + maxDiameter);

        return length;

    }

}
