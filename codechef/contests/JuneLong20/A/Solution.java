import java.util.Scanner;
public class Solution{
    public static void solve(int n , int k , int[] arr){
        long count = 0 ;
        for(int i=0;i<n;i++){
            if(arr[i]>k){
                count+=(arr[i]-k);
            }   
        }
        System.out.println(count);
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i]=scn.nextInt();
            solve(n, k, arr);

        }
    }
}