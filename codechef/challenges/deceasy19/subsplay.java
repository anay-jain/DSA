import java.util.Scanner;
public class subsplay{
    public static Scanner  scn= new Scanner(System.in);
    public static int mcm(int[] arr){
        int[][] memo = new int[arr.length][arr.length];
        for(int gap =0;gap<=arr.length;gap++){
            for(int i =0,j=gap+i;j<=arr.length;i++){
                
            }
        }

    }
    public static int  subs(String a){
        String b =a ;
        int max=0;
        int[][] memo =new int[a.length()+1][a.length()+1];
        for(int i=1;i<a.length()+1;i++)
        {
            for(int j =i+1;j<a.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    memo[i][j]=memo[i-1][j-1]+1;
                
                }
                else{
                    memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
                }
               max = Math.max(max , memo[i][j]);
            }
        }
        return max;
    }

    public static void lcs(String a, String b){
        int[][] memo =new int[a.length()+1][b.length()+1];
        for(int i =1;i<a.length()+1;i++){
            for(int j =1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    memo[i][j]=Math.max(memo[i][j-1], memo[i-1][j]);
                }
                else{
                    memo[i][j]=memo[i-1][j-1]+1;
                }
            }
        }
        display(memo);
    }
    public static void display(int[][] memo){
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){
        int tc = scn.nextInt();
        while(tc!=0){
            int n = scn.nextInt();
            scn.nextLine();
           String s = scn.nextLine();
          System.out.println(subs(s));
          tc--; 
          }
   
    }

}   