import java.util.Scanner;
public class sadalpoint{
    
public static Scanner scn = new Scanner(System.in);
    public static int sadal(int[][] arr){
        int temp=-1,flag=0;
        int min=arr[0][0];
        int max = arr[0][0];
        for(int i=0;i<m;i++){
            
            for(int j=0;j<n;j++){
                if(min>arr[i][j]){
                    arr[i][j]=min;
                }
            }
        }
        for(int i=0;i<n;i++){
            
            for(int j=0;j<m;j++){
                if(max<arr[j][i]){
                    arr[i][j]=max;
                }
            }
        }
        if(min==max){
            System.out.println(max);
        }
        else{
            System.out.println("No Such Point Exist");
        }
    }
    public static void main(String[] args){
        int[][] arr  = new int[m][n];
        for(int i=0;i<m;i++){
            
           arr[i][j]=scn.nextInt();
            }
        }
        sadal(arr);
    }
}