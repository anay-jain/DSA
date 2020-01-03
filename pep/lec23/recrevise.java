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
    // public static ArrayList<String> mazepath(int sr , int sc , int er , int ec,int count, boolean[][] isvisited){
    //     if(sr==er && sr == ec){
    //         ArrayList<String> base = new ArrayList<>();
    //         max = Math.max(max,count);
    //         base.add("");
    //         return base;
    //     }
    //     isvisited[sr][sc]=true;
    //     ArrayList<String> myresult = new ArrayList<>();
    //     for(int i=0;i<cord.length;i++){
    //         int x = sr + cord[i][0];
    //         int y = sc+ cord[i][1];
            
    //         if(x>=0 && y>=0 && x<=er && y<=ec && isvisited[x][y]==false){
    //             ArrayList<String>  recans = mazepath(x, y, er, ec,count+1, isvisited);
    //             for(String s: recans){
    //                 myresult.add(dir[i]+s);
    //             }
    //         }
    //     }
    //     isvisited[sr][sc]=false;
    //     return myresult;
    // }
    static int[][] cord = {{0,1},{1,0},{-1,0},{0,-1}};
    static int coin_Change_uniqPer(int target, int[] coins ,String ans , boolean[] vis){
        if(target==0){
            System.out.println(ans);
            return 1;
            // ArrayList<String> base = new ArrayList<>();
            // // base.add("");
            // // return base;
        }
        if(target<0){
            return 0;
        }
        int count=0;
        for(int i =0;i<coins.length;i++){
            vis[i]=true;
            count+=coin_Change_uniqPer(target-coins[i], coins, ans+" "+coins[i],vis);
            vis[i]=false;
            }
            return count;
    }
    public static int coins_target(int[] coins , int idx , int currentarget , int target , String ans){
        if(idx==coins.length && currentarget==target){
            System.out.println(ans);
            return 1;
        }
        if(coins.length<=idx ){
            return 0;
        }
        if(target<currentarget){
            return 0;
        }
        int count=0;

        count+=coins_target(coins, idx, currentarget+coins[idx], target, ans+""+coins[idx]);
        count+=coins_target(coins, idx+1, currentarget, target, ans);

        return count;

    }
    // lqpl -> last queen placed location
    public static int queencombi2d(int lqpl, int tnq , int qpsf , int er, String ans ){
        if(qpsf == tnq || lqpl == (er*er)){
            if(qpsf==tnq){
                System.out.println(ans);
                return 1;
            }
            return 0;
           
        }        
        int count=0;
        int x = lqpl /er;
        int y = lqpl %er;
        count+=queencombi2d(lqpl+1, tnq, qpsf+1, er, ans+"b("+x+","+y+")");
        count+=queencombi2d(lqpl+1, tnq, qpsf, er, ans);
        return count;
    }
    public static int queenpermu2d(int lqpl, int tnq , int qpsf , int er, boolean[] vis , String ans ){
        if(qpsf == tnq || lqpl == (er*er)){
            if(qpsf==tnq){
                System.out.println(ans);
                return 1;
            }
            return 0;
           
        }
        int count=0;
        int x = lqpl /er;
        int y = lqpl %er;
        count+=queencombi2d(lqpl+1, tnq, qpsf+1, er, ans+"b("+x+","+y+") ");
        count+=queencombi2d(lqpl+1, tnq, qpsf, er, ans);
        return count;
    }
    static int[][] dir = {{-1,0},{-1,-1},{0,-1},{-1,1},{1,0},{1,1},{0,1},{1,-1}};
    public static boolean issafe(boolean[][] box , int X , int Y){
        for(int d=0;d<dir.length;d++){
            for(int rad=1;rad<=Math.max(box.length,box[0].length);rad++){
                int x = X+ rad*dir[d][0];
                int y = Y + rad*dir[d][1];
                if(x>=0 && y>=0 && x<box.length && y <box[0].length){
                    if(box[x][y]==true) return false;
                }
                else{
                    break;
                    
                }

            }
        }
        
        return true;
    }
    public static int nqueencombi(boolean[][] box , int idx, int qnf , boolean[] vis,String ans){
        if(qnf==0 || idx==(box.length*box[0].length)-1){
            if(qnf==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        for(int i=idx;i<box.length*box[0].length;i++){
            int x = i/box.length;
            int y = i%box[0].length;
            if(issafe(box, x, y)){
                box[x][y]=true;
                // System.out.println("fe");
                count+=nqueencombi(box, i+1, qnf-1, vis, ans+"b("+x+","+y+") ");
                box[x][y]=false;
            }
        }
        return count;
    }
    public static int nqueenpermu(boolean[][] box , int idx, int qnf , boolean[] vis,String ans){
        if(qnf==0 || idx==(box.length*box[0].length)-1){
            if(qnf==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        for(int i=0;i<box.length*box[0].length;i++){
            int x = i/box.length;
            int y = i%box[0].length;
            if(!box[x][y] && issafe(box, x, y)){
                box[x][y]=true;
                // System.out.println("fe");
                count+=nqueenpermu(box, 0, qnf-1, vis, ans+"b("+x+","+y+") ");
                box[x][y]=false;
            }
        }
        return count;
    }

     public static int nqueencombieff(boolean[][] box , int row, int qnf , boolean[] vis,String ans){
        if(qnf==0 || row==box.length){
            if(qnf==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        for(int col =0;col<box[0].length;col++){
            
            if(issafe(box, row, col)){
                box[row][col]=true;
                // System.out.println("fe");
                count+=nqueencombieff(box, row+1, qnf-1, vis, ans+"b("+row+","+col+") ");
                box[row][col]=false;
            }
        }
        return count;
    }
    public static int nqueenbest()
    public static void main(String[] args){
        // boolean[][] isvisited = new boolean[5][5];
        // System.out.println(mazepath(0, 0, 4, 4 ,0, isvisited));
        // System.out.println(max);
            // System.out.println(subseq("abc"));
            // int coins[]= {2,3,5,7};
            //     coins_target(coins, 0, 0, 10, "");
            // System.out.println(coin_Change_uniqPer(10, coins, "", new boolean[coins.length]));
            boolean[][] box = new boolean[4][4];
            // System.out.println(nqueenpermu(box, 0, 4, new boolean[box.length],  ""));
            System.out.println(nqueencombieff(box, 0, 4, new boolean[box.length], ""));
            // queencombi2d(0, 3, 0,3, "");
            
    
        }
}