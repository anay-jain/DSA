public class Graph{
    // dfs surrounded regions
    void surrounded_regions(char[][] board){
        int m = board.length;
        int n = board[0].length;

        for(int i =0;i<board.length;i++){
            if(board[i][0]=='0'){
                dfs_surrounded_regions(board);
            }
            if(board[i][m-1]=='0'){
                dfs_surrounded_regions(board);
            }
            
        }
        for(int i=0;i<board[0].length;i++){
            if(board[0][i]=='0'){
                dfs_surrounded_regions(board);
            }
        }
        
    }
    public static void main(String[] args){

    }
}