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
            root.left =  insertNode(root.left, newVal);
        }

        if(newVal > root.val) {
            root.right = insertNode(root.right, newVal);
        }

        return root;
    }

    private void recursivePrint(TreeNode node) {
        if(node == null) {
            return;
        }
        recursivePrint(node.left);
        System.out.print(node.val + ", ");
        recursivePrint(node.right);
    }

    public static void main(String[] args) {
        TreeNode baseTreeNode = TreeNode.getBaseTreeNode();

        InsertNode t = new InsertNode();
        t.insertNode(baseTreeNode, 10);
        t.insertNode(baseTreeNode, 8);

        t.recursivePrint(baseTreeNode);
    }

}
