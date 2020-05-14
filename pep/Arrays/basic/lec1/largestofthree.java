import java.util.Scanner;
public class largestofthree{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int a = scn.nextInt();
        int b=3,c=34;
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