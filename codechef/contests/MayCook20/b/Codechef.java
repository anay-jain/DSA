/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static Scanner scn = new Scanner(System.in);
    public static boolean isvalid(String arr , int x, int y ){
        int j = (x+y)/2 +1;
        // if(y-x<2) return false;
        for(int i=x;i<=(x+y)/2;i++){
            // System.out.println(i+" "+j);
            if(arr.charAt(i)!=arr.charAt(j)){
                return false;
            }
            j++;
        }
        return true;
    }
    public static void solve(String arr){
        int count=0;
      for(int j=arr.length()-2;j>1;j-=2){
        if(isvalid(arr, 0, j-1)==true && isvalid(arr, j, arr.length()-1)==true) count++;
      }
      System.out.println(count);
    }
	public static void main (String[] args) throws java.lang.Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String arr = br.readLine().trim();
            solve(arr);

        }
	}
}
