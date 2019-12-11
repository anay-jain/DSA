import java.util.Scanner;

public class watscore{
    public static Scanner scn =new Scanner(System.in);
    public static int score(int  n){
        int total=0;
        int[] arr = new int[8];
        for(int i=0;i<n;i++){
            int a =scn.nextInt();
            int b = scn.nextInt();
            if(a<=8 && arr[a-1]<b){
                arr[a-1]=b;
            }
        }
        for(int s: arr){
                total+=s;
        }   
        return total;
    }
    public static void main(String[] args){
        int tc = scn.nextInt();
        while(tc!=0){
            int n = scn.nextInt();
            System.out.println(score(n));
            tc--;
        
        }
    }
}