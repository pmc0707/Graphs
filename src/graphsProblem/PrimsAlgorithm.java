package graphsProblem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    static class Edge{
        int source;
        int dest;
        int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static void createGraph(ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 10));
        graph[3].add(new Edge(3, 2, 50));
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;

        }
        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }

    }
    public static void prism(ArrayList<Edge> []graph) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            if (!visited[current.v]) {
                visited[current.v] = true;
                finalCost += current.cost;
                for (int i = 0; i < graph[current.v].size(); i++) {
                    Edge edge = graph[current.v].get(i);
                    pq.add(new Pair(edge.dest, edge.weight));
                }
            }
        }
        System.out.println("final (min) cost of MST is ="+ finalCost);
    }
    public static void main(String[] args) {
        int vertexCount = 4;
        ArrayList<Edge> [] graph = new ArrayList[vertexCount];
        createGraph(graph);
        prism(graph);
    }
}
