package graphsProblem;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;

        }
        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));

    }
    static int n =4;
    static int parent[] = new int[n];
    static int [] rank = new int[n];

    public static void init(){
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(rank[parentX] == rank[parentY]){
            parent[parentX] = parentY;
            rank[parentX]++;

        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;

        } else {
            parent[parentY] = parentX;
        }
    }
    public static void kruskalsMST(ArrayList<Edge> edges,int V){
        init();
        Collections.sort(edges); //time complexity :0(ElogE)
        int mstcost = 0;
        int count = 0;

        for (int i = 0; count<V-1; i++) { //0(v)
            Edge e1 = edges.get(i);

            int parentX = find(e1.src);
            int parentY = find(e1.dest);
            if(parentX!=parentY) {
                union(e1.src,e1.dest);
                mstcost += e1.weight;
                count++;
            }
        }
        System.out.println(mstcost);
    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges,vertex);
    }
}
