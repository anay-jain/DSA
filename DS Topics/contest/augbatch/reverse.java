import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        System.out.println(reverse(n)); 
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
    public static int reverse(int n){
        int res=0;
        while(n!=0){
            int rem = n%10;
            res = res*10+rem;
            n/=10;
        }
        return res;
    }
}