package learn.tree;

import java.util.Map;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    private static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {



        return null;
    }

//    private TreeNode treeModule(int value) {
//        if() {
//            return new TreeNode(value);
//        }
//
//        TreeNode leftTree = treeModule(value);
//
//        TreeNode right = treeModule(value);
//
//        return new TreeNode(value, leftTree, right);
//    }

    private TreeNode buildTree(int[] preorder, int pStart, int pEnd,
                               int[] inorder, int iStart, int iEnd,
                               Map<Integer, Integer> inMap) {

        if(pStart > pEnd || iStart > iEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - iStart;

//        root. // TODO

        return root;
    }


    public static void main(String[] args) {
        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 t = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105();


    }

}
