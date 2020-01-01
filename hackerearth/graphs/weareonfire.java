import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
public  class weareonfire{
    public static Scanner scn = new Scanner(System.in);
     static class edge{
        int x;
        int y;
        edge(int x , int y){
            this.x=x;
            this.y=y;

        }
        edge(){

        }
    }
    public static boolean issafe(int x , int y,int[][] worldmap){
        if(x>=0 && y>=0 && x<worldmap.length && y<worldmap[0].length)
        return true;

        return false;
    }
    public static void burnt(int x , int y , int[][] worldmap){
        LinkedList<edge> que =new LinkedList<>();
        edge rootnode = new edge(x,y);
        que.addLast(rootnode);
        int[][] coord = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!que.isEmpty()){
            edge rpair = que.remove();
            int xc = rpair.x-1;
            int yc = rpair.y-1;
            if(worldmap[xc][yc]!=0){
                worldmap[xc][yc]=0;
                for(int d =0;d<coord.length;d++){
                    int X = xc+coord[d][0];
                    int Y = yc+coord[d][1];
                    // System.out.println(X+" ,"+Y);
                    if(issafe(X, Y, worldmap) && worldmap[X][Y]!=0){
                        edge temp = new edge(X+1,Y+1);
                        que.addLast(temp);
                    }
                }
            }
           
        }
        int count=0;
        for(int i=0;i<worldmap.length;i++){
            for(int j =0;j<worldmap[0].length;j++){
                if(worldmap[i][j]!=0){
                    count++;
                }
            }
        } System.out.println(count);
    }
    public static void input(int x , int y , int[][] world){
        for(int i=0;i<x;i++){
            for(int j =0;j<y;j++){
                world[i][j]=scn.nextInt();
            }
        }

    }
    public static void main(String[] args){
        int x = scn.nextInt();
        int y = scn.nextInt();
        int t= scn.nextInt();
        int[][] world=new int[x][y];
        input(x, y, world);
        while(t!=0){
            int first = scn.nextInt();
            int second= scn.nextInt();
            int[][] arr =world;
            burnt(first, second, arr);
            // System.out.println(t);
            System.out.print("");
            t--;
        }
        // int[][] worldmap ={{0,0,0},
        //                 {1,0,1},
        //             {0,1,1}};
                    // burnt(3, 3, worldmap);

    }
}