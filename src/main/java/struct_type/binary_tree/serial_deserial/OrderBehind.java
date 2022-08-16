package struct_type.binary_tree.serial_deserial;

import struct_type.binary_tree.TreeNode;

import java.util.LinkedList;

public class OrderBehind {

    private final LinkedList<Integer> valList = new LinkedList<>();

    public void traverse_List(TreeNode root) {
        if(root == null) {
            valList.addLast(-1);
            return;
        }

        valList.addLast(root.val);

        traverse_List(root.left);
        traverse_List(root.right);
    }

    private static final String SEP = ",";
    private static final String NULL = "null";

    private final StringBuilder stringBuilder = new StringBuilder();

    public void traverse_String(TreeNode root) {
        if(root == null) {
            stringBuilder.append(NULL).append(SEP);
            return;
        }

        stringBuilder.append(root.val).append(SEP);

        traverse_String(root.left);
        traverse_String(root.right);
    }

    public TreeNode deserialize(String nodes) {
        LinkedList<String> list = new LinkedList<>();
        for(String item : nodes.split(SEP)) {
            list.addLast(item);
        }
        return _deserialize(list);
    }

    private TreeNode _deserialize(LinkedList<String> list) {
        if(list.isEmpty()) {
            return null;
        }

        String first = list.removeFirst();
        if(first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = _deserialize(list);
        root.right = _deserialize(list);

        return root;
    }

    public static void main(String[] args) {
        OrderBehind orderBehind = new OrderBehind();


        TreeNode leftTree = new TreeNode(2, null, new TreeNode(4));
        TreeNode rightTree = new TreeNode(3);
        TreeNode tree = new TreeNode(1, leftTree, rightTree);

//        orderBehind.traverse_List(tree);
//
//        System.out.println(orderBehind.valList);

        orderBehind.traverse_String(tree);

        String s = orderBehind.stringBuilder.toString();
        System.out.println(s);

        TreeNode deserialize = orderBehind.deserialize(s);
    }


}
