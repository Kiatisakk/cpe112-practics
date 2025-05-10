public class BSTRecursive extends BinTree {
    public BSTRecursive() {
        super();
    }

    public void insertNode(int value) {
        root = insertRecursive(root, value);
    }

    private BinNode insertRecursive(BinNode current, int value) {
        if (current == null) {
            return new BinNode(value);
        }

        if (value < current.node) {
            current.leftChild = insertRecursive(current.leftChild, value);
        } else {
            current.rightChild = insertRecursive(current.rightChild, value);
        }
        
        return current;
    }
}
