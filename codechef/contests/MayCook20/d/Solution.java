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
        if((n & (n-1)) == 0) {
            System.out.println(-1);
            return;
        }

        // counting the total no of vertices that will be contained in the group
        // dividing a ranfe in to n pieces => (L+R)/n
        // total no of groups will be. as the no of set bits in n
        long cost =0;
        for(int i=1;i<n;i<<=1){
            long v = (n+i)/(i<<1);
            cost+=(v-1)*i;
        }
        // connecting all groups together
        // 2+4+..+ 2^(log N).. GP
        ans += (i-2);
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