import java.util.Scanner;

public class c {
   static int[][] dir = {{1,0},{-1,0},{0,1},{1,0},{1,-1},{1,1},{-1,1},{-1,-1}};
    public static void solve(char[][] board , int k ){
        board[0][0]='O';
       for(int i =1;i<k;i++){
           board[i/8][i%8]='.';
       }
    }
    public static void display(char[][] board){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int k = scn.nextInt();
            char[][] board = new char[8][8];
            for(int i =0;i<8;i++){
                for(int j =0;j<8;j++){
                    board[i][j]='X';
                }

            }
            solve(board, k);
            display(board);
        }
    }
}