import java.util.Scanner;
public class maxprod{
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int t = scn.nextInt();
        while(t-->0){
        int d = scn.nextInt();
        int x = scn.nextInt();
        int y = scn.nextInt();
        int z = scn.nextInt();
        System.out.println(Math.max(x*7,y*d+z*(7-d)));
        }
    }
}