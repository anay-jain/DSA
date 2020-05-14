import java.util.Scanner;

public class allindex{

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){

    }

    public static int[] allindex1(int[] arr,int vidx,int data ){
        if(vidx==arr.length) return -1;
        if(arr[vidx]==data){
            count+=1;
        }        
        
        int recans = allindex1(arr,vidx+1,data);
        int[] arr1 = new arr[count];
        if(arr[vidx]==data){
            arr[ind]=vidx;
            ind++;

        }

    }
}