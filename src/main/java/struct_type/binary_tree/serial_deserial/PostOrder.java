package struct_type.binary_tree.serial_deserial;

import struct_type.binary_tree.TreeNode;

import java.util.LinkedList;

public class PostOrder {

    private static final String SEP = ",";
    private static final String NULL = "null";
    private final StringBuilder sb = new StringBuilder();

    public void serialize(TreeNode root) {
        if(root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left);

        serialize(root.right);

        sb.append(root.val).append(SEP);

    }

    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String item : data.split(SEP)) {
            list.addLast(item);
        }
        return _deserialize(list);
    }

    private TreeNode _deserialize(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }

        String s = list.removeLast();
        if(NULL.equals(s)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(s));

        root.right = _deserialize(list);
        root.left = _deserialize(list);

        return root;
    }

    public static void main(String[] args) {
        PostOrder postOrder = new PostOrder();

        TreeNode leftTree = new TreeNode(2, null, new TreeNode(4));
        TreeNode rightTree = new TreeNode(3);
        TreeNode tree = new TreeNode(1, leftTree, rightTree);

        postOrder.serialize(tree);
        String s = postOrder.sb.toString();
        System.out.println(s);

        TreeNode deserialize = postOrder.deserialize(s);
    }

}
