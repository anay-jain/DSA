import java.util.Scanner;

public class numberpattern{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int n = scn.nextInt();
        int nsp=n/2 , nno=1,temp=1;
        for(int i=1;i<=n;i++){
            for(int csp=1;csp<=nsp;csp++){
                System.out.print(" ");
            }
            temp=(nno/2)+1;
            for(int cno=1;cno<=nno;cno++){
                if(cno<=nno/2){
                    System.out.print(temp);
                    temp+=1;
                    
                }
                else{
                    System.out.print(temp);
                    temp-=1;
                }
            }
            if(i<=n/2){
                nno+=2;
                nsp--;
            }
            else{
                nno-=2;
                nsp++;
            }
            System.out.println("");
           
        }
    }
}
