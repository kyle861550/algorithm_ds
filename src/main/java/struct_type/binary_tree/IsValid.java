package struct_type.binary_tree;

public class IsValid {


    boolean isValidTree_Problem(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.val <= root.left.val) {
            return false;
        }

        if(root.right != null && root.val >= root.right.val) {
            return false;
        }

        boolean leftTree = isValidTree_Problem(root.left);
        boolean rightTree = isValidTree_Problem(root.right);

        return leftTree && rightTree;
    }

    boolean isValidTree(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }

        if(max != null && root.val >= max.val) {
            return false;
        }

        if(min != null && root.val <= min.val) {
            return false;
        }

        boolean leftTree = isValidTree(root.left, min, root);
        boolean rightTree = isValidTree(root.right, root, max);

        return leftTree && rightTree;
    }


    public static void main(String[] args) {
        IsValid isValid = new IsValid();

        TreeNode sub = new TreeNode(15, new TreeNode(9), new TreeNode(20));
        TreeNode treeNode = new TreeNode(10, new TreeNode(2), sub);


        boolean result = isValid.isValidTree_Problem(treeNode);
        System.out.println("Is valid result: " + result);

        // -----------------------------------------------------------------------------------

        boolean result2 = isValid.isValidTree(treeNode, null, null);
        System.out.println("Is valid result with 9: " + result2);

        sub.left = new TreeNode(11);
        boolean result3 = isValid.isValidTree(treeNode, null, null);
        System.out.println("Is valid result with 13: " + result3);
    }
}
