import java.util.Scanner;
public class Solution{
    public static void solve(int n){
        for(int i=0;i<n;i++){
            if((i&1)!=1){
                // odd
                for(int j=i*n+1 ;j<=i*n+n;j++){
                    System.out.print(j+" ");
                }

            }
            else{
                for(int j = i*n+n;j>=i*n+1;j--){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
       
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            solve(n);

        }
    }
}