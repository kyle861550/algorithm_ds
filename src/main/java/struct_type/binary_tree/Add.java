package struct_type.binary_tree;

public class Add {

    public void addEveryNode(TreeNode root) {
        // base case
        if(root == null) {
            return;
        }

        System.out.print("Old: " + root.val);
        root.val += 1;
        System.out.println(", New: " + root.val);

        addEveryNode(root.left);
        addEveryNode(root.right);
    }

    public static void main(String[] args) {
        Add add = new Add();

        add.addEveryNode(TreeNode.getBaseTreeNode());
    }

}
