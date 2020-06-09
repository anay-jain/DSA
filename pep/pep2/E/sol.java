import java.util.ArrayList;
import java.util.LinkedList;
public class Graph{
    static  class Edge{
        int v = 0;
        int wt  = 0;
        Edge(int v , int wt){
            this.v = v;
            this.wt=wt;
        }
    }
    static int n =9;
    static ArrayList<Edge>[] graph= new ArrayList[n];
    
    public static void addEdge(int u , int v , int wt){
        graph[u].add(new Edge(v, wt));
        // graph[v].add(new Edge(u, wt));

    }
    public static boolean bfs(int src){
        int level =1;
        LinkedList<Que
    }
}
