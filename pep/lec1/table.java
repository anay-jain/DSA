import java.util.Scanner;
public class table{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Enter the number and upto");
        int n = scn.nextInt();
        int a = scn.nextInt();
        for(int i =1;i<a;i++){
            System.out.println( n*i);
        }

    }
}