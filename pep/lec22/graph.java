import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
public  class graph{
    public static class edge{
        int v;
        int wt;
        edge(int v , int wt){
            this.v = v;
            this.wt=wt;

        }
        edge(){

        }
    }
    
    static ArrayList<ArrayList<edge>>  graph= new ArrayList<>();
    public static void addedge(int u , int v , int wt){
        if(u<0 || v<0 || u>graph.size() || v>graph.size())
        return;

        graph.get(u).add(new edge(v , wt));
        // graph.get(v).add(new edge(u , wt));

    }   
    public static class bfspair{
        int v;
        int wsf;
        String psf;
        bfspair(int v , int wsf , String psf){
            this.v=v;
            this.wsf=wsf;
            this.psf=psf;
        }
        bfspair(){

        }
    }
    public static void display(){
        for(int i =0;i<graph.size();i++){
            System.out.print(i+" ->");
            for(edge e : graph.get(i)){
                System.out.print(e.v+" @ "+e.wt+" , ");
            }
            System.out.println(" ");
        }
    }
    public static void shortestpath(int root , int dest, boolean[] isvisited){
        // que , 
        LinkedList<bfspair> que = new LinkedList<>();
        bfspair rootnode = new bfspair(0,0,"0");
        que.addLast(rootnode);
        int level=1;
        int countcycle=0;
        while(que.size()!=0){
            int size = que.size();
            boolean iscompleted = false;
            while(size-->0){ // this is done to check level
                bfspair rpair = que.remove(); // remove
                // cycle
                if(isvisited[rpair.v]){
                    System.out.println("cycle at "+rpair.v);
                    countcycle++;
                }
                // mark
                isvisited[rpair.v]=true;
                // is first time the destination is completed
                if(rpair.v == dest && iscompleted==false){
                    System.out.println("Completed fisrt time @ " +rpair.v+" -> "+rpair.psf+level);
                    iscompleted=true;
                }
                // nbr
                for(int i=0;i<graph.get(rpair.v).size();i++){
                    if(isvisited[graph.get(rpair.v).get(i).v]==false){
                        bfspair nbr = new bfspair(graph.get(rpair.v).get(i).v,rpair.wsf+graph.get(rpair.v).get(i).wt, rpair.psf+"->"+ graph.get(rpair.v).get(i).v);
                        que.addLast(nbr);
                    }
                }

            }
            level++;
        }
    }
    public static void topologicalhelper(ArrayList<ArrayList<edge>> graph){
     boolean[] isvisited = new boolean[graph.size()];
     boolean[] cycle  = new boolean[graph.size()];
     ArrayList<Integer> stck = new ArrayList<>();
     for(int i=0;i<graph.size();i++){
         if(isvisited[i]==false){
            if(toplogicalseries(i,isvisited, cycle, stck)== true){
                System.out.println("cycle");
                return ;
            }
         }
     }
     for(Integer e : stck){
         System.out.print(e+"->");
     }

    }
    public static boolean toplogicalseries(int src , boolean[] isvisited,boolean[] cycle,ArrayList<Integer>stck){
        // dfs
        isvisited[src]=true;
        
        boolean res = false;
        cycle[src]=true;
        for(int i=0;i<graph.get(src).size();i++){
            int nbr = graph.get(src).get(i).v;
            if(isvisited[nbr]==false){
                res = res || toplogicalseries(nbr, isvisited,cycle,stck);

            }
            if(cycle[nbr]==true){
                // System.out.println(" it contains cycle");
                return true; // agar upar laagte to ye kabhi access ni hota kyuki false call kabhi agti hi ni
            }
        }
        // System.out.print(src+" ->"); ratther than priniting i am sotring it in stack
        stck.add(src);
        cycle[src]=false;
        return res;
    }
    public static khanalgo
   
    public static void main(String args[]){
        for(int i=0;i<7;i++){
            graph.add(new ArrayList<edge>());
        }

        // addedge(0,3,10);
        // addedge(0,1,10);
        // addedge(1,2,10);
        // addedge(2,3,40);
        // addedge(3,4,2);
        // addedge(4, 3, 8);
        // addedge(4,5,2);
        // addedge(4,6,3);
        // addedge(5,6,8);

    // graph 2 =======================================================    
        addedge(0, 1, 1);
        addedge(0, 5, 1);
        addedge(4, 5, 1);
        addedge(4, 6, 1);
        addedge(1, 2, 2);
        addedge(2, 3, 1);
        addedge(6, 3, 1);
        // addedge(3, 1, 21);

    // graph 3 =========================================================
    // addedge(0, 3, 1);
    // addedge(0, 2, 1);
    // addedge(1, 2, 1);
    // addedge(1, 5, 1);
    // addedge(3, 4, 1);
    // addedge(4, 6, 1);
    // addedge(5, 6, 1);

        
        topologicalhelper(graph);
        // display();
        // shortestpath(0,6, new boolean[7]);
    }

    
}