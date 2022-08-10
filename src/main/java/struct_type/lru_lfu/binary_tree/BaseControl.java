package struct_type.lru_lfu.binary_tree;

public class BaseControl {

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
        BaseControl baseControl = new BaseControl();

        baseControl.addEveryNode(TreeNode.getBaseTreeNode());
    }

}
