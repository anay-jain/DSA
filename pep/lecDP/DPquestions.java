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
    public boolean canIWin_(){
        
    }
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
    public static void main(String[] args){
        int[] primes = 
        {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
        int n =100000;
        System.out.println(nthSuperUglyNumber(n,primes));

    }
}