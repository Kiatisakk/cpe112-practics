import java.util.*;
public class MainNetworkEngineer {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ns = scan.nextInt();
        int c = scan.nextInt();
        GraphM graph = new GraphM(false, true, ns);
        for(int i=0; i<c; i++){
            int src = scan.nextInt();
            int dest = scan.nextInt();
            int time = scan.nextInt();
            graph.addEdge(src-1, dest-1, time);
        }
        MyAlgorithm algo = new MyAlgorithm();
        int Mat[][] = algo.floydMat(graph);
        List<Integer> ans = new ArrayList<>();
        int q = scan.nextInt();
        for(int i=0; i<q; i++){
            List<Integer> row = new ArrayList<>();
            int s = scan.nextInt();
            for(int j=0; j<ns; j++){
                row.add(Mat[s-1][j]);
            }
            ans.add(Collections.max(row));
        }
        for(int i : ans){
            System.out.println(i);
        }
        scan.close();
    }
}