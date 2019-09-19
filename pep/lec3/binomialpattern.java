import java.util.*;

public class binomialpattern{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int n = scn.nextInt();
        int nsp=1;
        for(int i=1;i<=n;i++){
            for(int csp=1;csp<=nsp;csp++){
                System.out.print("1");
            }
            nsp++;
            System.out.println("");
        }
        public static void bionomial(int n){
            
        }

    }
}