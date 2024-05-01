package types.adjacencyList;

import java.util.ArrayList;

public class AdjacencyList {
    static class Edge{
        int src;
        int destination;
        int weight;

        public Edge(int src,int destination,int weight) {
            this.src = src;
            this.destination= destination;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {

        /*    (5)
          0--------1
                  / \
          (1)    /   \  (3)
                /     \
               2-------3
               |  (1)
            (2)|
               |
               4
          */
        int vertex = 5;
        ArrayList<Edge> [] graph = new ArrayList[vertex];
        for (int index = 0; index < vertex; index++) {
            graph[index] = new ArrayList<>();
        }

        //for vertex 0
        graph[0].add(new Edge(0,1,1));
        //1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        //vertex 2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,4));
        //vertex3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        //vertex4
        graph[4].add(new Edge(4,2,2));

        //2's neighbors
        for (int index = 0; index < graph[2].size(); index++) {
            Edge edge = graph[2].get(index);
            System.out.println(edge.destination);
        }
    }
}

