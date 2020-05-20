import java.util.Scanner;

public class a{
    public static Scanner scn = new Scanner(System.in);
    public static int max(long num){
        int max=(int)num%10;
        while(num!=0){
            int a = (int)num%10;
            max = Math.max(max,a);
            num = num/10;
        }
        return max;
    }
    public static int min(long num){
        int max=(int)num%10;
        while(num!=0){
            int a=(int)num%10;
            max = Math.min(max,a);
            num = num/10;
        }
        return max;
    }
    public static long solve(long n , long k){

        for(int i=2;i<=k;i++){
            long ab = max(n)*min(n);
            if(ab==0) return n;
            else n = n+ab;
        }
        return n;
    }
    public static void main(String[] args){
        int t= scn.nextInt();
        while(t-->0){   
            long n = scn.nextLong();
            long k = scn.nextLong();
            System.out.println(solve(n, k));
        }
    }
}