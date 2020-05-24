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
            for(int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            int cons=0;
            int odd =0 , even=0;
            Arrays.sort(arr);
            for(int i=1;i<n;i++){
                if(arr[i-1]+1==arr[i]){
                    cons++;
                    i++;
                }
            }
            for(int i=0;i<n;i++){
                if(arr[i]%2==0){
                    even++;
                }
                else{
                    odd++;
                }
            }
            if(even%2==0 && odd%2==0){
                System.out.println("YES");
                continue;
            }

            if(odd-cons <0 && even-cons <0){
                System.out.println("YES");
                continue;
            }

            if((even-cons)%2==0 && (odd-cons)%2==0) System.out.println("YES");
            else System.out.println("NO");
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