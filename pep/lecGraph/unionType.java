import java.util.ArrayList;

public class unionType{
    static ArrayList<Integer> par = new ArrayList<>();
    static ArrayList<Integer> size = new ArrayList<>();

    // finds parent
    public static int find(int u){  
        if(par.get(u)==u){
            return u;
        }
        int p = find(par.get(u));
        par.set(u, p); // path compression
        return p;
    }
    // hm dono se parent magva rhe hai
    public static void merge(int p1 , int p2){
        if(size.get(p1)>size.get(p2)){
            par.set(p2, p1); 
            size.set(p1, size.get(p1)+size.get(p2));
        }else{
            par.set(p1, p2); 
            size.set(p2, size.get(p1)+size.get(p2));

        }

    }
    // redundant connections   684 Leetcode ----------------------------------------------------
    public int[] findRedundantConnection(int[][] edges) {
        for(int i=0;i<edges.length;i++){
            par.add(i); 
            size.add(1);
        }
        for( int[] ar : edges){
            int p1= find(ar[0]-1);
            int p2= find(ar[1]-1);
            System.out.println(ar[0]+" "+ar[1]);
            if(p1 != p2){
                merge(p1,p2);
            }
            else{
                return ar;
            }
        }
        int[] ar = new int[0];
    return ar;
    }

    // -- 1061 Leetcode(Locked) lexiographically smallest equivalent string
    /*
    Given strings A and B of the same length, we say A[i] and B[i] are equivalent characters. For example, if A = "abc" and B = "cde", then we have 'a' == 'c', 'b' == 'd', 'c' == 'e'.

Equivalent characters follow the usual rules of any equivalence relation:

    Reflexivity: 'a' == 'a'
    Symmetry: 'a' == 'b' implies 'b' == 'a'
    Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'

For example, given the equivalency information from A and B above, S = "eed", "acd", and "aab" are equivalent strings, and "aab" is the lexicographically smallest equivalent string of S.

Return the lexicographically smallest equivalent string of S by using the equivalency information from A and B.

 
    
    */

    public static String smallestEquiString(String a , String b){

        // ArrayList<Integer> mapped = new ArrayList<>();
        for(int i =0;i<26;i++){
            par.add(i); // as we have mapped our par array according to lexo rank
        }
        for(int i=0;i<a.length;i++){
            int p1 = find(a.charAt(i)-'a');
            int p2 = find(b.charAt(i)-'a');
            int min= Math.min(p1, p2); // will give lexo smaller as we have mapped
            par.set(p1, min);
            par.set(p2, min);

        }
        String ans="" ;
        for(int i=0;i<a.length();i++){
            int p = a.charAt(i)-'a';
            int mp = find(p);
            ans += (char)(mp+'a');
        }
        return ans;
    }
    //No of islands 200 ---------------------------------------------------------
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

    public static int noOfIslands_(char[][] grid  , int X , int Y){
         grid[X][Y]='0';
        int count =0;
        for(int i=0;i<dir.length;i++){
            int x = X + dir[i][0];
            int y = Y + dir[i][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!='0'){
                count+=noOfIslands_(grid,x,y);
            }
        }
        return count+1;
    }
    public static int noOfIslands(char[][] grid){
        int totalCount=0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    totalCount++;
                           noOfIslands_(grid, i, j);  
                        
                    }
            }
        }
        return totalCount;
    }
    // 695 Max Area in Island---------------------------------------------------------
    static int maxArea =0;
    public static int maxAreaofIslands(int[][] grid , int X , int Y){
        if(count>maxIsland){
            maxIsland=count;
        }
        grid[X][Y]=0;
        int count =0;
        for(int i=0;i<dir.length;i++){
            int x = X + dir[i][0];
            int y = Y + dir[i][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]!='0'){
                count+=maxAreaOfIslands(grid,x,y);
            }
        }
        return count+1;

    }
    public static int maxAreaOfIsland(int[][] grid){
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    // totalCount++;
                          count =  maxAreaofIslands(grid, i, j);  
                          maxArea = Math.max(count , maxArea);
                    
                    }
            }
        }
        return maxArea;
    }
    // island perimeter 463 Leetcode------------------------------------------------------------
    public int islandPerimeter(int[][] grid) {
        int total=0;
        int nbrs=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    total++;
                    if(i+1<grid.length && grid[i+1][j]==1){
                        nbrs++;
                    }
                    if(j+1<grid[0].length && grid[i][j+1]==1){
                        nbrs++;
                    }
                }
        
            }
            
        }
        return total*4-nbrs*2;
    }
    public static void main(String[] args){

    }
}