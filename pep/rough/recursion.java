import java.util.ArrayList;
public class recursion{
    public static int maximum(int[] arr, int vidx){
        if(vidx == arr.length-1){
            return arr[vidx];   
        }
        int max = maximum(arr, vidx+1);
        max = arr[vidx]<max?max:arr[vidx];
        return max;
    }
   
    public static int lastindex(int[] arr , int vidx, int data){
        if(vidx == arr.length){
            return -1;
        }
        int recAns= lastindex(arr, vidx+1, data);
        if(vidx != -1){
            return recAns;
        }
        else{
            return arr[vidx]==data?vidx:-1;
        }

    }
    public static int[] allindex(int[] arr, int vidx , int data,int count){
        if(vidx==arr.length){
            // for creating an array one time , we declare in the base
            int[] ans = new int[count];
            return ans;
        }
       
        if(arr[vidx]==data){
            count++;
        }
        int[] ans = allindex(arr,vidx+1,data,count);
        if(arr[vidx]==data){
            ans[count-1]=vidx;
            // count--;
        }
        return ans;
    }
    
    public static void main(String[] args){
        int[] arr={4,265,15,265,265,26,56,25,3};
        System.out.println(allindex(arr, 0, 265, 0));
    }
}