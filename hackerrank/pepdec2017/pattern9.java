import java.util.Scanner;

public class pattern9{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String args[]){
        int n = scn.nextInt();
        int nsp=(n/2), nst=0;
        for(int i=1;i<=n;i++){
            // int nst=(n-i+1);
            for(int csp=1;csp<=nsp;csp++){
                System.out.print(" ");
            }
            int nstval= nst;
            int nno=2*nst+1;
            for(int cst=1;cst <=nno;cst++){
                if(cst<=(nno/2)+1){
                    nstval++;
                }
                else{
                    nstval--;
                }
                
                System.out.print(nstval+ " ");
                
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