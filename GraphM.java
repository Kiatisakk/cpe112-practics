// implement you code in this file
public class GraphM extends AdjM{
    boolean isDirected;
    boolean isWeighted;
    int numVertices;
    int numEdges;


    public GraphM(boolean isDirected, boolean isWeighted, int n){
        super(n);
        this.numVertices = n;
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
    }
    
    public void addEdge(int i, int j, int weight){
        int actualweight;
        if (isWeighted) {
            actualweight = weight;
        } else{
            actualweight = 1;
        }
        this.matrix[i][j] = weight;
        if (!isDirected) {
            this.matrix[j][i] = actualweight;
        }
        numEdges++;
    }

}
