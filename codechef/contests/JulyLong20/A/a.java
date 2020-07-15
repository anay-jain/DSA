import java.util.Scanner;

class a{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
                arr[i]=scn.nextInt();
            long ans =0;
            for(int i=1;i<n;i++){
                ans += (Math.abs(arr[i]-arr[i-1])-1);    
            }
            System.out.println(ans);
        }
    }
}