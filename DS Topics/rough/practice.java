import java.security.DrbgParameters.Reseed;

public class practice{
    public static void main(String[] args){
        // System.out.println(rotation(45212,-3));
        System.out.println(reverseno(45212));

    }
    public static int lengthofno(int num){
        int count = 0;
        while(num!=0){
            num/=10;
            count++;
        }
        // System.out.println(count);
        return count;
    }
    public static int rotation(int num , int k){
        // length of a number 
        int len = lengthofno(num);
        // range
        k=k%len;
        // n+r to make -ve to +ve
        int mul=1,div=1;
        k = k<0?len+k:k;
        for(int i=1;i<=len;i++){
            if(i<=k){
                mul*=10;
            }
            else{
                div*=10;
            }
            
        }   
        int res = num/div;
        int rem = num%div;
        int finalnum = rem*mul+res;
        return finalnum;

    }
    public static int reverseno(int n){
        int number=0;
        while(n!=0){
            int t=n%10;
            n/=10;
            number = number*10 + t;
        }
        return number;
    }
}