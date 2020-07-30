import java.util.Scanner;

public class a{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            String in = scn.next();
            String out = scn.next();

            char[][] arr = new char[n][n];
            for(int i =0;i<n;i++){
                while(out.charAt(i)=='Y'){
                    if(i+1<n && in.charAt(i+1)=='Y') arr[i][i+1]='Y';
                    
                }
                i++;
            }
        }
    }
}