import java.util.Scanner;
import java.util.Arrays;
public class fillgrid{
   
    public static int[][] solve(int n)   {
       int[][] arr = new int[n][n];
        if(n==2){
            // System.out.print(-1);
            // System.out.print(" ");
            // System.out.print(-1);
            // System.out.println("");
            // System.out.print(-1);
            // System.out.print(" ");
            // System.out.print(-1);
            arr[0][0]=-1;
            arr[1][0]=-1;
            arr[0][1]=-1;
            arr[1][1]=-1;
       }
       else{
        for (int[] row : arr)
        Arrays.fill(row, 1);
        while(n>0){
            arr[n-1][n-1]=-1;
            n--;
        }
       }
      
       return arr;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            // long s = scn.nextLong(); 
           int[][] matrix = solve(n);
            System.out.println(matrix);
        //    System.out.print(Arrays.deepToString(matrix));
        //    Arrays.stream(matrix).forEach((row) -> {
     
        //     Arrays.stream(row).forEach((el) -> System.out.print(el + " "));
        //     System.out.println("");
        //   });
        //    for(int i=0;i<n;i++){
        //        for(int j =0;j<n;j++){
        //         System.out.print(arr[i][j]+" ");
        //        }
        //        System.out.println("");
        //    }


                    }
    }
}