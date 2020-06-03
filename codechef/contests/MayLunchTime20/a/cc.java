import java.io.*;
import java.util.*;

class cc{

    public static void main(String[] args) {
  
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            // int n = in.nextInt();
            int arr[] = new int[5];
          for(int i =0;i<5;i++)
          arr[i]=in.nextInt();
            int p = in.nextInt();
            if(check(arr,p)){
              System.out.println("No");
            }else{
              System.out.println("Yes");
            }
        }
     
      }
    
    public static boolean check(int[] arr , int p){
        int sum =0;
        for(int i=0;i<5;i++){
            sum += (arr[i]*p);

        }
        if(sum<=120){
            return true;
        }
        else{
            return false;
        }
    }
}