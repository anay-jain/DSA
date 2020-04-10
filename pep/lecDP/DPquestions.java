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