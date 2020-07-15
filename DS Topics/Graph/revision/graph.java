import java.util.*;
public class graph{
  int n =7;
  static ArrayList<Edge>[]  graph = new ArrayList[n];
  public class Edge{
    int v;
    int wt;
    Edge(int v , int wt){
      this.v = v;
      this.wt = wt;
    }
  }
 public static void addEdge(int u , int v ){
    graph[u].add(v);

  }
  public static void main(String[] args){
    for(int i=0;i<n;i++){
      graph[i] = new ArrayList<>();
    }
  }
}