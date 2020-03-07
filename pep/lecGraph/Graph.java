public class Graph{
    public class Edge{
        int v = 0;
        int wt  = 0;
        Edge(int v , int wt){
            this.v = v;
            this.wt=wt;
        }
    }

   // dfs surrounded paths
   void dfs_surrounded_paths(char[][] board ){
       // loop for all corner of arrays
        int n = board.length;
        int m = board[0].length;
       for(int i =0;i<board.length;i++){
           if(board[i][0]=='0'){
               surrounded_regions(board, i , 0);
           }
           if(board[i][m-1]=='0'){
               surrounded_regions(board, i , m-1);
           }
       }
       for(int i =0;i<board[0].length;i++){
        if(board[0][i]=='0'){
            surrounded_regions(board, 0 , i);
        }
        if(board[n-1][i]=='0'){
            surrounded_regions(board, n-1 , i);
        }
       }
       
   }

   void surrounded_regions(char[][] board , int r ,int c){
       if(board[r][c]='0'){
           return ;
       }
       board[r][c]='#';
       if(r-1>=0){
           surrounded_regions(board, r-1, c);
       }
       if(c-1>=0){
           surrounded_regions(board, r, c-1);
       }
       if(c+1<board[0].length){
           surrounded_regions(board, r, c+1);
       }
       if(r+1<board.length){
           surrounded_regions(board, r+1, c);
       }
   }
   public static void main(String[] args){

    }
}