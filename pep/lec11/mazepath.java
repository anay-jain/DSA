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


      public static int mazepathhei(int sr,int sc,int er,int ec){
          int maxhei = 0;

        if(sr==er && sc==ec){
            return 0;
        }

        if(sr<er){
        maxhei =  Math.max(maxhei,mazepathhei(sr+1, sc, er, ec));
       
    }
        if(sc<ec){
        maxhei = Math.max(maxhei , mazepathhei(sr,sc+1,er,ec));
      
    }
        if(sc<ec && sr<er){
        maxhei = Math.max(maxhei , mazepathhei(sr+1,sc+1,er,ec));
        
        }
    
        return maxhei+1;
      }

      public static ArrayList <String> mazepathmulti(int sr,int sc,int er,int ec){

        if(sr==er && sc==ec){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList <String> ans = new ArrayList<>();
        for(int i=1;sr+i<=er;i++){
        ArrayList <String> horizontal = mazepathmulti(sr+1, sc, er, ec);
        for(String s: horizontal){
            ans.add("h"+ i + s);
        }
    }
        for(int i=1;sc+i<=ec;i++){
        ArrayList <String> vertical = mazepathmulti(sr,sc+1,er,ec);
        for(String s: vertical){
            ans.add("v" + i+s);
        }
    }
        for(int i=1;i+sc<= ec && i+sr<=er ;i++){
            ArrayList <String> diagonal = mazepathmulti(sr+1,sc+1,er,ec);
            for(String s: diagonal){
                ans.add("d"+i+s);
            }  
        }
    
        return ans;
      }
     

}