import java.util.*;

public class MainMineCraftEP2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        GraphM graph = new GraphM(false, false, n);
        for(int i=0; i<m; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            graph.addEdge(u, v, 1);
        }
        int s = scan.nextInt();
        int vil = scan.nextInt();
        int z = scan.nextInt();
        MyAlgorithm algo = new MyAlgorithm();
        int MatAns[][] = algo.floydMat(graph);
        if (MatAns[s][vil]>MatAns[z][vil]) {
            System.out.println("SAFE");
        } else{
            System.out.println("TOO Late");
        }
        scan.close();
    }   
}
