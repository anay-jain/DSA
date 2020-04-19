import java.util.*;
public class DPquestions{
    public int lengthOfLIS(int[] nums) {
        int  n = nums.length;
        if(n==0)return 0;
        int max=1;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i]=1;
        for(int i=1;i<n;i++){
            for(int j =i-1;j>=0;j--){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max , dp[i]);
            
            }
            
        }
        return max;
    }
    public static class pair {
        int w ;
        int h ;
        pair(int w , int h ){
            this.w=w;
            this.h=h;
            
        }
    }
    // optimal strategy for a game DP 31----------------------------------------------------
    public static int optimalStrategy(int n , int[] arr){
        int[][] dp = new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap==0){
                    dp[i][j]=arr[i];
                }
                else if(gap==1){
                    dp[i][j] =Math.max(dp[i][j-1],arr[j]);
                }
                else{
                    // this means p1 ne ith choose kia to p2 min banayega jo bhi p2 ke pas optn honge
                    int a = arr[i] + Math.min(dp[i+1][j-1],dp[i+2][j]);
                    int b = arr[j] + Math.min(dp[i+1][j-1],dp[i][j-2]);
                    dp[i][j]=Math.max(a,b);
                }
            }
        }
        return dp[0][n-1];
    }
    // leetcode 464----------------------------------------------------------------------------------
  
    public boolean canIWin(int m, int total) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        // it tells whether we have used the state or not
        int currstate=0;
        for(int i=1;i<=m;i++){
            int mask = 1<<i;
            if(currstate & mask){
                currstate^=mask;
                res = res || canIWin_(currstate , m, total-i);    

            }
        }
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k = primes.length;
        pq.add(1);
        for(int i=0;i<k;i++){
            pq.add(primes[i]);
        }
        for(int i=1;i<n;i++){
            int min = pq.poll();
            System.out.print(min+" ");
            while(pq.size()>0 && min==pq.peek()){
                pq.remove();
            }
            for(int j=0;j<k;j++){
                pq.add(min*primes[j]);
            }
            
        }
        return pq.peek();
    }

    // best time to buy and sell stock IV --------------------------------------------
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
       if(k>prices.length){
           int profit=0;
           for(int i=0;i<prices.length-1;i++){
               if(prices[i]<prices[i+1]) profit+=(prices[i+1]-prices[i]);
           }
           return profit;
       }
        int[][] dp = new int[2][prices.length];
        for(int i=1;i<k+1;i++){
             int maxsofar=-prices[0];
            for(int j=1;j<prices.length;j++){
                int notrans = dp[1][j-1];
maxsofar= Math.max(maxsofar,dp[0][j-1]-prices[j-1]);
                dp[1][j]=Math.max(prices[j]+maxsofar,notrans);
//                 for(int t=j;t>0;t--){
// trans =  Math.max(prices[j]-prices[j-t]+dp[0][j-t],trans);
//                 }
                
            }
            for(int z=0;z<prices.length;z++){
                // System.out.print(dp[0][z]+" ");
            dp[0][z]=dp[1][z];
            }
        }
        // for(int i=0;i<dp.length;i++)
        // {
        //     for(int j=0;j<dp[0].length;j++)
        //         System.out.print(dp[i][j]+" ");
        //     System.out.println();
        //     }
        return dp[1][prices.length-1];
    }
    // best time to buy and sell stock III

        public int maxProfit(int[] prices) {
          if(prices.length==0){
              return 0;      }
            int maxsofar=prices[prices.length-1];
            int minsofar=prices[0];
            int[] dp = new int[prices.length];
            int[] dp1 = new int[prices.length];
            for(int i=1;i<prices.length;i++){
                if(prices[i]>minsofar)
            dp[i]=prices[i]-minsofar;
                else minsofar=prices[i];
                dp[i]=Math.max(dp[i-1],(prices[i]-minsofar));
            }
            for(int k:dp) System.out.print(k+" ");
         int totalmax=dp[dp.length-1];
            for(int i=prices.length-2;i>=0;i--){
                if(prices[i]<maxsofar)
                {
                    dp1[i]=maxsofar-prices[i];
    totalmax = Math.max(totalmax, dp1[i] + dp[i]);
                }
                else maxsofar=prices[i];
                 dp1[i]=Math.max((maxsofar-prices[i]),dp1[i+1]);
           
            }
            return totalmax;
        }
        //regular expression matching

        public boolean isMatch(String s, String p) {
            int n = s.length();
            int k = p.length();
            boolean[][] dp = new boolean[k+1][n+1];
            dp[0][0]=true;  
            for(int i =1;i<=k;i++){
                dp[i][0] = p.charAt(i-1)=='*'?dp[i-2][0]:false;
            }
            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    if(p.charAt(i-1)==s.charAt(j-1)){
                        if(dp[i-1][j-1])dp[i][j]=true;
                    }
                    else if(p.charAt(i-1)=='.'){
                          if(dp[i-1][j-1])dp[i][j]=true;
                    }
                    else if(p.charAt(i-1)=='*'){
                        // if(p.charAt(i-1)=='.')dp[i][j]=dp[i-1][j-1];
                        if(dp[i-1][j] || dp[i-2][j])
                            dp[i][j]=true;
                         else if(dp[i][j-1]&& (p.charAt(i-2)== '.' || p.charAt(i-2) == s.charAt(j-1)))
                            dp[i][j]=true;
                            
                    }
                }
            }
            return dp[k][n];
        }
 // best time to buy and sell stock II--------
    public int maxProfit1(int[] prices) {
        int profit=0;
        int bp=prices[0]; int sp=0;
    for(int i=1;i<prices.length;i++){
        if(prices[i-1]<prices[i]){
            sp=prices[i];
        }
        else{
            if(sp>bp)
                profit+=(sp-bp);
            bp=prices[i];
            sp=0;
        }
    }
        if(sp>bp) profit+=(sp-bp);
        return profit;
        
    }
    // wild card matching
    public boolean isMatch1(String s, String p) {
        int n = s.length();
        int k = p.length();
        boolean dp[][] = new boolean[k+1][n+1];
        dp[0][0]=true;
        int t=1;
        if(p.length()>0)
        while(p.length()>=t &&  p.charAt(t-1)=='*'){
            dp[t][0]=true;
            t++;
        }  
        for(int i =1;i<=k;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(i-1)==s.charAt(j-1)){
                    if(dp[i-1][j-1])dp[i][j]=true;
                }
                else if(p.charAt(i-1)=='*'){
                    if(dp[i-1][j]|| dp[i][j-1] ) dp[i][j]=true;
        }else if(p.charAt(i-1)=='?'){
                    if(dp[i-1][j-1])dp[i][j]=true;
                }
             
              
            }
            
        }
          return dp[k][n];
    }
    // Remove minimum elements from either side such that 2*min becomes more than max GFG
    public static int removeMinElements(int[] arr){
        int maxsub=1;
        for(int i=0;i<arr.length;i++){
            int min =arr[i];
            int max = arr[i];

            for(int j=i;j<arr.length;j++){
                // update min and max 
                min = Math.min(min, arr[j]);
                max=  Math.max(max,arr[j]);
                if(2*min>max){
                    maxsub = Math.max(maxsub,j-i+1);
                }

            }
        }
        return maxsub;
    }

    // count distinct subsequences
    public static void countDistinctSubseq(String str){
        int[] mapped = new int[26];
        int n = str.length();
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            int num = (int)ch-'a';
            if(mapped[num]!=-1)
        }
    }
    public static void main(String[] args){
        int[] primes = 
        {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
        int n =100000;
        System.out.println(nthSuperUglyNumber(n,primes));

    }
}