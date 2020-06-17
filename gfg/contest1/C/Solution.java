import java.util.*;
public class Solution{

   public static int helper(int n ){
        // if number of vertices is less than 2, you can't do anything
        int level=0;
        if(n<4)
            return 0;
        // if number of vertices is equal to 3, then you can easily find the answer by
        //multiplying the vertices value
        if(n == 4)
            return 2;
        
     
        int min = Integer.MAX_VALUE;
        //sol(i,j) = sol(i,k)+sol(k,j)+A[i]*A[k]*A[j];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                level++;
        for(int k = j+1; k<n;k++){
         
        }
    }}
       
        return level;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        while(n-->0){
            int c = scn.nextInt();
            System.out.println(helper(c));
        }
    }
        
}