import java.util.Scanner;
import java.util.HashMap;
public class Solution{
    public static void solve(int n , int[] arr){
        int[] coins = new int[3];
        for(int i=0;i<n;i++){
            coins[(arr[i]/5)-1]++;
            int val = arr[i]-5;
            if(val==0) continue;
            if(val== 5 && coins[0]>0){
                coins[0]--;
            }
            else if(val==10){
                if(coins[1]>0){
                    coins[1]--;
                }
                else if(coins[0]>1){
                        coins[0]-=2;
                    }
                else{
                        System.out.println("NO");
                        return;
                    }
                
            }
            else{
                System.out.println("NO");
                return;
            }
            
        }
        System.out.println("YES");
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i]=scn.nextInt();
            solve(n, arr);

        }
    }
}