package struct_type.binary_tree.tree_count;

import struct_type.binary_tree.TreeNode;

public class CompleteTree {

    public int getCompleteTree(TreeNode root) {
        TreeNode left = root;
        TreeNode right = root;

        int leftH = 0;
        while (left != null) {
            left = left.left;
            leftH++;
        }

        int rightH = 0;
        while (right != null) {
            right = right.right;
            rightH++;
        }

        if(rightH == leftH) {
            System.out.println("Prefect");
            return (int) Math.pow(2, rightH) - 1;
        }

        return 1 + getCompleteTree(root.left) + getCompleteTree(root.right);
    }

    public static void main(String[] args) {
        CompleteTree completeTree = new CompleteTree();

        TreeNode leftTree = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode rightTree = new TreeNode(7, new TreeNode(6), null);
        TreeNode tree = new TreeNode(5, leftTree, rightTree);

        int result = completeTree.getCompleteTree(tree);

        System.out.println("Complete tree count: " + result);
    }

}
