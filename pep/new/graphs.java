import java.util.ArrayList;
import java.util.LinkedList;
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
            isvisited[nodes]=false;
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
        ArrayList<Integer> nodes = new ArrayList<>();
        // ceilpath(graph, "", 0,6, isvisited, 0,39);
        // System.out.println(maxpath + " @ " + maxcosts);
        // System.out.println(minpath + " @ " + mincosts);
        // System.out.println(hamiltonianpath(graph, 0, nodes, isvisited));
        // boolean[] isvisited = new boolean[7];
        System.out.println(bfsbasic(graph, 4,isvisited));
    }
}