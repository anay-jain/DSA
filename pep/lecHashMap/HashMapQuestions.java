import java.util.Scanner;
public class HashMapQuestions{
    public static boolean kpalindromic(String s){
        // finding LPS
        int n=s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0]=true;
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j))
                         dp[i][j]=true;
                }
                else if (s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                }
            
            }
        }
        return dp[0][n-1];
    }
    // longest palindromic substring  (AXIS METHOD)
    public static int lps_03(String s){
        int n = s.length();
        int axis=1;
        for(int i=1;i<n-1;i++){
            
            if

        }
    }
    public static void main(String[] args){
     Scanner scn = new Scanner(System.in);
    //  int t = scn.nextInt();
    //      while(t-->0){
    //          int n = scn.nextInt();
    //      }
    
    System.out.println(kpalindromic("abccba"));
    }
}