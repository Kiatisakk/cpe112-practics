import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainMagicPowder_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int e = scan.nextInt();
        GraphM graph = new GraphM(false, false, n);
        
        List<Integer> target = new ArrayList<>();
        for(int i=0; i<e; i++){
            int v1 = scan.nextInt();
            String ex = scan.next();
            int v2 = scan.nextInt();
            if (ex.equals("=")) {
                target.add(v1-1);
                target.add(v2-1);
            }
            graph.addEdge(v1-1, v2-1, 1);
        }

        List<Integer> srcNode = new ArrayList<>();
        for(int i=0; i<graph.numVertices; i++){
            int count = 0;
            for(int j=0; j<graph.numVertices; j++){
                if (graph.matrix[i][j] != 0 && i!=j) {
                    count++;
                }
            }
            if (count == 1) {
                srcNode.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        MyAlgorithm algo = new MyAlgorithm();
        int MatFloyd[][] = algo.floydMat(graph);
        for(int i : srcNode){
            for(int j : target){
                ans.add(MatFloyd[i][j]);
            }
        }
        System.out.println(Collections.min(ans)+1);
        scan.close();
    }   
}
