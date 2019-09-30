import java.io.*;
import java.util.*;

public class gcd {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int a = scn.nextInt();
        int b = scn.nextInt();
        int min = a>b?a:b;
        int gcd=1;
        for(int i=1;i<min;i++){
            if(a%i==0 && b%i==0){
                gcd=i;
            }
        }
        int lcm =(a*b)/gcd;
        System.out.print(gcd + " " + lcm);
    }
}