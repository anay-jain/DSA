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
    public static void main(String[] args){
        int[] coins={2,3,5};
        System.out.println(stairsproblem(7, coins));
    }
}