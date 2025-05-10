public class MainFactor {
    public static void main(String[] args) {
        BST myTree = new BST();
        myTree.insertNode(4537);
        myTree.insertNode(3844);
        myTree.insertNode(8972);
        myTree.insertNode(1231);
        myTree.insertNode(4074);
        myTree.insertNode(1088);
        MyAlgorithm algo = new MyAlgorithm();
        System.out.println(algo.findBalance(myTree, 4537));
        System.out.println(algo.findHeight(myTree, 4537));
    }
}
