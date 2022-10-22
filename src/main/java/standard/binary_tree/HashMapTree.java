package standard.binary_tree;

public class HashMapTree<V> {

    public static final class HashMapTreeNode<V> {
        private final int key;
        private V value;

        public HashMapTreeNode<V> left, right;

        public HashMapTreeNode(int key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final HashMapTreeNode<V> header;

    public HashMapTree(HashMapTreeNode<V> header) {
        this.header = header;
    }

    public HashMapTreeNode<V> put(int key, V val) {
        _put(header, key, val);
        return header;
    }

    private HashMapTreeNode<V> _put(HashMapTreeNode<V> root, int key, V val) {
        if(root == null) {
            return new HashMapTreeNode<>(key, val);
        }

        if(root.key >= key) {
            root.left = _put(root.left, key, val);
        } else if (root.key < key) {
            root.right = _put(root.right, key, val);
        }

        return root;
    }

    public V get(int key) {
        HashMapTreeNode<V> result = _get(header, key);

        return result == null ? null : result.value;
    }

    private HashMapTreeNode<V> _get(HashMapTreeNode<V> root, int key) {
        if(root == null) {
            return null;
        }

        if(root.key == key) {
            return root;
        }

        if(root.key >= key) {
            return _get(root.left, key);
        } else if(root.key < key) {
            return _get(root.right, key);
        }

        return null;
    }

    public void inorder() {
        _inorder(header);
    }

    private void _inorder(HashMapTreeNode<V> root) {
        if(root == null) {
            return;
        }
        _inorder(root.left);

        System.out.println("key: " + root.key + ", value: " + root.value);

        _inorder(root.right);
    }

    public static void main(String[] args) {
        HashMapTreeNode<String> root = new HashMapTreeNode<>(53, "C");

        HashMapTree<String> tree = new HashMapTree<>(root);

        tree.put(5, "A");
        tree.put(20, "B");
        tree.put(58, "D");
        tree.put(76, "E");
        tree.put(79, "F");

        tree.inorder();

//        String result = tree.get(76);
//        System.out.println("Result: " + result);
    }

}
