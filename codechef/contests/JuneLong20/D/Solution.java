import java.util.Scanner;
public class Solution{
    public static void solve(long n){
        if(n<2){System.out.println(0); return;}
         long t =n;
        int count=0;
        // if((n&1)==1) count =1;
            if((n&1)!=1)
            while(n>0 && (n&1)!=1){
                count++;
                n>>=1;
            }
           System.out.println((long)(t/(long)(Math.pow(2, count+1)))); 
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            long n = scn.nextLong();
            solve(n);
        }
    }
}