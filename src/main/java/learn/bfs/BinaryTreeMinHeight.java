package learn.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeMinHeight {

    public static final class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public int minDepth(BinaryTreeNode treeNode) {
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();

        queue.push(treeNode);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                BinaryTreeNode curNode = queue.poll();

                if(curNode == null ||
                        (curNode.left == null && curNode.right == null)) {
                  return depth;
                }

                if(curNode.right != null) {
                    queue.push(curNode.right);
                }

                if(curNode.left != null) {
                    queue.push(curNode.left);
                }

            }
            depth++;
        }

        return depth == 0 ? -1 : depth;
    }

}
