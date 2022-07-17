package learn.bfs;

import java.util.*;

public class BfsModule {

    private static final class Node {
        List<Node> nodes = new ArrayList<>();
        int val;
    }

    private int bfs(Node start, Node target) {
        LinkedList<Node> nodes = new LinkedList<>();
        Set<Node> pathRecord = new HashSet<>();

        nodes.push(start);
        pathRecord.add(start);

        int step = 0;

        while (!nodes.isEmpty()) {
            int size = nodes.size();

            for(int i = 0; i < size; i++) {
                Node curNode = nodes.poll();

                if(curNode == null) continue;

                if(curNode.val == target.val) {
                    return step;
                }

                for(Node item : curNode.nodes) {
                    if(!pathRecord.contains(item)) {
                        nodes.push(item);
                        pathRecord.add(item);
                    }
                }
            }
        }

        return step;
    }

}
