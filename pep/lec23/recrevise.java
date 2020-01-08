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
    // trow -> total row
    // aur jinka hme track kar rkhana hai vo hm attribute mei lenge
    // jese row , col , cdiag , adiag
    static int rowarr=0;
    static int colarr=0;
    static int cdiagarr =0;
    static int adiagarr=0;
// combi method , no need of vis
    public static int nqueenbits(int row , int trow ,int tcol, int tnq , String ans){
        if(row==trow){
            if(tnq==0){
                System.out.println(ans);
                return 1;
            }
            return 0;

        }
        int count=0;
        // har row ke lie 4 col ki calls niklegi
        for(int c=0;c<tcol;c++){
            int rowmask = 1<<row;
            int colmask = 1<<c;
            int cdiagmask =1<<(row+c-1);
            int adiadmask = 1<<(tcol-1 + row-c);
            if((rowarr & rowmask)==0 && (colarr & colmask)==0 && (cdiagarr & cdiagmask)==0 && (adiagarr & adiadmask) ==0){ 
                rowarr ^= rowmask;
                colarr ^= colmask;
                cdiagarr ^= cdiagmask;
                adiagarr ^= adiadmask;
                count+=nqueenbits(row+1, trow, tcol, tnq-1, ans+"Row"+row+"Col"+c+"Q"+tnq);
                rowarr ^= rowmask;
                colarr ^= colmask;
                cdiagarr ^= cdiagmask;
                adiagarr ^= adiadmask;
        
        }
    
    }
        return count;
    }
    // public static int nqueenbestbits(int rrow , int row , int col , int cdiag , int adiag , int idx ,int tnq,  int colsize, String ans){
    // if(tnq==0 || rrow==colsize){
    //     if(tnq==0){
    //         System.out.println(ans);
    //         return 1;
    //     }
    //     return 0;
    // }        
    // int rowmask =0;
    // int colmask =0;
    // int cdiagmask =0;
    // int adiagmask =0;
    // int count=0;
    // for(int c=0;c<colsize;c++){
       
    //     rowmask = 1<<c; // not needed in optimized version
    //     colmask = 1<<rrow;
    //     cdiagmask = 1<< (rrow-c+colsize-1);
    //     adiagmask =1<<(rrow+c);

    //     // if(issafebits(rrow, c, row, col, cdiag, adssssssiag, colsize)){ not needed
    //         if((row & rowmask)==0 &&  (col & colmask)==0 && (cdiag & cdiagmask)==0 && (adiag & adiagmask)==0 ){
    //             // this if gives us surity that we  can use XOR as there will be 0 at kth pos
    //             // if it enters into if condition
    //             // for xor condition we have to know that whehter kth is  set or not

    //         count+=nqueenbestbits(rrow+1,row, c, cdiag, adiag, idx, tnq, colsize, ans);


    //     }
         

    // }
    // return count;
    // }
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
    public static int permutation(String ques , String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        
        for(int i=0;i<ques.length();i++){
            String nstr = ques.substring(0, i)+ques.substring(i+1);
            count+=permutation(nstr,ans+ques.charAt(i));
        }
    
    return count;
    }
    // if vis in attribute then -> 1 rec call par frq pdta hai
    // if vis in preorder ek level par frq padta hai
    public static int permutationwithoutrep(String ques , String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        
        int seen =0;
        
        for(int i=0;i<ques.length();i++){
            String nstr = ques.substring(0, i)+ques.substring(i+1);
            int k = ques.charAt(i) -'a';
            int mask=1<<k;
            if((seen & mask) ==0){
                seen|=mask;
            count+=permutationwithoutrep(nstr,ans+ques.charAt(i));
            }
            
        }
    
    return count;
    
    
    }
    static int[] arr  = {10,20,30,40,50,60,70,80};
    public static int equiset(int idx , int sum1 , int sum2 , String set1 , String set2){
        if(idx == arr.length ){ 
            if(sum1==sum2){
            System.out.println(set1+" = "+set2);
            return 1;
            }
            return 0;
        }
        int count=0;
        count+=equiset(idx+1, sum1+arr[idx], sum2, set1+ " "+arr[idx], set2);
        count+=equiset(idx+1, sum1, sum2+arr[idx], set1, set2+" "+arr[idx]);

        return count;
    }
    
    public static int sudoku(){

    }

 public static void crypto(){
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
        // crypto();
        // System.out.println(permutation("abc", ""));
        // System.out.println(permutationwithoutrep("aba", ""));
        // System.out.println(equiset(0, 0, 0, "", ""));
        System.out.println(   nqueenbits(0, 4, 4, 4, ""));
     
    }
}