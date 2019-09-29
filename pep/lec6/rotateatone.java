import java.util.Scanner;

public class rotateatone{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int flag=1, row=0,col=0;
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] v = new int[n][m];

            while(row>=v.length || col>=v.length){
                if(flag==1){
                    while(v[row][col] != 1){
                        col++;
                        flag++;
                    }
                }
                if(flag==3){
                    while(v[row][col] != 1){
                        col--;
                        flag++;
                    }
                }
                if(flag==2){
                    while(v[row][col != 1]){
                        row++;
                        flag++;
                    }

                }
                if(flag==4){
                    while(v[row][col != 1]){
                        row--;
                        flag++;
                    }
                    
                }
                flag %= 4;
                
            }
            System.out.print("row" + row +"  col " + col);

    }
    public static void input(int[][] v){
        for(int row=0;row<v.length;row++){
            for(int col=0;col<v.length;col++){
                
            }
        }
    }

}