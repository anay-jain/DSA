import java.util.ArrayList;

public class unionType{
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

    }
}