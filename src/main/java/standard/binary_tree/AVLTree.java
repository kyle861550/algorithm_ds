package standard.binary_tree;

public class AVLTree {

    private final AVLTreeNode header;

    public AVLTree(AVLTreeNode header) {
        this.header = header;
    }

    public AVLTreeNode insert(int val) {
        _insert(header, val);
        return header;
    }

    private AVLTreeNode _insert(AVLTreeNode root, int val) {
        if(root == null) {
            return new AVLTreeNode(val);
        }

        if(root.val <= val) {
            root.right = _insert(root.right, val);
            root = resolveRightLeaning(root);
        } else if(root.val > val) {
            root.left = _insert(root.left, val);
            root = resolveLeftLeaning(root);
        }

        root.computeHeight();

        return root;
    }

    public AVLTreeNode remove(int val) {
        _remove(header, val);
        return header;
    }

    public AVLTreeNode _remove(AVLTreeNode root, int val) {
        if(root == null) {
            return null;
        }

        if(root.val <= val) {
            root.right = _remove(root.right, val);
            root = resolveRightLeaning(root);
        } else if(root.val > val) {
            root.left = _remove(root.left, val);
            root = resolveLeftLeaning(root);
        } else {
            if(root.left == null && root.right == null) {
                return null;
            }

            if(root.right == null) {
                return root.left;
            }
            if(root.left == null) {
                return root.right;
            }

            AVLTreeNode tmp = root;

            root = root.right;
            while (root != null) {
                root = root.left;
            }

            AVLTreeNode fix = _removeMin(tmp.right);

            root.left = tmp.left;
            root.right = fix;
            root = resolveRightLeaning(root);
        }
        root.computeHeight();

        return root;
    }

    private AVLTreeNode _removeMin(AVLTreeNode node) {
        if(node.left == null) {
            return node.right;
        }

        node.left = _removeMin(node.left);
        node = resolveRightLeaning(node);

        return node;
    }

    private AVLTreeNode resolveLeftLeaning(AVLTreeNode node) {
        if(node.diffHeight() == 2) {
            if(node.left.diffHeight() >= 0) {
                node = rotateRight(node);
            } else {
                node = rotateLeftRight(node);
            }
        }
        return node;
    }


    private AVLTreeNode resolveRightLeaning(AVLTreeNode node) {
        if(node.diffHeight() == 2) {
            if(node.right.diffHeight() >= 0) {
                node = rotateLeft(node);
            } else {
                node = rotateRightLeft(node);
            }
        }
        return node;
    }

    private AVLTreeNode rotateLeft(AVLTreeNode node) {
        AVLTreeNode newRoot = node.right;

        AVLTreeNode nRootL = newRoot.left;

        node.right = nRootL;

        newRoot.left = node;

        node.computeHeight();
        return newRoot;
    }

    private AVLTreeNode rotateRight(AVLTreeNode node) {
        AVLTreeNode newRoot = node.left;

        AVLTreeNode nRootR = newRoot.right;

        node.left = nRootR;

        newRoot.right = node;

        node.computeHeight();
        return newRoot;
    }

    private AVLTreeNode rotateRightLeft(AVLTreeNode node) {
        AVLTreeNode child = node.right;
        AVLTreeNode newRoot = child.left;

        AVLTreeNode nRootR = newRoot.right;
        AVLTreeNode nRootL = newRoot.left;

        child.right = nRootR;
        node.left = nRootL;

        newRoot.left = child;
        newRoot.right = node;

        child.computeHeight();
        node.computeHeight();
        return newRoot;
    }

    private AVLTreeNode rotateLeftRight(AVLTreeNode node) {
        AVLTreeNode child = node.left;
        AVLTreeNode newRoot = child.right;

        AVLTreeNode nRootR = newRoot.right;
        AVLTreeNode nRootL = newRoot.left;

        child.right = nRootR;
        node.left = nRootL;

        newRoot.left = child;
        newRoot.right = node;

        child.computeHeight();
        node.computeHeight();
        return newRoot;
    }

    public static void main(String[] args) {
        AVLTreeNode root = AVLTreeNode.getDefaultTree();

        AVLTree avlTree = new AVLTree(root);

//        avlTree.insert(27);
        System.out.println("-------------------------------------\n");
        avlTree.remove(58);
    }
}

final class AVLTreeNode {
    public AVLTreeNode left, right;
    public final int val;

    public int height;

    public AVLTreeNode(int val) {
        this.val = val;
        height = 0;
    }

    public int diffHeight() {
        int leftH = left == null ? -1 : left.height;
        int rightH = right == null ? -1 : right.height;
//        System.out.println("Self val: " + val + ", left/right: " + leftH + "/" + rightH + ", diff height: " + (leftH - rightH));
        return leftH - rightH;
    }

    public void computeHeight() {
        int leftH = left == null ? -1 : left.height;
        int rightH = right == null ? -1 : right.height;
        height = 1 + Math.max(leftH, rightH);

        System.out.println("Self val: " + val + ", height: " + height);
    }

    public static AVLTreeNode getDefaultTree() {
        AVLTreeNode root = new AVLTreeNode(19);

        AVLTree avlTree = new AVLTree(root);

        avlTree.insert(14);
        avlTree.insert(3);
        avlTree.insert(15);
        avlTree.insert(53);
        avlTree.insert(26);
        avlTree.insert(58);
        avlTree.insert(29);

        return root;
    }

}