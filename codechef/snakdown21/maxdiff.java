import java.util.Scanner;
public class maxdiff{
   
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int s = scn.nextInt(); 
            if(s>=n){
                System.out.println(2*n-s);
            }
            else{
                System.out.println(s);
            }
        }
    }
}