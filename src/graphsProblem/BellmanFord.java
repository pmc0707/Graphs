package graphsProblem;

import java.util.ArrayList;

public class BellmanFord {
    static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;

        }
    }
    static void createGraph(ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }
    public static void bellmanFord(ArrayList<Edge> [] graph ,int src) {
        int[] dist = new int[graph.length];
        for (int i=0; i < dist.length; i++) {
            if(i!=src){
            dist[i] = Integer.MAX_VALUE;
            }
        }
        int vertices = graph.length;
        for (int i = 0; i < vertices-1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge edge = graph[j].get(k);
                    int u = edge.source;
                    int v = edge.destination;
                    int weight = edge.weight;

                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;

                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge> [] graph = new ArrayList[vertex];
        createGraph(graph);
        bellmanFord(graph, 0);
    }
}
