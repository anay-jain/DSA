import java.util.Scanner;

public class apowerb{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println(betterpower(2,100));

    }
    public static int power11(int a , int b){
        if(b==1){
            return a;
        }
        int res = power11(a,b-1);
        return res*a;
    }
    public static int betterpower(int a , int b){
        if(b==0){
            return 1;
        }
        
        int res = betterpower(a, b/2);
        int final1 = res*res;
        if(b%2==1){
            final1*=a;
        }
        return final1;
        
    }
}