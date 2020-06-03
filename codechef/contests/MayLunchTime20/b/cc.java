import java.io.*;
import java.util.*;

class cc{

    public static void main(String[] args) {
  
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            
            int arr1[] = new int[n];
            int arr2[] = new int[n];
            for(int i =0;i<n;i++){
                arr1[i]=in.nextInt();
            }
            for(int i =0;i<n;i++){
                arr2[i]=in.nextInt();
            }
            System.out.println(distance(arr1, arr2, n));
          
        }
     
      }
      public static long distance(int[] arr1 , int[] arr2 , int n ){
          int count1 =0;
          int count2 =0 ;
          long dist =0;
          for(int i =0;i<n;i++){
              
            if(count1==count2 && arr1[i]==arr2[i]){
                dist+=arr1[i];
                count1 =0;
                count2 =0;
            }
            if(count1!=count2){
              int min = Math.min(count1, count2);
              count1-=min;
              count2-=min;
            }
            count1 = (count1 + arr1[i]);
            count2+=arr2[i];
        } 
        return dist;
      }
      
   
}