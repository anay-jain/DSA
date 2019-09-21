import java.util.*;

public class findandreverse{

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int a = scn.nextInt();
        int n = scn.nextInt();
        int[] arr = new int[a];
        input(arr);
        int f =find(arr,n);
        System.out.println(f);
    }

    public static void input(int[] arr){
        for(int i=0;i<arr.length;i++){
            arr[i]= scn.nextInt();

        }
    }
    public static int find(int[] arr , int x){
        int temp=0;
        for(int i=0;i<arr.length;i++){
            if(x==arr[i]){
                temp= i; }       
            }
            return temp;
    }
    public static void reverse(int[] arr, int i, int f){
        
    }
}