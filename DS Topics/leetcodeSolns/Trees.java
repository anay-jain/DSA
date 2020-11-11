public class Trees{
    // leetcode 96 Unique binary search trees
    public static int numTrees(int n) {
        if(n==0 || n==1) return 1;
        if(n==2)return 2;
        
        int sum =0;
        for(int i =1;i<=n;i++){
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
    // dp solution
    public static int numTrees01(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        int sum =0;
        for(int i =1;i<=n;i++){
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(numTrees(3));
    }
}