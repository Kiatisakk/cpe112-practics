public class MainClone {
    public static void main(String[] args) {
        BST myTree = new BST();
        myTree.insertNode(4537);
        myTree.insertNode(3844);
        myTree.insertNode(8972);
        myTree.insertNode(1231);
        myTree.insertNode(4074);
        MyAlgorithm algo = new MyAlgorithm();
        System.out.println(algo.preorder(myTree));

        BST newTree = algo.insertPro(myTree, 1088);
        System.out.println(algo.preorder(newTree));

    }
}