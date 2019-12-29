import java.util.ArrayList;
public class recrevise{
    public static ArrayList<String> subseq(String s){
        if(s.length()==0){
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;

        }
        char ch = s.charAt(0);
        ArrayList<String> finalans = new ArrayList<>();
        ArrayList<String> ans = subseq(s.substring(1));
        for(String str : ans ){
            finalans.add(ch+str);
        }
            finalans.addAll(ans);
        return finalans;
    }
  static int max=0;
    public static ArrayList<String> mazepath(int sr , int sc , int er , int ec,int count, boolean[][] isvisited){
        if(sr==er && sr == ec){
            ArrayList<String> base = new ArrayList<>();
            max = Math.max(max,count);
            base.add("");
            return base;
        }
        isvisited[sr][sc]=true;
        ArrayList<String> myresult = new ArrayList<>();
        for(int i=0;i<cord.length;i++){
            int x = sr + cord[i][0];
            int y = sc+ cord[i][1];
            
            if(x>=0 && y>=0 && x<=er && y<=ec && isvisited[x][y]==false){
                ArrayList<String>  recans = mazepath(x, y, er, ec,count+1, isvisited);
                for(String s: recans){
                    myresult.add(dir[i]+s);
                }
            }
        }
        isvisited[sr][sc]=false;
        return myresult;
    }
    static int[][] cord = {{0,1},{1,0},{-1,0},{0,-1}};
    static String[] dir = {"R","D","U","L"};
    
    public static void main(String[] args){
        boolean[][] isvisited = new boolean[5][5];
        System.out.println(mazepath(0, 0, 4, 4 ,0, isvisited));
        System.out.println(max);
            // System.out.println(subseq("abc"));
    }
}