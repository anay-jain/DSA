import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class Solution implements Runnable {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a , int[] b)->{
            return b[1] - a[1];
        });
        for(int i = 0;i<stations.length;i++){
            if(startFuel<stations[i][0]){
                while(!queue.isEmpty()&&startFuel<stations[i][0]){
                    startFuel += queue.remove()[1];
                    res++;
                }
                if(queue.isEmpty()&&startFuel<stations[i][0])return -1;
            }
            queue.add(stations[i]);
        }
        while(!queue.isEmpty()&&startFuel<target){
            startFuel+=queue.remove()[1];
            res++;
        }
        if(queue.isEmpty()&&startFuel<target)return -1;
        return res;
        
    }
    
    public void solve() throws Exception {
        int d = sc.nextInt();
        int start = sc.nextInt();
        int no = sc.nextInt();
        int[][] dist = new int[no][2];
      
        for(int i =0;i<no;i++) dist[i][0]=sc.nextInt();
        for(int i =0;i<no;i++) dist[i][1]=sc.nextInt();
        System.out.println(minRefuelStops(d, start, dist));
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