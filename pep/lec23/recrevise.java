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
    public static boolean issafebits(int r , int c ,int row , int col , int cdiag , int adiag , int colsize){
        int rowmask =0;
        int colmask =0;
        int cdiagmask =0;
        int adiagmask =0;
        rowmask = 1<<c;
        colmask = 1<<r;
        cdiagmask = 1<< (r-c+colsize-1);
        adiagmask =1<<(r+c);

        if((row & rowmask)!=0 ||  (col & colmask)!=0 || (cdiag & cdiagmask)!=0 || (adiag & adiagmask)!=0 ){
            return false;
        }
        return true;
    }
    public static int nqueenbestbits(int rrow , int row , int col , int cdiag , int adiag , int idx ,int tnq,  int colsize, String ans){
    if(tnq==0 || rrow==colsize){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }
        return 0;
    }        
    int rowmask =0;
    int colmask =0;
    int cdiagmask =0;
    int adiagmask =0;
    int count=0;
    for(int c=0;c<colsize;c++){
       
        rowmask = 1<<c; // not needed in optimized version
        colmask = 1<<rrow;
        cdiagmask = 1<< (rrow-c+colsize-1);
        adiagmask =1<<(rrow+c);

        // if(issafebits(rrow, c, row, col, cdiag, adssssssiag, colsize)){ not needed
            if((row & rowmask)==0 &&  (col & colmask)==0 && (cdiag & cdiagmask)==0 && (adiag & adiagmask)==0 ){
                // this if gives us surity that we  can use XOR as there will be 0 at kth pos
                // if it enters into if condition
                // for xor condition we have to know that whehter kth is  set or not

            count+=nqueenbestbits(rrow+1,row, c, cdiag, adiag, idx, tnq, colsize, ans);


        }
         

    }
    return count;
    }
    // SEND MORE MONEY
    static String str1 ="send";
    static String str2 = "more";
    static String str3 = "money";
    static int vis=0;
   static int[] mapping = new int[26];
   public static int getno(String str){
       int res=0;
       for(int i=0;i<str.length();i++){
           res = res*10+mapping[str.charAt(i)-'a'];
        //    System.out.println(res);
       }
       return res;
   }
    public static int cryptopermu(String str, int idx){
        if(idx==str.length()){
            if(getno(str1)+getno(str2)==getno(str3)) return 1;
           return 0;
        }   
        int count=0;
        int ch = (char)(str.charAt(idx)-'a');
        for(int num =9;num>=0;num--){
            int mask = 1<<num;
            if((vis & mask) ==0){
                vis= vis^mask;
                mapping[ch]=num; 
                count+=cryptopermu(str, idx+1);
                vis^=mask;
                mapping[ch]=0;
            }
            
        }
        return count;

    }
    int countnum(int[] arr){
        int count=0;
        for(int i:arr){
            count+=i;
        }
        return count;
    }
    
    public static int placeintwoset(int sumarr1 , int sumarr2, int idx , int[] arr){
        if(idx==arr.length)
        if(sumarr1==sumarr2){
        // if(countnum(arr1)==countnum(arr2)){
            return 1;
        }
        int count=0;
        count+=placeintwoset(sumarr1+arr[idx] , sumarr2 , idx+1 , arr);
        count+=placeintwoset(sumarr1, sumarr2+arr[idx], idx+1, arr);
        return count;
    }

    // public static boolean sudokuissafe(int[][] box, int num , int row , int col){
    //     for(int c=0;c<9;c++){
    //         if(num==box[row][c]) return false;
    //     }
    //     for(int r=0;r<9;r++){
    //         if(num==box[r][col]) return false;
    //     }
    //     int xrow = (row/3)*3;
    //     int 
    // }
    public static void main(String[] args){
        // boolean[][] isvisited = new boolean[5][5];
        // System.out.println(mazepath(0, 0, 4, 4 ,0, isvisited));
        // System.out.println(max);
            // System.out.println(subseq("abc"));
            // int coins[]= {2,3,5,7};
            //     coins_target(coins, 0, 0, 10, "");
            // System.out.println(coin_Change_uniqPer(10, coins, "", new boolean[coins.length]));
            // boolean[][] box = new boolean[4][4];
            // System.out.println(nqueenpermu(box, 0, 4, new boolean[box.length],  ""));
            // System.out.println(nqueencombieff(box, 0, 4, new boolean[box.length], ""));
            // queencombi2d(0, 3, 0,3, "");
        String str = str1+str2+str3;
        int[] freqmap = new int[26];
        for(int i=0;i<str.length();i++){
            freqmap[str.charAt(i)-'a']++;
        }
        String ans="";
        for(int i=0;i<26;i++){
            if(freqmap[i]!=0){
                
                ans=ans+ (char)(i+'a');
            }
        }
        System.out.println(ans);
        System.out.println(cryptopermu(ans, 0));
    }
}