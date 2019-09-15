import java.util.Scanner;

public class rotationofnopro{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int a = scn.nextInt();
        int b = scn.nextInt();
        System.out.println(rotation(a,b));


    }
    public static int reverseOfNo(int a ){
        int count =0;
        while(a!=0){
            count ++;
            a/=10;

        }
        return count;
        
    }

    public static int rotation(int a , int k){
        int digit = reverseOfNo(a);
        k=k%digit;
        int mul=1,div=1;
        k = k<0?k+digit:k;
        for(int i=1;i<=digit;i++){
            if(i<=k){
                mul*=10;
            }
            else{
                div*=10;
            }
        }
        int rem = a%div;
        a/=div;
        return (rem*mul) + a;


    }

}