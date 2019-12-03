import java.util.*;
public class stairs{

   public static int stairs1(int n, int[]  strg){
    
        if(n==0){
            return 1;
        }
        // basee case
        int count=0;
        if(strg[n]!=0){
            return strg[n];
        }
        if(n>=1){
            count+=stairs1(n-1,strg);
            
        }
        if(n>=2){
            count+=stairs1(n-2,strg);
        }
        if(n>=3){
            count+=stairs1(n-3,strg);
        }
        strg[n]=count;
        return count;
    }
    public static int mp(int er , int ec){
        int[][] arr = new int[er+1][ec+1];
        arr[0][0]=1;
        for(int i=0;i<=er;i++){
            for(int j=0;j<=ec;j++){
                if(i>0){
                    arr[i][j]+=arr[i-1][j];
                }
                if(j>0){
                    arr[i][j]+=arr[i][j-1];
                }
                
            }
        }
        return arr[er][ec];
    }

    public static int mptabu( int[][] arr ){
        int er = arr.length-1;
        int ec = arr[0].length-1;
        int[][]  mini = new int[er+1][ec+1];
        for(int i=er ;i>=0;i--){
            for(int j=ec;j>=0;j--){
                if(i==er && j==ec){
                    mini[i][j]=arr[i][j];
                    
                }
                else if(i==er){
                    mini[i][j]=arr[i][j] + mini[i][j+1];
                }
                else if(j==ec){
                    mini[i][j]= arr[i][j] + mini[i+1][j];
                }
                else{
                    int temp=0;
                    if(mini[i+1][j]<mini[i][j+1]){
                        temp = mini[i+1][j];
                    }
                    else{
                        temp=mini[i][j+1];
                    }
                    mini[i][j]= arr[i][j] + temp;
                }
            }
        }
        return mini[0][0];
    } 
    public static void mazepath(int sr , int sc , int er , int ec , String ans  ,int[][] arr){
        if(sr==er && sc == ec){
            System.out.println(ans);
            return ;
        }
        if(arr[sr+1][sc] <arr[sr][sc+1] || sr==er-1 ){
            mazepath(sr+1, sc, er, ec, ans+'h', arr);
        }
        else if(arr[sr+1][sc] >arr[sr][sc+1] || sc==ec-1){
            mazepath(sr, sc+1, er, ec, ans+'v', arr);

        }
        else if(arr[sr+1][sc] ==arr[sr][sc+1]){
            mazepath(sr+1, sc, er, ec, ans+'h', arr);
            mazepath(sr, sc+1, er, ec, ans+'v', arr);
        }
        
    }
    public static int goldmine(int[][] arr){
        int[][] maxi = new int[arr.length][arr[0].length];
        for(j=arr[0c].length-1;j>=0;j--){
            for(int i=arr.length-1;i>=0;i--){
                
                
                if(i==arr.length-1){
                    maxi[i][j] = arr[i][j] + Math.max(maxi[i][j+1],maxi[i-1][j+1]);
                    
                }
                if(i==0){
                    maxi[i][j]= arr[i][j] + Math.max(maxi[i][j+1], maxi[i+1][j+1]);
                }
                else{
                    maxi[i][j]= arr[i][j] + Math.max(maxi[i][j+1], Math.max(maxi[i-1][j+1],maxi[i+1][j+1]));
                }
            }
        }
    }
public static void main(String args[]){
    // System.out.println(stairs1(50, new int[51])); 
    System.out.println(mp(2,2));
    int[][] arr = {{1,3,2,5},{4,7,5,1},{8,9,4,18},{1,15,3,2}};
    // System.out.println(mptabu(arr)); 
    mazepath(0, 0, arr.length, arr[0].length, "", arr);
}   
}