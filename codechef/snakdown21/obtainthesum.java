import java.util.Scanner;
public class obtainthesum{
   
    public static long solve(long n , long s)   {
        long ps=0;
        if(n%2==0){
            ps = (n/2)*(n+1);
        }
        else{
            ps = ((n+1)/2)*n;
        }
                  if((ps-s)>0)
                  return ps-s;
                return -1;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            long n = scn.nextLong();
            long s = scn.nextLong(); 
            System.out.println(solve(n, s));


                    }
    }
}