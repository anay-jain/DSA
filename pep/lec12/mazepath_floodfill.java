import java.util.Scanner;
import java.util.ArrayList;

public class mazepath_floodfill{
    public static void main(String args[]){
        System.out.println(floodfill(0, 0, 2,2, new boolean[3][3]));
        
    }
    public static ArrayList<String> floodfill(int sr , int sc , int er , int ec , boolean isdone[][]){
        if(sr==er && sc==ec){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList <String> myans = new ArrayList<>();
        if(sc-1>=0 && isdone[sr][sc-1] == false ){
            isdone[sr][sc-1]= true;
            ArrayList <String> upward = floodfill(sr,sc-1,er,ec,isdone);
            for( String s: upward){
                myans.add("U" + s);
            }
        } // upward condition , we are moving in clock wise direction
        if(sr+1<=ec &&  isdone[sr+1][sc]==false){
            isdone[sr+1][sc] = true;
            ArrayList <String> right = floodfill(sr+1,sc,er,ec,isdone);
            for(String s : right){
                myans.add("R" + s);
            }
        }
        if(sc+1<=ec && isdone[sr][sc+1] == false ){
            isdone[sr][sc+1]=true;
            ArrayList <String> down = floodfill(sr,sc+1,er,ec,isdone);
            for(String s: down){
                myans.add("D" + s);
            }
        }
        if(sr-1>=0&& isdone[sr-1][sc]==false){
            isdone[sr-1][sc] = true;
            ArrayList <String> left = floodfill(sr-1,sc,er,ec,isdone);
            for(String s: left){
                myans.add("L" + s);
            }
        }
        isdone[sr][sc] = false;
        return myans;
    }
}