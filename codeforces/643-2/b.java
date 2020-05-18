import java.util.Arrays;
import java.util.Scanner;

public class b{
    public static Scanner scn = new Scanner(System.in);
    public static int solve(int[] arr){
        Arrays.sort(arr);
        int i = arr.length-1;
        int total=0;
        while(i!=-1){
            int num = arr[i];
            while(num>0 && i!=-1){
               
                i--;
                num-=1;
            }
            if(num>=1){
                break;
                // total--;
            }
            else{
                total++;
            }
        }
        return total;
    }
    public static void main(String[] args){
        int t= scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = scn.nextInt();
        }
                    System.out.println(solve(arr));
        }
    }
}