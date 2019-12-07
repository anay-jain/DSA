import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class graphs{
    
    public static class edge{
            // int v1;
            int v2;
            int weight;
            edge(int v2,int weight){
                this.v2 = v2;
                this.weight=weight;
            }
    }
    public static class mst implements Comparable<mst>{
        int v1;
        int p1;
        int weight;
        mst(int v1 , int p1 , int weight){
            this.v1=v1;
            this.p1=p1;
            this.weight=weight;
        }
            public int compareTo(mst others){
                return this.weight-others.weight;
            }
    }
    public static void printpath(ArrayList<ArrayList<edge>> graph , String ans , int source , int dest, boolean[] isvisited, int costs  ){
        if(source==dest){
           System.out.println(ans+source+ " @ " + costs);
           return ;
        }
         isvisited[source]=true;
       
            for(int j=0;j<graph.get(source).size();j++){
                if(isvisited[graph.get(source).get(j).v2]==false){
                
                    printpath(graph,ans+source,graph.get(source).get(j).v2 , dest, isvisited, costs+graph.get(source).get(j).weight);
                }
               
            
            }
        
        isvisited[source]=false;
        
    }
    public static boolean haspath(ArrayList<ArrayList<edge>> graph , int source , int dest, boolean[] isvisited ){
        if(source==dest){
            return true;
        }
         isvisited[source]=true;
        for(int i=0;i<7;i++){
            for(int j=0;j<graph.get(i).size();j++){
                if(isvisited[graph.get(i).get(j).v2]==true){
                    return true;

                }
                haspath(graph,graph.get(i).get(j).v2 , dest, isvisited);
            
            }
        }
        isvisited[source]=false;
        return false;
    }
    
    public static void display(ArrayList<ArrayList<edge>> graph){
        for(int i =0;i<7;i++){
            System.out.print(i+ "-> ");
            for(int j=0;j<graph.get(i).size();j++){
                edge out = graph.get(i).get(j);
                System.out.print(out.v2 + " " + out.weight+ ", ");
            }
            System.out.println();
        }
    }
    static int maxcosts=Integer.MAX_VALUE ,  mincosts = Integer.MIN_VALUE;
    static String maxpath = "" , minpath = ""; 
    public static void maxminpath(ArrayList<ArrayList<edge>> graph , String ans , int source , int dest, boolean[] isvisited, int costs  ){
        if(source==dest){
        //    System.out.println(ans+source+ " @ " + costs);
           if(maxcosts<costs){
               maxcosts = costs;
               maxpath = ans + source;
           }
           if(mincosts>costs){
               mincosts = costs;
               minpath = ans + source;
           }
           return ;
        }
         isvisited[source]=true;

       
            for(int j=0;j<graph.get(source).size();j++){
                if(isvisited[graph.get(source).get(j).v2]==false){
                
                    maxminpath(graph,ans+source,graph.get(source).get(j).v2 , dest, isvisited, costs+graph.get(source).get(j).weight);
                }
               
            
            }
        
        isvisited[source]=false;
        
    }

    public static void ceilpath(ArrayList<ArrayList<edge>> graph , String ans , int source , int dest, boolean[] isvisited, int costs , int target ){
        if(source==dest){
            

        //    System.out.println(ans+source+ " @ " + costs);
        // if( target<costs){
        //    maxcosts = costs;
        //     if(costs < mincosts){
        //         mincosts = costs;
        //     maxpath = ans+source;
        //     }
        // }
        
        return ;
        }
         isvisited[source]=true;

       
            for(int j=0;j<graph.get(source).size();j++){
                if(isvisited[graph.get(source).get(j).v2]==false){
                
                    maxminpath(graph,ans+source,graph.get(source).get(j).v2 , dest, isvisited, costs+graph.get(source).get(j).weight);
                }
            
            }
        
        isvisited[source]=false;
        
    }
    public static boolean hamiltonianpath(ArrayList<ArrayList<edge>> graph , int source  ,ArrayList<Integer> nodes , boolean[] isvisited){
        if(nodes.size() == graph.size()-1){
            System.out.println(nodes);
            return true;

        }
       
        isvisited[source]=true;

       
        for(int j=0;j<graph.get(source).size();j++){
            // if(isvisited[graph.get(source).get(j).v2]==true){
            //     return true;
            // }
            if(isvisited[graph.get(source).get(j).v2]==false){
                nodes.add(source);
                boolean ans = hamiltonianpath(graph,graph.get(source).get(j).v2 ,nodes, isvisited);
                if(ans){
                    return true;
                }
                nodes.remove(source);
            }
           
        
        }

        
    

    isvisited[source]=false;
        return false;
    }

    public static void addedge(ArrayList<ArrayList<edge>> graph , int v1 , int v2 , int weight ){
        graph.get(v1).add(new edge(v2, weight));
        graph.get(v2).add(new edge(v1, weight));
    }
    public static void klargest(ArrayList<ArrayList<edge>> graph , String ans , int source , int dest, boolean[] isvisited, int costs  ){
        if(source==dest){
        //    System.out.println(ans+source+ " @ " + costs);
           if(maxcosts<costs){
               maxcosts = costs;
               maxpath = ans + source;
           }
           if(mincosts>costs){
               mincosts = costs;
               minpath = ans + source;
           }
           return ;
        }
         isvisited[source]=true;

       
            for(int j=0;j<graph.get(source).size();j++){
                if(isvisited[graph.get(source).get(j).v2]==false){
                
                    maxminpath(graph,ans+source,graph.get(source).get(j).v2 , dest, isvisited, costs+graph.get(source).get(j).weight);
                }
               
            
            }
        
        isvisited[source]=false;
        
    }
    public static boolean bfsbasic(ArrayList<ArrayList<edge>> graphs , int node , boolean[] isvisited){
        Queue<Integer> qu =new LinkedList<>();
        qu.add(0);
          while(qu.size()>0){
            int nodes = qu.remove();
            if(nodes==node){
                return true;
            }
            isvisited[nodes]=true;
            for(int i=0;i<graphs.get(nodes).size();i++){
                
                if(isvisited[graphs.get(nodes).get(i).v2]==true){
                    continue;
                }
                else{
                    qu.add(graphs.get(nodes).get(i).v2);
                    isvisited[graphs.get(nodes).get(i).v2]=true;
                }
            }
        }
        return false;
    }
    public static void prims(ArrayList<ArrayList<edge>> graphs, boolean[] isvisited)
{
    PriorityQueue<mst> pq = new PriorityQueue<>();
    ArrayList<ArrayList<edge>> mst = new ArrayList<ArrayList<edge>>();
    
    for(int i=0;i<graphs.size();i++){
        mst.add(new ArrayList<edge>());
    }
    
    pq.add(new mst( 0,-1 , 0));
    
    while(pq.size()>0){
        mst cp = pq.remove();
        
        if(isvisited[cp.v1]){
            continue;
        }else{
            isvisited[cp.v1]=true;
        }
        if(cp.p1!=-1)
        addedge(mst,cp.v1,cp.p1,cp.weight);


        for(int i =0;i<graphs.get(cp.v1).size();i++){
            if(!isvisited[graphs.get(cp.v1).get(i).v2]){
                mst nc=new mst(graphs.get(cp.v1).get(i).v2, cp.v1,graphs.get(cp.v1).get(i).weight);
                pq.add(nc);   
            }
        }
    }

    System.out.println("--------------------------------------");
    display(mst);


}    
// public static void kruskal(ArrayList<ArrayList<edge>> graphs){
//     ArrayList<ArrayList<edge>> mst = new ArrayList<ArrayList<edge>>();
//     PriorityQueue<mst> pq = new PriorityQueue<>();
//     for(int i =0;i<graphs.size();i++){
//         mst.add(new ArrayList<edge>());
//     }
//     int[] leader = new int[graphs.size()];
//     for(int i=0;i<7;i++){
//         leader[i]=i;
//     }
//     for(int i=0;i<graphs.size();i++){
//         for(int j=0;j<graphs.get(i).size();j++){
//             mst nc = new mst(graphs.get(i).get(j).v2, graphs.get(i).get(j),graphs.get(i).get(j).weight);
//             pq.add(nc);
//         }
//     }
//     while(pq.size()>0){
//         mst cc = pq.remove();
//         int setleader1 = setleader(leader , cc.v1);
//         int setleader2 =setleader(leader ,cc.p1);
//         if(setleader1==setleader2){
//             continue;
//         }
//         else{
//             addedge(mst, cc.v1, cc.p1, cc.weight);
//             mergearray(leader , setleader1 , setleader2);
//         }
        
//     }

// }

public static void belman(ArrayList<ArrayList<edge>> graphs){
    int[] distance = new int[graphs.size()];
    for(int i=0;i<graphs.size();i++){
        distance[i]=Integer.MAX_VALUE;
    }
    distance[0]=0;
   
        for(int j=0;j<graphs.size()-1;j++){
            for(int k =0;k<graphs.get(j).size();k++){
                int s =j;
                int d = graphs.get(j).get(k).v2;
                
                if(distance[s]!=Integer.MAX_VALUE && (distance[s]+ graphs.get(j).get(k).weight < distance[d])){
                    distance[d]=distance[s]+ graphs.get(j).get(k).weight;
                }
            }
       
    }
    for(int t=0;t<distance.length;t++){
        System.out.print(distance[t]+" ");
    }

}
    public static void main(String[] args){
        ArrayList <ArrayList<edge>> graph= new ArrayList<>();
        for(int i=0;i<7;i++){
            graph.add(new ArrayList<>());
        }
        addedge(graph, 0, 1, 10);
        addedge(graph, 0, 3, 40);
        addedge(graph, 1, 2, 10);
        addedge(graph, 2, 3, 10);
        addedge(graph, 3, 4, 2);
        addedge(graph, 4, 5, 3);
        addedge(graph, 4, 6, 8);
        addedge(graph, 5, 6, 3);
        // addedge(graph, 0, 1, 10);
        // display(graph);
        boolean[] isvisited = new boolean[7];
        // System.out.println(printpath(graph, 0, 4, isvisited));
        // printpath(graph, "", 0, 6, isvisited,0);
        // ArrayList<Integer> nodes = new ArrayList<>();
        // ceilpath(graph, "", 0,6, isvisited, 0,39);
        // System.out.println(maxpath + " @ " + maxcosts);
        // System.out.println(minpath + " @ " + mincosts);
        // System.out.println(hamiltonianpath(graph, 0, nodes, isvisited));
        // boolean[] isvisited = new boolean[7];
        // prims(graph,isvisited);
        belman(graph);
    }
}