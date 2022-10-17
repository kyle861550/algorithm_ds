package struct_type.binary_tree;

public class DeleteNode_2 {

    public TreeNode deleteNode(TreeNode root, int deleteKey) {
        // base case
        if(root == null) {
            return null;
        }


        if(root.val > deleteKey) {
            root.left = deleteNode(root.left, deleteKey);

        } else if(root.val < deleteKey) {
            root.right = deleteNode(root.right, deleteKey);

        } else if(root.val == deleteKey) {

            if(root.right == null && root.left == null) {
                return null;
            }

            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            TreeNode tmp = root;

            root = root.right;
            while (root.left != null) {
                root = root.left;
            }

            root.right = removeMin(tmp.right);
            root.left = tmp.left;
        }

        return root;
    }

    private TreeNode removeMin(TreeNode node) {
        if(node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public static void main(String[] args) {
        TreeNode baseTreeNode = TreeNode.getBaseTreeNode();

        DeleteNode_2 d2 = new DeleteNode_2();
        TreeNode result = d2.deleteNode(baseTreeNode, 5);

        TreeNode.traverse(result);
    }
}
