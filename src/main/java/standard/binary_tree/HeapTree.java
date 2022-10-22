package standard.binary_tree;

public class HeapTree<V> {

    public static final class HeapTreeNode<V> {
        private final int priority;
        private V value;

        public HeapTreeNode<V> left, right;

        public HeapTreeNode(int priority, V value) {
            this.priority = priority;
            this.value = value;
        }
    }

    private int count;
    private HeapTreeNode<V> header;

    public HeapTree(HeapTreeNode<V> header) {
        this.count = 0;
        this.header = header;
    }

    public void enqueue(int priority, V val) {
        _enqueue(header, priority, val);
        count += 1;
    }

    private HeapTreeNode<V> _enqueue(HeapTreeNode<V> root, int priority, V val) {
        if(root == null) {
            return new HeapTreeNode<>(priority, val);
        }

        if(root.priority >= priority) {
            root.left = _enqueue(root.left, priority, val);
        } else if (root.priority < priority) {
            root.right = _enqueue(root.right, priority, val);
        }

        return root;
    }

    public HeapTreeNode<V> dequeue() {
        HeapTreeNode<V> max = _getMax(header);
        header = _removeMax(header);
        count -= 1;
        return max;
    }

    private HeapTreeNode<V> _getMax(HeapTreeNode<V> root) {
        if(root.right == null) {
            return root;
        }

        return _getMax(root.right);
    }

    private HeapTreeNode<V> _removeMax(HeapTreeNode<V> root) {
        if(root.right == null) {
            return root.left;
        }

        root.right = _removeMax(root.right);

        return root;
    }


    public static void main(String[] args) {
        HeapTree<String> heapTree = new HeapTree<>(new HeapTreeNode<>(9, "F"));

        heapTree.enqueue(5, "B");
        heapTree.enqueue(2, "He");
        heapTree.enqueue(8, "O");

        heapTree.enqueue(12, "Mg");
        heapTree.enqueue(10, "Ne");
        heapTree.enqueue(14, "Si");

        int c = heapTree.count;
        for(int i = 0; i < c; i++) {
            HeapTreeNode<String> node = heapTree.dequeue();
            System.out.println("priority: " + node.priority + ", val:" + node.value);
        }

    }
}
