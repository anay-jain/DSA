public class dprevise{
    public static int stairsproblem(int n , int[] coins){
        int[] memo= new int[n+1];
        memo[0]=1;
        for(int i=0;i<n+1;i++){
            for(int s:coins){
                if(i-s>=0){
                    memo[i] +=  memo[i-s];
                }
            }
            
        }
        return memo[n];
    }
    public static void mcm(int[] arr){
        int[][] memo = new int[arr.length-1][arr.length-1];
        for(int gap =0;gap<=arr.length-1;gap++){
            for(int i =0,j=gap+i;j<arr.length-1;j++,i++){
                if(gap==0){
                    memo[i][j]=0;
                }
                else if(gap==1){
                    memo[i][j]=arr[j]*arr[j-1]*arr[j+1];
                }
                else{
                memo[i][j] = Integer.MAX_VALUE;
                for(int k =i;k<j;k++){
                    
                    memo[i][j]=Math.min(memo[i][j],memo[i][k]+memo[k+1][j]+(arr[i]*arr[j+1]*arr[k+1]));
                }
            }
            }
        }
        
         

    }
    public static void main(String[] args){
        int[] coins={2,3,5};
        System.out.println(stairsproblem(7, coins));
    }
}