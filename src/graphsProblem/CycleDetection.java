package graphsProblem;

import java.util.ArrayList;
//(UNDIRECTED GRAPH)
public class CycleDetection {
    static class Edge {
        int source;
        int target;

        public Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }
//0(V+E)
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true;
                    //cycle exit in one of the parts
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] visited, int current, int parent) {
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            //case3
            if (!visited[edge.target]) {
                if (detectCycleUtil(graph, visited, edge.target, current)) {
                    return true;
                }
            }
                //case1
                else if (visited[edge.target] && edge.target != parent) {
                    return true;
                }
                //case 2 -> do nothing -> continue
            }

            return false;
        }

        public static void main (String[]args){
        /*
                0--------3
             /  |        |
            /   |        |
           1    |        4
            \   |
             \  |
                2

       */

            int vertex = 5;
            ArrayList<Edge>[] graph = new ArrayList[vertex];
            createGraph(graph);
            System.out.println(detectCycle(graph));
        }
    }
