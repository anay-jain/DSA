import java.util.*;

public class rotationofnopro{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int a = scn.nextInt();
        int b = scn.nextInt();
        rotation(a, b);

        

    }
    public static int noOfDigits(int a){
        int count = 0;
        while(a!=0){
            count++;
            a/=10;
        }
        return count;

    }
    public static void rotation(int r , int k){
        int digit=noOfDigits(r);
        r=r%digit;
        r = r<0?r+digit:r;
        int temp = digit-r;
        int t=0;
        while (temp!=0) {
            t = (t*10) + (r%10);
            temp--;
            
        }
        while(r!=0){
        t +=((t*10) + r%10);
        r/=10;
        }
        System.out.println(t);
    }
    
    
}