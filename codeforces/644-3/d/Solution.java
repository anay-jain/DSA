import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class Solution implements Runnable {
    
  
    public void solve() throws Exception {
        int t = sc.nextInt();
        while(t-->0){
            long c= sc.nextLong();
            long p = sc.nextLong();
            boolean flag = false;
            if(c<=p){
                System.out.println(1);
                continue;
            }
            for(int i=2;i<= Math.sqrt(c);i++){
                if(c%i!=0) continue;
                long a = c/i;
                if(a<=p){
                    System.out.println(i);
                    flag=true;
                    break;
                
                }
            }
           if(flag==false) System.out.println(c);
            
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