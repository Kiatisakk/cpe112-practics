import java.util.*;
public class MainCokrabue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        GraphM graph = new GraphM(false, false, n);
        
        while(true){
            char inputs = scan.next().charAt(0);
            if (inputs == '0') break;
            char inputsDest = scan.next().charAt(0);
            graph.addEdge((int)inputs-'A', (int)inputsDest-'A', 1);
        }

        MyAlgorithm algo = new MyAlgorithm();
        int Mat[][] = algo.warshallMat(graph);
        
        List<Integer> ans = new ArrayList<>();
        int q = scan.nextInt();
        for(int i = 0; i < q; i++){
            char src = scan.next().charAt(0);
            char dest = scan.next().charAt(0);
            ans.add(Mat[(int)src-'A'][(int)dest-'A']);
        }
        
        for(int i : ans){
            if (i==1) {
                System.out.println("yes");
            } else if (i==0){
                System.out.println("no");
            }
        }
        scan.close();
    }
}