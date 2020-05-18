import java.util.Scanner;

public class numberOfCycles{

    public static int solve(int n){
        if(n<=2){
            return n;
        }
        else{
            return n*(n-1)+1;
        }
    }
    public static void main(String[] args){
      
        Scanner scn = new Scanner(System.in);
        long t= scn.nextLong();
        while(t-->0){
            long n = scn.nextLong();
            System.out.println(solve(n));
        }
    }
}