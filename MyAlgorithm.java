// Implement your code in this file
import java.util.*;

public class MyAlgorithm extends Algorithm{
    
    public MyAlgorithm(){

    }
    public BST insertPro(BST tree, int val){
        BST newTree = cloneTree(tree);
        newTree.insertNode(val);
        return newTree;
    }

    public BST cloneTree(BST tree){
        BST newTree = new BST();
        List<Integer> Order = preorder(tree);
        for(int i : Order){
            newTree.insertNode(i);
        }
        return newTree;
    }

    public int findBalance(BST tree, int Node){
        BinNode targetNode = findNode(tree.root, Node);
        if (targetNode == null) return -1;
        int leftHeight = findHeight(targetNode.leftChild);
        int rightHeight = findHeight(targetNode.rightChild);
        return leftHeight - rightHeight;
    }

    public int findHeight(BST tree, int Node){
        BinNode targetNode = findNode(tree.root, Node);
        if (targetNode == null) return -1;
        int leftHeight = findHeight(targetNode.leftChild);
        int rightHeight = findHeight(targetNode.rightChild);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int findHeight(BinNode curNode){
         if (curNode == null) return 0;
         int leftHeight = findHeight(curNode.leftChild);
         int rightHeight = findHeight(curNode.rightChild);
         return Math.max(leftHeight, rightHeight) + 1;
    }

    private BinNode findNode(BinNode curNode, int Node) {
        if (curNode == null) return null;
        if (curNode.node == Node) return curNode;
        if (Node < curNode.node) return findNode(curNode.leftChild, Node);
        return findNode(curNode.rightChild, Node);
    }

    public List<Integer> preorder(BST tree){
        List<Integer> result = new ArrayList<>();
        preorderHelper(tree.root, result);
        return result;
    }

    private void preorderHelper(BinNode curNode, List<Integer> result) {
        if (curNode == null) return;
        result.add(curNode.node);
        preorderHelper(curNode.leftChild, result);
        preorderHelper(curNode.rightChild, result);
    }

    public List<Integer> inorder(BST tree){
        List<Integer> result = new ArrayList<>();
        inorderHelper(tree.root, result);
        return result;
    }

    private void inorderHelper(BinNode currNode, List<Integer> result) {
        if (currNode == null) return;
        inorderHelper(currNode.leftChild, result);
        result.add(currNode.node);
        inorderHelper(currNode.rightChild, result);
    }

    public List<Integer> postorder(BST tree){
        List<Integer> result = new ArrayList<>();
        postorderHelper(tree.root, result);
        return result;
    }

    private void postorderHelper(BinNode curNode, List<Integer> result) {
        if (curNode == null) return;
        postorderHelper(curNode.leftChild, result);
        postorderHelper(curNode.rightChild, result);
        result.add(curNode.node);
    }

    public List<Integer> dfs(GraphM graph, int startNode){
        boolean isVisited[] = new boolean[graph.numVertices]; // สร้าง isVisited Size เท่า Vertices
        List<Integer> resulList = new ArrayList<>(); // สร้าง Arr เก็บ
        dfsHelper(graph, startNode,isVisited, resulList); // เรียก recursive
        return resulList; 
    }

    private void dfsHelper(GraphM graph, int curNode, boolean isVisited[], List<Integer> resulList){
        isVisited[curNode] = true; // วิ่งมาแล้วให้เปน ture
        resulList.add(curNode); // เก็บค่า
        for(int i=0; i<graph.numVertices; i++){ // วนจนถึงตัวที่ n
            if (!isVisited[i] && graph.matrix[curNode][i] != 0) { // เรียกตัวที่ไม่เคยไปและมีทางไป 
                dfsHelper(graph, i, isVisited, resulList);
            }
        }
    }

    public List<Integer> bfs(GraphL graph, int startNode){
        boolean isVisited[] = new boolean[graph.numVertices]; // สร้าง isVisited มาเก็บว่าวิ่งไปยัง
        List<Integer> resulList = new ArrayList<>(); // สร้าง result ไว้แสดงผล
        Queue<Integer> queue = new LinkedList<>(); // สร้าง Queue ไว้เก็บ
        queue.add(startNode); // เก็บที่วิ่งไปแล้วเข้า Q
        isVisited[startNode]= true; // วิ่งไปแล้วเย่
        while (!queue.isEmpty()) { // ทำไปเรื่อย ๆ จนกว่า Q จะไม่ว่าง
            int front = queue.poll(); // pop q แล้วเก็บค่า
            resulList.add(front); // เก็บเข้า list
            for(Pair<Integer, Integer> neighbor : graph.adjacencyList.get(front)) { // ไล่ทุกตัวใน value ของ key front
                if (!isVisited[neighbor.first]) { // ถ้ายังไม่เคยไป
                    queue.add(neighbor.first); // เก็บเข้า q
                    isVisited[neighbor.first] = true; // เก็บแล้วแปลว่าไปแล้ว
                }
            }

        }
        return resulList; // return 8่าออกมา
    }
    
    public int[][] copyMat(int Mat[][]){
        int newMat[][] = new int[Mat.length][Mat.length];
        for(int i=0; i<Mat.length; i++){
            for(int j=0; j<Mat.length; j++){
                newMat[i][j] = Mat[i][j];
            }
        }
        return newMat;
    }

    public int floyd(GraphM graph, int startNode, int destNode){
        int Mat[][] = graph.matrix.clone();
        for(int k = 0; k < graph.numVertices; k++){
            for(int i = 0; i < graph.numVertices; i++){
                for(int j = 0; j < graph.numVertices; j++){
                    if (Mat[i][k] != 0 && Mat[k][j] != 0 && i!=j) {
                        if(Mat[i][j] == 0){
                            Mat[i][j] = Mat[i][k] + Mat[k][j];
                        }else{
                            Mat[i][j] = Math.min(Mat[i][j], Mat[i][k] + Mat[k][j]);
                        }
                    }
                }
            }
        }
        return Mat[startNode][destNode];
    }

    public int[][] floydMat(GraphM graph){
        int Mat[][] = graph.matrix.clone();
        for(int k = 0; k < graph.numVertices; k++){
            for(int i = 0; i < graph.numVertices; i++){
                for(int j = 0; j < graph.numVertices; j++){
                    if (Mat[i][k] != 0 && Mat[k][j] != 0 && i!=j) { // check i k && k j ว่าวิ่งได้ เพิ่มเงื่อนไข ไม่วิ่งหาตัวเอง
                        if(Mat[i][j] == 0){
                            Mat[i][j] = Mat[i][k] + Mat[k][j];
                        }else{
                            Mat[i][j] = Math.min(Mat[i][j], Mat[i][k] + Mat[k][j]);
                        }
                    }
                }
            }
        }
        return Mat;
    }

    public boolean warshall(GraphM graph, int startNode, int destNode){
        int Mat[][] = graph.matrix.clone(); // clone matrix มา
        for(int k = 0; k < graph.numVertices; k++){ // ไล่ k
            for(int i = 0; i < graph.numVertices; i++){ // i
                for(int j = 0; j < graph.numVertices; j++){ // j
                    if (Mat[i][k] != 0 && Mat[k][j] != 0) { // check i k && k j ว่าวิ่งได้
                        Mat[i][j] = 1; // ให้ i j หากันได้
                    }
                }
            }
        }
        return (Mat[startNode][destNode] == 1); // return boolean
    }

    public int[][] warshallMat(GraphM graph){
        int Mat[][] = graph.matrix.clone();
        for(int k = 0; k < graph.numVertices; k++){
            for(int i = 0; i < graph.numVertices; i++){
                for(int j = 0; j < graph.numVertices; j++){
                    if (Mat[i][k] == 1 && Mat[k][j] == 1) {
                        Mat[i][j] = 1;
                    }
                }
            }
        }
        return Mat;
    }

    public int dijkstra(GraphL graph, int startNode, int destNode){
        int result[] = new int[graph.numVertices];
        boolean isVisited[] = new boolean[graph.numVertices];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[startNode] = 0;
        for(int i = 0; i < graph.numVertices; i++){
            int curNode = -1;
            int leastDist = Integer.MAX_VALUE;
            for(int j = 0; j < graph.numVertices; j++){
                if (!isVisited[j] && result[j] < leastDist) {
                    leastDist = result[j];
                    curNode = j;
                }
            }
            if (curNode == -1) break;
            isVisited[curNode] = true;
            for(Pair<Integer, Integer> neighbor : graph.adjacencyList.get(curNode)){ // ไล่เพื่อนบ้านทุกคน
                if (!isVisited[neighbor.first] && result[curNode] + neighbor.second < result[neighbor.first]) { // ถ้ายังไม่เคยไปหาเพื่อนบ้านและค่าของ curNode + เพื่อนทางไปบ้านเพื่อนน้อยกว่า ทางที่เก็บไว้ให้ทำ
                    result[neighbor.first] = result[curNode] + neighbor.second; // ให้ทางไป = ทางที่สั้นที่สุด
                }
            }
        }
        return result[destNode];   
    }
}