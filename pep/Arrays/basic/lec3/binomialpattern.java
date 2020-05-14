import java.util.Scanner;

public class binomialpattern{

    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int a = scn.nextInt();
        bionomial(a);
    }
    public static void bionomial(int x){
        int nno=1;
        for(int i =0;i<x;i++){
            int res=1;
            for(int cno=0;cno<nno;cno++){
                System.out.print(res + " "); 
                res = ((i-cno)*res)/(cno+1);   
            }
            nno++;
            System.out.println("");
        }
    }
}