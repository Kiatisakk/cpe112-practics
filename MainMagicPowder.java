import java.util.*;
public class MainMagicPowder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int e = scan.nextInt();
        GraphL graph = new GraphL(false, false, n+1, e);
        
        List<Integer> target = new ArrayList<>();
        for(int i=0; i<e; i++){
            int v1 = scan.nextInt();
            String ex = scan.next();
            int v2 = scan.nextInt();
            if (ex.equals("=")) {
                target.add(v1);
                target.add(v2);
            }
            graph.addEdge(v1, v2, 1);
        }
        
        List<Integer> srcNode = new ArrayList<>();
        for (int vertex : graph.adjacencyList.keySet()) {
            List<Pair<Integer, Integer>> neighbors = graph.adjacencyList.get(vertex);
            if (neighbors != null && neighbors.size() == 1) {
                srcNode.add(vertex);
            }
        }

        MyAlgorithm algo = new MyAlgorithm();

        List<Integer> dist = new ArrayList<>();
        for(int n2 : target) {
            for(int n1 : srcNode){
                int result = algo.dijkstra(graph, n1, n2);
                dist.add(result);
            }
        }
        System.out.println(Collections.min(dist)+1);
        scan.close();
    }
}
