public class recursion {
    int[][] dir = {{1,0},{0,1},{-1,0} , {0,-1}};
    char[] dirStr = {'N','E','S','W'};
    
    class pair {
        String path;
        int len;
        pair( String s , int l){
            path =s;
            len = l;
        }
    }

    pair ShortestPath( int sr , int sc , int er , int ec , int[][] board){
        if(sr == er && sc == ec){
            return new pair("", 0);
        }
        board[sr][er] = 1;
        pair myAns = new pair("", board.length*board[0].length);
        // running in all direction
        for(int i =0;i<dir.length;i++){
            int x = sr + dir[i][0];
            int y = sc + dir[i][1];
            if(x>=0 && y >=0 && x < board.length && y <board[0].length && board[x][y]==0){
                pair smallAns = ShortestPath(x, y, er, ec, board);
                if(smallAns.len +1 < myAns.len){
                    myAns.len= smallAns.len+1;
                    myAns.path = dirStr[i] + smallAns.path;
                }
            }
        }
        board[sr][sc] =1;
        return myAns;   
    }

    public static boolean isValidMove(boolean[][] board, int x , int y){
        if(x<0 || y< 0 || x>=board.length || y>=board[0].length){
            return false;
        }
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        for(int i =0;i<dir.length;i++){
            for(int rad =1;rad<board.length;rad++){
                int X = x + rad*dir[i][0];
                int Y = y + rad*dir[i][1];
                if(X>0 && Y> 0 && X<board.length && Y<board[0].length)
                    if( board[X][Y]==true)
                    return false;
            }
        }
        return true;
    }
    public static int nQueens(boolean[][] board,int tnq , int idx){
        if(tnq ==0){
            return 1;

        }
        int n = board.length , m = board[0].length , count =0;
        for (int i = idx; i < n * m; i++)
    {
        int r = i / m;
        int c = i % m;
        if (isValidMove(board, r, c) && !board[r][c])
        {
            board[r][c] = true;
            count += nQueens(board, tnq - 1, 0);
            board[r][c] = false;
        }
    }

    return count;

    }
    public static void main(String[] args){


        
    }
}
