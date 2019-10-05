import java.util.Scanner;

public class apowerb{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println(power(2,5));

    }
    public static int power(int a , int b){
        if(b==1){
            return a;
        }
        int res = power(a,b-1);
        return res*a;
    }
}