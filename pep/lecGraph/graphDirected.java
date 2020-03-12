import java.util.ArrayList;
public class graphDirected{
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
    
    // topological Sort------------------------------------------------------
    
    public static void topoSort(int src , boolean[] isVis){
        isVis[src]=true;
        for(int i =0;i<graph[src].size();i++){
            int nbr = graph[src].get(i).v;
            if(isVis[nbr]==false)
            topoSort(nbr, isVis);
        }
        System.out.print(src+" ");
    }
    public static void topologicalSort(){
        boolean[] isVis = new boolean[n];
        for(int i=0;i<n;i++){
            if(isVis[i]==false)
            topoSort(i,isVis);
        }
    }
    public static void createGraph(){
        for(int i =0;i<n;i++){
            graph[i] = new ArrayList<Edge>();
        
        }  

      addEdge(0, 1, 10);
      addEdge(0, 3, 10);
      addEdge(1, 2, 10);
      addEdge(2, 3, 40);
      addEdge(3, 4, 2);
      addEdge(4, 5, 2);
      addEdge(4, 6, 8);
      addEdge(5, 6, 3);
  
      addEdge(7, 8, 3);
      addEdge(2, 7, 3);
      addEdge(2, 8, 3);
    }


     public static void main(String[] args){ 
        createGraph();
        topologicalSort();

     }
    
    
    
    }