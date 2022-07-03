package learn.tree;

public class Binary_Tree_Maximum_Path_Sum_124 {
    private static final class TreeNode {
        TreeNode left, right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return res;
    }

    private int oneSideMax(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftValue = Math.max(0, oneSideMax(root.left));

        int rightValue = Math.max(0, oneSideMax(root.right));

        res = Math.max(res, leftValue + rightValue + root.val);

        return Math.max(leftValue, rightValue) + root.val;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10);

        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        int i = new Binary_Tree_Maximum_Path_Sum_124().maxPathSum(treeNode);

        System.out.println("Max path value sum: " + i);
    }
}
