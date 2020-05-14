import java.util.ArrayList;
public class mazepath{
    public static void main(String[] args){
        ArrayList <String> ans = floodfill(0,0,3,3);
        for(String s: ans){
            System.out.print(s + " ");
        }
        // System.out.println(mazepathhei(0, 0, 2,2));
            

    }

      public static ArrayList <String> mazepath1(int sr,int sc,int er,int ec){

        if(sr==er && sc==ec){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList <String> ans = new ArrayList<>();
        if(sr<er){
        ArrayList <String> horizontal = mazepath1(sr+1, sc, er, ec); // returned ans becomes horizontal 
        for(String s: horizontal){ 
            ans.add("h" + s); // and then we are adding previous ans + h to the current ans 
        }
    }
        if(sc<ec){
        ArrayList <String> vertical = mazepath1(sr,sc+1,er,ec); // returnded ans becomes vertical too
        for(String s: vertical){
            ans.add("v"+s);
        }
    }
        if(sc<ec && sr<er){
            ArrayList <String> diagonal = mazepath1(sr+1,sc+1,er,ec);
            for(String s: diagonal){
                ans.add("d"+s);
            }  
        }
    
        return ans;
      }

 public static ArrayList<String> mazepath_multi(int sr, int sc ,int er ,int ec){
        if(sr==er && sc == ec){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i =1;i+sr<=er;i++){
            // can be written as (int i = sc ; i<ec;i++)
            // call be written as mazepath_2(i,sr,er,ec)
            ArrayList <String> horizontal = mazepath_multi(sr+i,sc,er,ec);
            for(String s : horizontal){
                ans.add("h"+s);
            }
        }
        for(int i =1;i+sc<=ec;i++){
            ArrayList <String> vertical = mazepath_multi(sr, sc+i, ec, er);
            for(String s : vertical){
                ans.add("v" + s);
            }
        }   
        return ans;
    }
    public static int mazepath_simple_height(int sr, int sc , int er , int ec){
        // base
        if(sr==er && sc==ec){
            return 0;
        }
        int maxHei = 0;
        if(sr<er){
            maxHei = Math.max(maxHei , mazepath_simple_height(sr+1, sc, er, ec));
        }
        if(sc<ec){
            maxHei = Math.max(maxHei , mazepath_simple_height(sr, sc+1, er, ec));
        }
        return maxHei + 1;
    }

}