import java.util.Scanner;
import java.util.ArrayList;

public class mazepath_floodfill{
    public static void main(String[] args){
        System.out.println(floodfill_1(0, 0, 2,2, new boolean[3][3]));
        
    }
    public static ArrayList <String> floodfill_1(int sr , int sc , int er , int ec,boolean [][] isdone){
            if(sr==er && sc==ec){
                ArrayList <String> base = new ArrayList<>();
                base.add("");
                return base;
            }
            ArrayList <String> ans = new ArrayList<>();
            isdone[sr][sc]=true;
            if(sr+1<=er && !isdone[sr+1][sc]){
                ArrayList <String> right =floodfill_1(sr+1, sc, er, ec, isdone);
                for(String s: right){
                    ans.add("r" + s);
                }
            }
            if(sc+1<=ec && !isdone[sr][sc+1]){
                ArrayList <String> down = floodfill_1(sr, sc+1, er, ec, isdone);
                for(String s: down){
                    ans.add("d"+s);
                }
            }
            if(sr-1>=0 && !isdone[sr-1][sc]){
                ArrayList <String> left = floodfill_1(sr-1, sc, er, ec, isdone);
                for(String s: left){
                    ans.add("l" + s);
                }
            }
            if(sc-1>=0 && !isdone[sr][sc-1]){
                ArrayList <String> up = floodfill_1(sr, sc-1, er, ec, isdone);
                for(String s : up){
                    ans.add("u"+s);
                }
            }
            isdone[sr][sc]=false;   
            return ans;
        }
        public static boolean isValid(int x, int y , int er , int ec, boolean[][] isdone){
            if(x>=0 && y>=0 && x<=er && y<=ec && !isdone[x][y]){
                return true;
            }
            return false;
        }
        public static ArrayList <String> floodfill_generic(int sr , int sc , int er , int ec, boolean[][] isdone ){
            // base case
            if(sr==er && sc==ec){
                ArrayList <String> base = new ArrayList<>();
                base.add("");
                return base;
            }
            isdone[sr][sc] =true;
            int[][] dir = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
            String[] dirName= {"U","1","R","2","D","3","L","4"};
            ArrayList <String> ans = new ArrayList<>();
            for(int i=0;i<dir.length;i++){
                int x = sr + dir[i][0];
                int y = sc+ dir[i][1];
                if(isValid(x,y,er,ec,isdone)){
                    ArrayList<String> ref = floodfill_generic(x, y, er, ec, isdone);
                    for(String s: ref){
                        ans.add(dirName[i]+s);
                    }
                }
            }
            isdone[sr][sc]= false ; // this is backtracking   you revert all the changes you donern 
            return ans;
        }
}