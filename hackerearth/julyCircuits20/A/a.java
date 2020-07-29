import java.util.Scanner;
public class a{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t= scn.nextInt();
        while(t-->0){
             
            if(n==0) System.out.println(1);
            
            else {
                if(n%2==0) System.out.println((((n/2)*(n+1)))+1);     
                      else System.out.println(n*((n+1)/2)+1);
            }
        }
    }
}