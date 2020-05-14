import java.util.Scanner;

public class spiralprint{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] v = new int[n][m];
        input(v);
        spiral(v);

    }
    public static void spiral(int[][] v){
        int rmin=0 , cmin=0,rmax=v.length-1,cmax=v.length-1;
        int tne= (rmax+1)*(cmax+1);
        while(tne>0){
            for(int i=cmin;i<=cmax && tne>0 ;i++){
                System.out.print(v[rmin][i]);
                tne--;
            }
            rmin++;
            for(int i=rmin;i<=rmax && tne>0 ;i++){
                System.out.print(v[i][cmax]);
                tne--;
            }
            cmax--;
            for(int i=cmax;i>=cmin && tne>0 ;i--){
                System.out.print(v[rmax][i]);
                tne--;
            }
            rmax--;
            for(int i=rmax;i>=rmin && tne>0 ;i--){
                System.out.print(v[i][cmin]);
                tne--;
            }
            cmin++;
        }
    }
    public static void input(int[][] v){
        for(int row=0;row<v.length;row++){
            for(int col=0;col<v.length;col++){
                v[row][col]= scn.nextInt();
                
            }
        }
    }
}