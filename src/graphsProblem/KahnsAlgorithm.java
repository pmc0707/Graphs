package graphsProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {
    static class Edge{
        int source;
        int target;
        public Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }
    }
    static void createGraph(ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void calcInDegree(ArrayList<Edge> [] graph,int []inDegree) {
        for (int i = 0; i < graph.length; i++) {
            int v= i;
            for (int j = 0; j < graph[v].size(); j++) {
                Edge edge = graph[v].get(j);
                inDegree[edge.target]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> []graph) {
        int [] inDegree  = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.remove();
            System.out.print(current+" ");

            for (int i = 0; i < graph[current].size(); i++) {
                Edge edge = graph[current].get(i);
                inDegree[edge.target]--;

            }
        }
    }
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge> [] graph = new ArrayList[vertices];

        createGraph(graph);
        topSort(graph);
    }
}
