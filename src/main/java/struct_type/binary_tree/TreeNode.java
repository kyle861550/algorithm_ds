package struct_type.binary_tree;

public class TreeNode {

    public TreeNode left, right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this(val);

        this.left = left;
        this.right = right;
    }

    public static TreeNode getBaseTreeNode() {
        TreeNode four = new TreeNode(4);
        four.left = new TreeNode(3);

        TreeNode two = new TreeNode(2, new TreeNode(1), four);
        TreeNode six = new TreeNode(6, null, new TreeNode(7));

        return new TreeNode(5, two, six);
    }

    public static void traverse(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }

        traverse(treeNode.left);
        System.out.print(treeNode.val + ", ");
        traverse(treeNode.right);
    }

}
