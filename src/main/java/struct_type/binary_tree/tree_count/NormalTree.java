package struct_type.binary_tree.tree_count;


import struct_type.binary_tree.TreeNode;

public class NormalTree {

    public int getNormalTreeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftCount = getNormalTreeCount(root.left);

        int rightCount = getNormalTreeCount(root.right);

        return leftCount + rightCount + 1;      // add self
    }


    public int getNormalTreeCount_2(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return 1;
        }

        int leftCount = getNormalTreeCount_2(root.left);

        int rightCount = getNormalTreeCount_2(root.right);

        return leftCount + rightCount + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getBaseTreeNode();

        NormalTree normalTree = new NormalTree();
        int result = normalTree.getNormalTreeCount(treeNode);
//        int result = normalTree.getTreeCount_2(treeNode);

        System.out.println("Normal tree count: " + result);
    }
}
