package struct_type.lru_lfu.binary_tree;

public class CompareTree {

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }

        if(root1 == null || root2 == null) {
            return false;
        }

        if(root1.val != root2.val) {
            return false;
        }

        boolean leftTree = isSameTree(root1.left, root2.left);

        boolean rightTree = isSameTree(root1.right, root2.right);

        return leftTree && rightTree;
    }

    public static void main(String[] args) {
        TreeNode tree1 = TreeNode.getBaseTreeNode();
        TreeNode tree2 = TreeNode.getBaseTreeNode();

        CompareTree compareTree = new CompareTree();
        boolean result = compareTree.isSameTree(tree1, tree2);

        System.out.println("Is same tree: " + result);
        // -----------------------------------------------------------------


        tree2.left = new TreeNode(1);
        boolean result2 = compareTree.isSameTree(tree1, tree2);

        System.out.println("Is same tree: " + result2);
    }

}