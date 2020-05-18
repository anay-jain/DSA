import java.util.Arrays;
import java.util.Scanner;

public class arrayandswaps{
    public static Scanner scn = new Scanner(System.in);
    public static void array(int[] arr1 , int[] arr2, int k){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0,j=arr2.length-1;i<k;i++,j--){
            if(arr1[i]<arr2[j])
            swap(arr1,arr2,i,j);
            else break;
        
        }
    }
    public static void input(int n , int[] arr){
        for(int i=0;i<n;i++){
            arr[i]= scn.nextInt();
        }
    }
    public static void swap(int[] arr1 , int[] arr2 , int i , int j){
        int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
    public static void main(String[] args){
    int t = scn.nextInt();
    while(t-->0){
        int sum=0;
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        input(n, arr1);
        input(n, arr2);
        array(arr1, arr2 , k);
        for(int i=0;i<n;i++){
            sum+=arr1[i];
        }
        System.out.println(sum);
    }
    
    }
}