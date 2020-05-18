import java.util.Scanner;

public class numberOfCycles{

    public static long solve(long n, long x){
        if(n==1) return x;
        else if (n==2) return (long)Math.pow(x%10, 2)%10; // sbme karna hai ye wala kaam
        
        else if(n==3) return Math.pow(x,6);
        else if(n==4) return Math.pow(x, 4);
        else return 1;
      
    }
    public static void main(String[] args){
      
        Scanner scn = new Scanner(System.in);
        long x= scn.nextLong();
            long n = scn.nextLong();
            System.out.println(solve(n, x));
        
    }
}