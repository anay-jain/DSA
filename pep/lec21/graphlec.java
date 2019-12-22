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
    static int  max=0 , min =Integer.MAX_VALUE;
    public static void longestweightpath(int u , int v ,  int cost, boolean[] isvisited){
        if(u==v){
            // cost+=graph[]
            
            max = Math.max(max , cost);
            min = Math.min(min, cost);
            return;
        }
        isvisited[u]=true;
        for(int i =0;i<graph[u].size();i++){
            int nbr = graph[u].get(i).v;
            if(isvisited[nbr]==false){
                longestweightpath(nbr, v, cost+ graph[u].get(i).wt, isvisited);
            }
        }
        isvisited[u]=false;

    }
    public static boolean printpath(int u , int v, String ans, boolean[] isvisited){
        // ans+=u;
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
                System.out.println(ans);
                boolean ans1 = printpath(graph[u].get(j).v,v, ans, isvisited);
                    // if(ans1 == true){
                    //     // return true;
                    // }
                }
            
        }
        isvisited[u]=false;
        return false;
    }
    static int ceildiff =Integer.MAX_VALUE, ceilans=0;
    public static void ceilpath(int s , int v ,int cost, int weight,String ans,boolean[] isvisited){
        if(s==v){  
            if(cost-weight>=0 && ceildiff>(cost-weight)){
                ans+=(s+" ->");
                ceildiff=(cost-weight);
                ceilans=cost;
            }
            
            return ;
        }
        isvisited[s] = true;
        for(int i=0;i<graph[s].size();i++){
            int nbr= graph[s].get(i).v;
            int costnbr = graph[s].get(i).wt; 
            if(isvisited[nbr]==false){
                ceilpath(nbr, v, cost+costnbr,weight,ans, isvisited);
            }
        }
        isvisited[s]=false;
    }
    public static void hamiltonpath(int s , int osrc , int cnt , String ans , boolean[] isvisited){
        // base
        if(cnt==graph.length-1){
            ans=ans+s;
            System.out.println(ans);
            for(int i=0;i<graph[s].size();i++){
                if(  graph[s].get(i).v==osrc){
                    System.out.println("-> Cycle");
                }
            }
            return ;
        }
        isvisited[s]=true;
        for(int i=0;i<graph[s].size();i++){
            int nbr = graph[s].get(i).v;
            if(isvisited[nbr]==false){
                
                hamiltonpath(nbr, osrc, cnt+1, ans+s, isvisited);
            }
        }
        isvisited[s]=false;
    }
    public static void klargest(){
        int k=3;
        
        // ceilans1=1;
        for(int i=0;i<k;i++){
            ceildiff =Integer.MAX_VALUE;
            ceilpath(0, 6, 0, ceilans, "", new boolean[7]);
            System.out.println(ceilans);
        }
        System.out.println(ceilans);
    }
public static void main(String[] args){
    for(int i =0;i<graph.length;i++){
        graph[i]= new ArrayList<edge>();
    }
    
    addedge(0, 1, 10);
    addedge( 0, 3, 10);
    addedge(1, 2, 10);
    addedge( 2, 3, 40);
    addedge( 3, 4, 2);
    // addedge(2, 5, 10);
    addedge( 4, 5, 3);
    addedge(4, 6, 3);
    addedge( 5, 6, 8);
    // static ArrayList<ArrayList
    // int v1 = scn.nextInt();
    // int v2 = scn.nextInt();
    // removeedge(v1, v2);
    // removeedge(v2 , v1);
    // removenode(v1);
    // printpath(0, 6, "", new boolean[7]);
    // display();
    // longestweightpath(0, 6, 0, new boolean[7]);
    // System.out.println(min+ "   and"+ max);
    // ceilpath(0, 6, 0, 68,"", new boolean[7]);
    // System.out.println(ceilans);
    // hamiltonpath(2, 2, 0, "", new boolean[7]);
    klargest();

}    
}