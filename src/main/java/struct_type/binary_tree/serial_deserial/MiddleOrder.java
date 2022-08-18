package struct_type.binary_tree.serial_deserial;

import struct_type.binary_tree.TreeNode;

public class MiddleOrder {

    private static final String SEP = ",";
    private static final String NULL = "null";
    private final StringBuilder sb = new StringBuilder();

    public void serialize(TreeNode root) {
        if(root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left);

        sb.append(root.val).append(SEP);

        serialize(root.right);
    }

    public static void main(String[] args) {
        MiddleOrder middleOrder = new MiddleOrder();

        TreeNode leftTree = new TreeNode(2, null, new TreeNode(4));
        TreeNode rightTree = new TreeNode(3);
        TreeNode tree = new TreeNode(1, leftTree, rightTree);

        middleOrder.serialize(tree);
        String s = middleOrder.sb.toString();
        System.out.println(s);
    }

}
