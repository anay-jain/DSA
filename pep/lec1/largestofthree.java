import java.util.*;

public class largestofthree{
    public static void main(String[] args){
        int a =2,b=3,c=34;
        if (a>b && a>c){
            System.out.println(a);
        }
        else if(b>a && b>c){
            System.out.println(b);
        }
        else{
            System.out.println(c);
        }

    }
}