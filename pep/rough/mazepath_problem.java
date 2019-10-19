import java.util.ArrayList;
public class mazepath_problem{

    public static void main(String[] args){
        System.out.println(floodfill_generic(0, 0,2, 2, new boolean [3][3]));

    }
    public static ArrayList <String> mazepath_simple(int sr , int sc, int ec, int er ){
        // base case
        if(sr==er && sc == er){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ArrayList <String> ans = new ArrayList<>();
        if(sr<er){
            // all horizontal cases
            ArrayList <String> horizontal =mazepath_simple(sr+1, sc, ec, er);
            for(String s : horizontal){
                ans.add("h" + s);
            }
        }
        if(sc<ec){
            ArrayList <String> vertical = mazepath_simple(sr, sc+1, ec, er);
            for(String s : vertical){
                ans.add("v"+ s);
            }
        }
        if(sr<ec && sc<ec){
            ArrayList <String> diagonal = mazepath_simple(sr+1, sc+1, ec, er);
            for(String s : diagonal){
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

        public static int mazepath_multi_height(int sr,int sc , int er , int ec){
            // base 
            if(sr==er && sc==ec){
                return 0;
            }
            int maxHei=0;
            for(int i=1;sc+i<=ec;i++){
                maxHei = Math.max(maxHei, mazepath_multi_height(sr, sc+i, er, ec));
            }
            for(int i = 1;sr+i<=er;i++){
                maxHei = Math.max(maxHei , mazepath_multi_height(sr+i,sc ,er, ec));
            }
            return maxHei + 1;
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