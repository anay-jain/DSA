import java.util.Scanner;

public class exitpoint{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] v= new int[n][m];
        input(v);
        exit(v); 
    }
    public static void exit(int[][] v){
        int dir=0 , row=0,col=0;
        while(true){ // an infinte loop which will only break in inner break condition
            dir = (dir + v[row][col])%4;
            if(dir==0){
                col++;
                if(col == v.length){
                    System.out.println("Row : " + row + "Col " + (col-1));
                    break;
                }
            }
            if(dir==1){
                row++;
                if(row ==v.length){
                    System.out.println("Row : " + (row-1) + "Col " + col);
                    break;
                }
            }
            if(dir==2){
                col--;
                if(col== -1){
                    System.out.println("Row : " + row + "Col " + (col+1));
                    break;
                }
            }
            if(dir==3){
                row--;
                if(row == -1){
                    System.out.println("Row : " + (row+1) + "Col " + col);
                    break;
                }
            }
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