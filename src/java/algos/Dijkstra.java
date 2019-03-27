package algos;

import java.util.Collections;
import java.util.LinkedList;

/**
 * This is the implementation of famous Dijkstra's algorithm (Shortest path algorithm).
 */
public class Dijkstra {

    public static void main(String[] args) {

        dijkstra(graph(), 0, 3);
        dijkstra(graph(), 3, 0);
        dijkstra(graph(), 0, 1);
        dijkstra(graph(), 0, 5);
        dijkstra(graph(), 0, 4);
        dijkstra(graph(), 3, 4);
    }

    public static void dijkstra(int[][] graph, int source, int end) {
        int dist[] = new int[graph.length];
        int prev[] = new int[graph.length];

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
            q.add(i);
        }
        dist[source] = 0;

        Collections.sort(q, (Integer i, Integer j) -> dist[i] < dist[j] ? -1 : 1);

        while (q.size() > 0) {
            int u = q.poll();
            for (int i = 0; i < graph.length; i++) {
                if (graph[u][i] > 0 && dist[i] > dist[u] + graph[u][i]) {
                    dist[i] = dist[u] + graph[u][i];
                    prev[i] = u;
                }
            }
            Collections.sort(q, (Integer i, Integer j) -> dist[i] < dist[j] ? -1 : 1);
        }

        System.out.println("Shortest Distance " + dist[end]);
        int traverseInd = end;
        System.out.print(end+"<-");
        while (prev[traverseInd] != source) {
            System.out.print(prev[traverseInd]+"<-");
            traverseInd = prev[traverseInd];
        }
        System.out.println(source);
    }

    /**
     *
     * Here is the graph
     *         0
     *    7   * *  2
     *       *   *
     *      1*****2   2->1 3
     *      *   * *   2->3 8
     *   4  *  *  * 1
     *      * *   *
     *      3     4
     *       *   *
     *    5   * *  3
     *         5
     */

    private static int[][] graph(){
        int[][] graph = new int[6][6];
        graph[0][1] = 7;
        graph[1][0] = 7;

        graph[0][2] = 2;
        graph[2][0] = 2;

        graph[1][2] = 3;
        graph[2][1] = 3;

        graph[1][3] = 4;
        graph[3][1] = 4;

        graph[2][3] = 8;
        graph[3][2] = 8;

        graph[4][2] = 1;
        graph[2][4] = 1;

        graph[3][5] = 5;
        graph[5][3] = 5;

        graph[4][5] = 3;
        graph[5][4] = 3;
        return graph;
    }

}
