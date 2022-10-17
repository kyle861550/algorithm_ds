package struct_type.binary_tree;

public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int deleteKey) {
        // base case
        if(root == null) {
            return null;
        }

        if(root.val == deleteKey) {

            if(root.right == null && root.left == null) {
                return null;
            }

            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;

            root.right = deleteNode(root.right, minNode.val);
        }

        if(root.val > deleteKey) {
            root.left = deleteNode(root.left, deleteKey);
        }

        if(root.val < deleteKey) {
            root.right = deleteNode(root.right, deleteKey);
        }

        return root;
    }

    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode baseTreeNode = TreeNode.getBaseTreeNode();

        DeleteNode deleteNode = new DeleteNode();
        TreeNode result = deleteNode.deleteNode(baseTreeNode, 5);

        TreeNode.traverse(result);
    }
}
