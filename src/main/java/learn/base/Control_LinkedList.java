package learn.base;

public class Control_LinkedList {

    public static void main(String[] args) {
    }

    public static final class Node {
        Node next;
        int value;
    }

    public void traverse(Node node) {
        Node tmp = node;

        while (tmp != null) {
            System.out.println("Value: " + tmp.value);
            tmp = tmp.next;
        }
    }

    public void recursive(Node node) {
        // forward value
        recursive(node.next);
        // behind value
    }


    public static final class TreeNode {
        TreeNode left, right;
        int value;
    }

    public void treeRecursive(TreeNode treeNode) {
        // forward
        treeRecursive(treeNode.left);
        // middle
        treeRecursive(treeNode.right);
        // behind
    }
}
