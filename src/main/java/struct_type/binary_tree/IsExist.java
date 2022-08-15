package struct_type.binary_tree;

public class IsExist {

    public boolean isExist(TreeNode treeNode, int target) {
        if(treeNode == null) {
            return false;
        }

        if(treeNode.val == target) {
            return true;
        }

        boolean leftTree = isExist(treeNode.left, target);
        boolean rightTree = isExist(treeNode.right, target);

        return leftTree || rightTree;
    }

    public boolean isExist_Opt(TreeNode treeNode, int target) {
        if(treeNode == null) {
            return false;
        }

        if(treeNode.val == target) {
            return true;
        }

        if(treeNode.val > target) {
            return isExist(treeNode.left, target);
        }

        return isExist(treeNode.right, target);
    }

    public static void main(String[] args) {
        TreeNode baseTreeNode = TreeNode.getBaseTreeNode();

        IsExist isExist = new IsExist();

//        boolean result = isExist.isExist(baseTreeNode, 4);
        boolean result = isExist.isExist_Opt(baseTreeNode, 4);
        System.out.println("Is 4 in tree ? " + result);

//        boolean result2 = isExist.isExist(baseTreeNode, 99);
        boolean result2 = isExist.isExist_Opt(baseTreeNode, 99);
        System.out.println("Is 99 in tree ? " + result2);
    }
}
