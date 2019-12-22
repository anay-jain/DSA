import java.util.ArrayList;
import java.util.Scanner;
public class graphlec{
    public static Scanner scn = new Scanner(System.in);
    public static class edge{
        int v;
        int wt;
        edge(int v , int wt){
            this.v =v;
            this.wt = wt;
        }
    }
    // static int[] arr =new int[7];
    // ArrayList<edge>;
    static ArrayList<edge>[] graph= new ArrayList[7];
    public static void addedge(int v1 , int v2 , int wt){
        
        graph[v1].add(new edge(v2 , wt));
        graph[v2].add(new edge(v1,wt));
    }
    public static void display(){
        for(int i=0;i<graph.length;i++){
            System.out.print(i+ "=> ");
            for(int j =0;j<graph[i].size();j++){
                System.out.print(graph[i].get(j).v + " @" +graph[i].get(j).wt + " , ");
            }
            System.out.println("");
        }
    }
    public static void removeedge(int v1 , int v2){
        for(int i=0;i<graph[v1].size();i++){
            if(graph[v1].get(i).v==v2){
                graph[v1].remove(i);
            }
        }
    }
    public static void removenode(int v1){
        for(int i =0;i<graph[v1].size();i++){
            removeedge(graph[v1].get(i).v,v1 );
            removeedge(v1, graph[v1].get(i).v);
        }
        graph[v1].clear();;

    }
    public static boolean printpath(int u , int v, String ans, boolean[] isvisited){
        if(u==v){
            ans+=v;
            System.out.println(ans);
            return true ;
        }
        else if(isvisited[u]==false){
            // System.out.print(u+"->");
            ans+=(u+"->");
        }
       
        isvisited[u]=true;
       
            for(int j=0;j<graph[u].size();j++){
                if(isvisited[graph[u].get(j).v]==false){
                    boolean ans1 = printpath(graph[u].get(j).v,v, ans, isvisited);
                    // if(ans1 == true){
                    //     // return true;
                    // }
                }
            
        }
        isvisited[u]=false;
        return false;
    }
public static void main(String[] args){
    for(int i =0;i<graph.length;i++){
        graph[i]= new ArrayList<edge>();
    }
    
    addedge(0, 1, 10);
    addedge( 0, 3, 40);
    addedge(1, 2, 10);
    addedge( 2, 3, 10);
    addedge( 3, 4, 2);
    addedge( 4, 5, 3);
    addedge(4, 6, 8);
    addedge( 5, 6, 3);
    // static ArrayList<ArrayList
    // int v1 = scn.nextInt();
    // int v2 = scn.nextInt();
    // removeedge(v1, v2);
    // removeedge(v2 , v1);
    // removenode(v1);
    printpath(0, 6, "", new boolean[7]);
    // display();
    

}    
}