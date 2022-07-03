package learn.tree;

public class BaseModule {

    private static final class TreeNode {
        TreeNode left, right;
        int value;
    }

    public void recursive(TreeNode node) {
        // forward
        recursive(node.left);
        // middle
        recursive(node.right);
        // behind
    }

}
