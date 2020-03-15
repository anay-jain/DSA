import java.util.ArrayList;
import java.util.LinkedList;
public class Graph{
    static  class Edge{
        int v = 0;
        int wt  = 0;
        Edge(int v , int wt){
            this.v = v;
            this.wt=wt;
        }
    }
    static int n =9;
    static ArrayList<Edge>[] graph= new ArrayList[n];
    
    public static void addEdge(int u , int v , int wt){
        graph[u].add(new Edge(v, wt));
        graph[v].add(new Edge(u, wt));

    }


    //---has Path----------------------------------------------------------------------------
    public static boolean dfs_01(int src , int dest, boolean[] isVis){
        if(src==dest){
            System.out.print("founded");
            return true;
        }
        boolean res = false;
        isVis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            int nbr = graph[src].get(i).v;
            // rec call
            if(isVis[nbr]==false)
            res = res || dfs_01(nbr, dest, isVis);

        }
    return res;
    }
// -- all path-------------------------------------------------------------------------------------
public static  int  allPath(int src , int dest, boolean[] isVis){
    if(src==dest){
        System.out.print("founded");
        return 1;
    }
    // boolean res = false;
    int count =0;
    isVis[src]=true;
    for(int i=0;i<graph[src].size();i++){
        int nbr = graph[src].get(i).v;
        // rec call
        if(isVis[nbr]==false)
        count += allPath(nbr, dest, isVis);

    }
    isVis[src] = false;
return res;
}
    // ---- hamilton path ----------------------------------------------------------------------
    public static int searchVertex(int u , int v){
        int idx =-1;
        for(int i =0;i<graph[u].size();i++){
            if(graph[u].get(v).v==v){
                idx =i;
                break;
            }

        }
        return idx;
    }
    public static void hamiltonianPath(int src , int osrc ,int level,  boolean[] isVis , String ans){
        if(level  = n-1){
            int idx = searchVertex(src, osrc);
            if(idx==-1){
                System.out.println(ans +src + " ans its a cycle");
            }
            else{
                System.out.println(ans+src);
            }
        }
        isVis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            int nbr = graph[src].get(i).v; 
            if(isVis[nbr]==false)
            hamiltonianPath(nbr, osrc, level+1, isVis, ans+src);
        }
        isVis[src]=false;
    }
    
   // dfs surrounded paths
   public static void dfs_surrounded_paths(char[][] board ){
       // loop for all corner of arrays
       if(board.length==0){
           return;
       }
        int n = board.length;
        int m = board[0].length;
       for(int i =0;i<board.length;i++){
           if(board[i][0]=='O'){
               surrounded_regions(board, i , 0);
           }
           if(board[i][m-1]=='O'){
               surrounded_regions(board, i , m-1);
           }
       }
       for(int i =0;i<board[0].length;i++){
        if(board[0][i]=='O'){
            surrounded_regions(board, 0 , i);
        }
        if(board[n-1][i]=='O'){
            surrounded_regions(board, n-1 , i);
        }
       }
       for(int i=0;i<board.length;i++){
           for(int j =0;j<board[0].length;j++){
               if(board[i][j]=='#'){
                   board[i][j]='O';
               }
               else if(board[i][j]=='O')
                board[i][j]='X';
           }
       }
       
   }

   public static void surrounded_regions(char[][] board , int r ,int c){
       if(board[r][c]!='O'){
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
   // count servers that communicate ----------------------------------------------------------------
   /* 
   class Solution {
public:
    int dir[4][2] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

int dfs(int x, int y, int &len, vector<vector<int>> &grid)
{
    grid[x][y] = 2;
    int count = 0;
    for (int i = 0; i < 4; i++)
    {
        for (int rad = 1; rad <= len; rad++)
        {
            int u = x + rad * dir[i][0];
            int v = y + rad * dir[i][1];

            if (u >= 0 && v >= 0 && u < grid.size() && v < grid[0].size())
            {
                if (grid[u][v] == 1)
                    count += dfs(u, v, len, grid);
            }
            else
                break;
        }
    }

    return count + 1;
}
    int countServers(vector<vector<int>>& grid) {
          std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);
    int ans = 0;
    int len = max(grid.size(), grid[0].size());
    for (int u = 0; u < grid.size(); u++)
        for (int v = 0; v < grid[0].size(); v++)
            if (grid[u][v] == 1)
            {
                int count = dfs(u, v, len, grid);
                ans += (count == 1 ? 0 : count);
            }

    return ans;
    }
};
   */
  // method 02----------------
  public static int countServers(int[][] grid){
      int n = grid.length;
      int m = grid[0].length;
      int[] row = new int[n];
      int[] col = new int[m];
    
    int total_server = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            row[i] += grid[i][j];
            col[j] += grid[i][j];
            total_server+=grid[i][j];
        }
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (grid[i][j] == 1 && row[i] * col[j] * grid[i][j] == 1)
                total_server--;
        }
    }

    return total_server; 
  } 
  // GCC--------------------------------------------------------------------------------------------
  
// Bipartite graph----------------------------------------------------------------------------------
public static boolean bipartite(int src , int[] vis){
    LinkedList<int[]> que = new LinkedList<>();
    que.add(new int[]{src,0});
    while(que.size()!=0){
        int[] pair = que.peek();
        int num =pair[0];
        int clr = pair[1];
        if(vis[num] != -1){
            if(vis[num] == clr){
                return false; //iska mtlb vo num phele kisi aur clr se aaya hai aur ab kisi aur num se
            }
            else
            continue;
        }
        
        vis[num]=clr;
        for(int i=0;i<graph[src].size();i++){
            int nbr = graph[src].get(i).v;
            if(vis[nbr] != -1){
                int[] pair1 = {nbr,(clr+1)%2};
                que.addLast(pair1);
            }
        }
    }
    
    return true;
}
public static void isBipartite(){
    int[] vis = new int[n]; 
    for(int i=0;i<n;i++){
        if(vis[i] == -1)
          bipartite(i , vis);
      }
  }
  // 
  public static void createGraph(){
      for(int i =0;i<n;i++){
          graph[i] = new ArrayList<Edge>();
      }

    addEdge(0, 1, 10);
    addEdge(0, 3, 10);
    addEdge(1, 2, 10);
    addEdge(2, 3, 40);
    addEdge(3, 4, 2);
    addEdge(4, 5, 2);
    addEdge(4, 6, 8);
    addEdge(5, 6, 3);

    addEdge(7, 8, 3);
    addEdge(2, 7, 3);
    addEdge(2, 8, 3);
  }
   public static void main(String[] args){
        // char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        // dfs_surrounded_paths(board);
        // for(int i=0;i<board.length;i++){
        //     for(int j =0;j<board[0].length;j++){
        //         System.out.print(board[i][j]+ " ");

        //     }
        //     System.out.println();
        // }

            createGraph();
            dfs_01(0, 8, new boolean[9]);
    }
}