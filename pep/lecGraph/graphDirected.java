import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
    // khan algo =----------------------------------------------------------
        void khanAlgo(){
            // ArrayList<Integer> incidentEdges = new ArrayList[9];
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                for(Edge ele:graph[i]){
                    arr[ele.v]++;
                }
            }
            Queue<Integer> que = new LinkedList<>();
            for(int i =0;i<arr.length;i++){
                if(arr[i]==0){
                    que.add(i);
                    // addition of those ele which have zero incomming edges
                }
            }
            while(que.size()!=0){
                int rdata = que.peek();
                que.remove();
                ans.add(rdata);
                for(int i =0;i<graph[rdata].size();i++){
                    int rchild = graph[rdata].get(i).v;
                    arr[rchild]--;
                    if(arr[rchild]==0){
                        que.add(rchild);
                    }
                }
            }
        }
        // leetcode 207-----------------------------------------------------

    // topological Sort------------------------------------------------------

     // topological dfs

     public static boolean topologicalDFS_01(int src , ArrayList<Boolean>vis , ArrayList<Boolean> cycle , ArrayList<Integer> st){
         vis.set(src, true);
         cycle.set(src, true);
         boolean res = false;
            for(int i =0;i<graph[src].size();i++){
                int nbr = graph[u].get(i).v;
                if(vis.get(nbr)==false){
                    res = res || topologicalDFS_01(nbr, vis, cycle, st);
                }
                if(cycle.get(nbr)==true)
                    return true;
            }
            st.add(src);
         cycle.set(src, false);
         return res;
     }
     public static void topologicalDFS(){
         ArrayList<Boolean> vis = new ArrayList<>();
         ArrayList<Boolean> cycle = new ArrayList<>();
         ArrayList<Integer> st = new ArrayList<>();
         boolean res = false;
         for(int i =0;i<n && !res ;i++){
             res = res || topologicalDFS_01(i,vis,cycle,st);
         }
         if(res)
         System.out.print("its a cycle");
         else
         System.out.println("its not a cyclr");

     }
    
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