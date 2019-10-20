import java.util.ArrayList;

public class sudoku{
    public static void main(String[] args){

    } 

    public boolean isValid(int[][] board , int row , int col,int num){
        for(int i=0;i<9;i++){
            if(num==board[i][col]){
                return fakse;
            }
        }
        for(int i=0;i<9;i++){
            if(num==board[row][i]){
                return false;
            }
        }
        int brow = row /3;
        int bcol = col/3;
        for(int i = brow*3 ; i<(brow+1)*3;i++){
            for(int j = crow*3 ; j<(crow+1)*3;j++){
                if(num==board[i][j]){
                    return false;
                }
                
            }
            return true;
        }
    }
    public static int[][] sodukuproblem(int [][] board){
        
        
    }


}