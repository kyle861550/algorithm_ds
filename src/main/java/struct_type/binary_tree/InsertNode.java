package struct_type.binary_tree;

public class InsertNode {

    TreeNode insertNode(TreeNode root, int newVal) {
        if(root == null) {
            return new TreeNode(newVal);
        }

        if(root.val == newVal) {
            return root;
        }

        if(newVal < root.val) {
            return insertNode(root.left, newVal);
        }

        if(newVal > root.val) {
            return insertNode(root.right, newVal);
        }

        return root;
    }

    public static void main(String[] args) {


    }

}
