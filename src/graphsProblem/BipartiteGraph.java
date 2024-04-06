package graphsProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int source;
        int destination;
        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    static void createGraph(ArrayList<Edge> []graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] color = new int [graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1; //no color
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // BFS
                queue.add(i);
                color[i] =0;
                while (!queue.isEmpty()) {
                    int current = queue.remove();
                    for (int j = 0; j < graph[current].size(); j++) {
                        Edge edge = graph[current].get(j); //edge.destination
                        if (color[edge.destination] == -1) {
                            int nextColor = color[current] == 0 ? 1 :0;
                            color[edge.destination] = nextColor;
                            queue.add(edge.destination);
                        } else if (color[edge.destination] == color[current]) {
                            return false; //   NOT BIPARTITE
                        }
                    }
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        /*
                    0---------2
                   /         /
                  /         /
                 1         4
                  \       /
                   \     /
                     \  /
                       3


        */
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
