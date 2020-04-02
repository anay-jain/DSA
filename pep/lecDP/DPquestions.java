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
    public class pair implements Comparable<pair>{
        int w ;
        int h ;
        pair(int w , int h ){
            this.w=w;
            this.h=h;
            
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        
    }
    public static void main(String[] args){

    }
}