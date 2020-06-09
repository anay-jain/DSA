    import java.util.ArrayList;
    import java.util.Scanner;

    public class Solution{
        static ArrayList<Integer> par = new ArrayList<>();
        static ArrayList<Integer> size = new ArrayList<>();

        // finds parent
        public static int find(int u){  
            if(par.get(u)==u){
                return u;
            }
            int p = find(par.get(u));
            par.set(u, p); // path compression
            return p;
        }
        // hm dono se parent magva rhe hai
        public static void merge(int p1 , int p2){
            if(size.get(p1)>size.get(p2)){
                par.set(p2, p1); 
                size.set(p1, size.get(p1)+size.get(p2));
            }else{
                par.set(p1, p2); 
                size.set(p2, size.get(p1)+size.get(p2));

            }

        }
        public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int v = scn.nextInt();
            for(int i=0;i<n;i++){
                par.add(i);
                size.add(1);
            }
            for(int i=0;i<v;i++){
                int p1 = scn.nextInt();
                int p2 = scn.nextInt();
                int par1 = find(p1);
                int par2 = find(p2);
                // System.out.println(par1 +" " +par2);
                if(par1!=par2){
                   par.set(p2, par1);
                }
                
            }
            int c = par.get(0);
            for(int i=0;i<n;i++) find(i);

            for(int i=1;i<n;i++){
                if(c!=par.get(i)){
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(c);   
        }
    }