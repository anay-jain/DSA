import java.util.Scanner;

public class pattern9{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        int n = scn.nextInt();
        int nsp=(n/2)+1 , nst=0;
        for(int i=1;i<n;i++){
            // int nst=(n-i+1);
            for(int csp=1;csp<=nsp;csp++){
                System.out.print(" ");
            }
            int nstval= nst;
            for(int cst=1;cst <=(2*nst+1);cst++){
                System.out.print(nstval);
                nstval++;
            }
            if(i<=n/2){
                nsp--;
                nst++;
            }
            else{
                nsp++;
                nst--;
            }
            System.out.println();
        }

        
    
    }
    
}