import java.util.ArrayList;
public class mazepath{
    public static void main(String[] args){
        ArrayList <String> ans = mazepath1(0,0,2,2);
        for(String s: ans){
            System.out.print(s + " ");
        }
        
    }

      public static ArrayList <String> mazepath1(int sr,int sc,int er,int ec){

        if(sr==er && sc==ec){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList <String> ans = new ArrayList<>();
        if(sr<er){
        ArrayList <String> horizontal = mazepath1(sr+1, sc, er, ec);
        for(String s: horizontal){
            ans.add("h" + s);
        }
    }
        if(sc<ec){
        ArrayList <String> vertical = mazepath1(sr,sc+1,er,ec);
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

    

}