public class sol{
static final int N = 401; 
  
// To store the states of DP 
static int [][]dp = new int[N][N]; 
static boolean [][]v = new boolean[N][N]; 
  
// Function to return the minimum merge cost 
static int minMergeCost(int i, int j, int val,  int[] arr) 
{ 
  
    // Base case 
    if (i == j) 
        return 0; 
  	// if(i+1==j){
  	// 	return val*;
  	// }
    // If the state has been solved before 
    if (v[i][j]) 
        return dp[i][j]; 
  
    // Marking the state as solved 
    v[i][j] = true; 
    // int x = dp[i][j]; 
  
    // Reference to dp[i][j] 
    int  x = Integer.MAX_VALUE; 
  
    // To store the sum of all the 
    // elements in the subarray arr[i...j] 
    int tot = 0; 
    for (int k = i; k <= j; k++) 
        tot += arr[k]; 
  
    // Loop to iterate the recurrence 
    for (int k = i + 1; k <= j; k++)  
    { 
        x = Math.min(x, val *tot + minMergeCost(i, k - 1,val, arr) 
                    + minMergeCost(k, j, val,arr)); 
    } 
  	 dp[i][j] =x;
    // Returning the solved value 
    return x; 
} 


public static void main(String[] args){
	int[] arr = {1,2,3};
	int n = arr.length;
	System.out.println(minMergeCost(0,n-1,2,arr));
}
}