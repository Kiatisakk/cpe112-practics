import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMineCraftEP1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        GraphM graph = new GraphM(true, false, n);
        for(int i=0; i<n; i++){
            int src = scan.nextInt();
            int dest = scan.nextInt();
            int dist = scan.nextInt();
            graph.addEdge(src, dest, dist);
        }
        MyAlgorithm algo = new MyAlgorithm();
        int MatAns[][] = algo.floydMat(graph);
        for(int i=0; i<n; i++){
            List<Integer> ansrow = new ArrayList<>();
            System.out.print("From Cave ");
            System.out.print(i);
            System.out.println(", reachable caves:");
            for(int j=0; j<n; j++){
                if (MatAns[i][j]!=0 || i==j) {
                    ansrow.add(j);
                }
            }
            System.out.println(ansrow);
        }
        scan.close();
    }
}
