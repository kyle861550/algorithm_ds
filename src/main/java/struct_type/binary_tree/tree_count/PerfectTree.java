package struct_type.binary_tree.tree_count;

import struct_type.binary_tree.TreeNode;

public class PerfectTree {

    public int getPerfectTreeCount(TreeNode root) {

        int height = 0;
        while (root != null) {
            root = root.left;   // same as right
            height++;
        }

        return (int) (Math.pow(2, height) - 1);
    }

    public static void main(String[] args) {
        PerfectTree perfectTree = new PerfectTree();

        TreeNode leftTree = new TreeNode(2, new TreeNode(1), new TreeNode(4));
        TreeNode rightTree = new TreeNode(7, new TreeNode(6), new TreeNode(8));
        TreeNode tree = new TreeNode(5, leftTree, rightTree);

        int result = perfectTree.getPerfectTreeCount(tree);

        System.out.println("Perfect tree count: " + result);

    }
}
