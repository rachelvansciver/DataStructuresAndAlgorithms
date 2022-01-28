import java.util.*;

public class Kruskal{
    static int max = 9999990;
    static int[] nodes = {0,1,2,3,4,5};
    static int[][] edges = {
            {max,16,4,max,max,max},
            {16,max,3,4,max,4},
            {4,3,max,max,6,2},
            {max,4,max,max,3,1},
            {max,max,6,3,max,2},
            {max,4,3,1,2,max}};
    static int[][] sortedEdges = new int[edges.length][edges.length];
    static LinkedList MST = new LinkedList();
    public static void Kruskal() {

        int min = 0;
        int node = 0;
        for(int i = 0; i < edges.length; i++){
            min = sortedEdges[i][0];
            node = sortedEdges[min][0];
            if(isConnected(edges, i , node)){
                MST.add(min);
                MST.add(node);
            }
       }
    }
    public static  boolean isConnected(int[][] edges, int i, int node){
        return edges[i][node] != max;

    }

    public static void main(String[] args) {

        for(int i =0; i < edges.length; i++){
            for(int j = 0; j < edges[0].length; j++){
                sortedEdges[i][j] = edges[i][j];
            }
        }
        for(int[] row: sortedEdges){
            Arrays.sort(row);
        }

        Kruskal();
        System.out.println(MST);
    }
}
