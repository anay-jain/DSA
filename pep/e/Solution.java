import java.util.*;
class Solution {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j]= scn.nextInt();
            }
        }
        corona(arr);
        // if(v==-1){
        //     System.out.println("false");
        // }
        // else{
        //     System.out.println(v);
        //     System.out.println("true");
        // }
    }
    public static void corona(int[][] grid) {
        
      LinkedList<int[]> que = new LinkedList<>();
    for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==2){
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
                if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]!=0 && grid[x][y]!=2){
                    grid[x][y]=2;
                    que.addLast(new int[]{x,y});
                }
            }
          }
          level++;
      }
        boolean flag = false;
         for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                flag=true;
            }
        }}
        if(flag)
            {
                System.out.println(level-1);
                System.out.println("false");
                return;
            }
        else{
            System.out.println(level-1);
                System.out.println("true");
                return;
        }
          
            
           
      
    }
    
}