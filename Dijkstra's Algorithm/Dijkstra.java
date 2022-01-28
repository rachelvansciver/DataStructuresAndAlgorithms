import java.util.*;

public class Dijkstra {
    public static void main(String args[]) {
        int[][] adjacencyCostMatrix = {
                {Integer.MAX_VALUE, 14, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 7, 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5, 5},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3, Integer.MAX_VALUE, 2},
                {Integer.MAX_VALUE, 2, 4, Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
        };
        int N = 6; // N is the number of nodes/vertices

        // display the graph
        System.out.println("The graph has " + N +
                " nodes and the following arcs:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                if (adjacencyCostMatrix[i][j] < Integer.MAX_VALUE)
                    System.out.print("  arc from " + i + " to " + j
                            + " of cost " + adjacencyCostMatrix[i][j]);
            System.out.println();
        }// end of the for statement
        int D[] = new int[N];
        // D[v] = k iff the distance from source 1 until v is k

        int previous[] = new int[N];
        // previous[v] = w iff the arc (w, v) is the last arc
        //                     in the minimum path
        previous[0] = 0;

        boolean visited[] = new boolean[N];
        // visited[w] = true iff node w has been visited
        for (int i = 0; i < N; i++) visited[i] = false;
        visited[0] = true;
        // we start from the source node, that is, 0
        for (int i = 1; i < N; i++) {
            D[i] = adjacencyCostMatrix[0][i];
            previous[i] = 0;
        }
        for (int i = 1; i < N; i++) {
            // choose a vertex w from V-S such that D[w] is
            // a minimum arc;
            int minimum = Integer.MAX_VALUE;
            int minimum_Index = i;
            for (int j = 1; j < N; j++) {
                if (!visited[j] && (D[j] < minimum)) {
                    minimum = D[j];
                    minimum_Index = j;
                } // end of the if statement
            } // end of the for statement
            // S = S + {w};
            visited[minimum_Index] = true;
            // for each vertex v from V-S
            //   D[v] = min(D[v], D[w] + C[w, v]);
            for (int j = 1; j < N; j++) {
                if (!visited[j])
                    if ((D[j] > D[minimum_Index] +
                            adjacencyCostMatrix[minimum_Index][j]) &&
                            (D[minimum_Index] +
                                    adjacencyCostMatrix[minimum_Index][j] > 0)) {
                        D[j] = D[minimum_Index] +
                                adjacencyCostMatrix[minimum_Index][j];
                        previous[j] = minimum_Index;


                    }
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println("The minimum cost of the path " +
                    " from 0 until " + i + " is " + D[i]);
            System.out.println("The path corresponding to the" +
                    " minimum cost is, in reverse order:");
            int j = i;
            while (j != 0) {
                System.out.print(j + " <-- ");
                j = previous[j];
            }
            System.out.println(0);
        } // end of the for statement
    } // end of the public static void main() method
} // end of Dijkstra class
