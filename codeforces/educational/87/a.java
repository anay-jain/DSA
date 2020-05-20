import java.util.Scanner;

public class a{
    public static long solve(long a , long b , long  c , long d){
        if(a<=b){
            return b;
        }
        else  if(c<=d){
            return -1;
        } 
          
       
                // if(c==d)  return (a-left_time)+c;
        else {

                long left_time = a-b;
                    long t= (long)Math.ceil(left_time*1.0/(c-d)); // 1.0 islie karna zarri hai kyuyki vo usse phele ho convert kar deta h
                    // System.out.println(t);
                    return (a-left_time)+ (t)*c;
                }
}
    public static void main(String[] args){
       Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            long a = scn.nextLong();
            long b = scn.nextLong();
            long c = scn.nextLong();
            long d = scn.nextLong();
            System.out.println(solve(a, b, c, d));
        }
       
    }
}