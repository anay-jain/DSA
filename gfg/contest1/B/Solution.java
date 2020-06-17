import java.util.*;

class Solution {
    public static void solve(char[][] grid) {
        int[][] arr = new int[grid.length][grid[0].length];
      LinkedList<int[]> que = new LinkedList<>();
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='B'){
                que.addLast(new int[]{i,j});
            }
        }
    }
      int level =0;
      while(que.size()!=0){
          int size = que.size();
          while(size-->0){
              int[] pair = que.removeFirst();
            
            int X = pair[0];
            int Y = pair[1];
            int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
            for(int i=0;i<dir.length;i++){
                int x = X+ dir[i][0];
                int y = Y + dir[i][1];
                if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='O'){
                    grid[x][y]='X';
                    arr[x][y]=level+1;
                    que.addLast(new int[]{x,y});
                }
            }
          }
          level++;
      }

         for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]=='B'){
                arr[i][j]=0;
            
            }
            if(grid[i][j]=='W' || grid[i][j]=='O'){
                arr[i][j]=-1;
            }
        
        }}
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
      
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int m= scn.nextInt();
            int n = scn.nextInt();
            scn .nextLine();
            char[][] grid = new char[m][n];
            // String s = scn.nextLine();
            // System.out.println(s);
            for(int i=0;i<m;i++){
                // char ch[] = scn.next().toCharArray();
                String s = scn.nextLine();
                for(int j =0;j<s.length();j+=2){
                    grid[i][j/2]=s.charAt(j);
                }
            //    grid[i]= ch;
                }
                // for(int i=0;i<grid.length;i++){
                //     for(int j=0;j<grid[0].length;j++){
                //         System.out.print(grid[i][j]+" ");
        
                //     }
                //     System.out.println();
                // }
              
            
                solve(grid);
            
       
    }
}
}