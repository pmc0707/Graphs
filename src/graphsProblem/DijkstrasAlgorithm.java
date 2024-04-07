package graphsProblem;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
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
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));


    }
    static class Pair implements Comparable<Pair>{
        int n;
        int path;
        public Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p){
            return this.path - p.path; //path based on sorting for my pairs
        }
    }
    public static void dijkstra(ArrayList<Edge> []graph,int source) {
        int[] dist = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i != source){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.n]){
                visited[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge edge = graph[curr.n].get(i);
                    int u = edge.source;
                    int v = edge.dest;
                    int w = edge.weight;
                    if(dist[u]+w < dist[v]){
                        dist[v] = dist[u] + w;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        for(int i = 0; i < dist.length; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int vertexNum = 7;
        ArrayList<Edge> [] graph = new ArrayList[vertexNum];
        createGraph(graph);

        int source = 0;
        dijkstra(graph,source);
    }
}
