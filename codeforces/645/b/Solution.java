import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class Solution implements Runnable {
    
  
    public void solve() throws Exception {
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++) arr[i]=sc.nextInt();
            int count =n;
            int ans =1;
            boolean flag = false;
            Arrays.sort(arr);
            for(int i=n-1;i>=0;i--){
                if(arr[i]<=count){
                    ans = i+2;
                    flag= true;
                    break;
                }
                count--;
            }
            // if(count==1) ans=1;
            System.out.println(ans);
        }

       
    }
 
    static Throwable uncaught;
 
    BufferedReader in;
    FastScanner sc;
    PrintWriter out;
 
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            solve();
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }
 
    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }
 
}
 
class FastScanner {
 
    BufferedReader in;
    StringTokenizer st;
 
    public FastScanner(BufferedReader in) {
        this.in = in;
    }
 
    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
 
    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }
 
    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
 
    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
 
}