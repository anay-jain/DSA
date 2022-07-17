import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class graph{
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        // populating hashmap.
        for(int i =0;i<routes.length;i++){
            for(int j =0;j<routes[i].length;j++){
                ArrayList<Integer> ar = hm.getOrDefault(routes[i][j], new ArrayList<>());
                ar.add(i);
               
                hm.put(routes[i][j],ar);
       
            }
        }
     
        LinkedList<Integer> que = new LinkedList<>();
        que.add(source);
        int level =0;
        // boolean[] vis = new boolean[routes.length];
        HashSet<Integer> vis =  new HashSet<>();
        HashSet<Integer> busHs = new HashSet<>();
        while(!que.isEmpty()){
            int n = que.size();
            while(n-->0){
                int busStop = que.peek();
                System.out.println(busStop);
                que.removeFirst();
                if(busStop == target) return level;
                ArrayList<Integer> ar = hm.getOrDefault(busStop,new ArrayList<>());
                for(int i =0 ; i< ar.size();i++){
                    if(!vis.contains(ar.get(i))){
                    for(int j =0;j<routes[ar.get(i)].length;j++){
                        if(!busHs.contains(routes[ar.get(i)][j]))
                        {busHs.add(routes[ar.get(i)][j]);
                        que.addLast(routes[ar.get(i)][j]);
                        }
                    }
                    vis.add(ar.get(i)); 
                }
                }       
            }
            level++;
        }
        return -1;
    }
    public int minCostConnectPoints(int[][] points) {
        HashSet<Integer> vis = new HashSet<>();
        PriorityQueue<int[]>
        
    }

    public boolean isBipartite(int[][] graph) {
        LinkedList<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0});

        int n = graph.length;
        while(n-->0){
            
        }
        
    }
    public static void main(String[] args){


    }
}