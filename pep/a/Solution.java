import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class Solution implements Runnable {
    
  
    public void solve() throws Exception {
        int n= sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

       System.out.println(hasGroupsSizeX(arr));
    }
    public static int gcd(int a , int b){
        //  euclidian algorithm
                while(a!=b){
                    if(a>b){
                        a = a-b;
                    }
                    else{
                        b= b-a;
                    }
                 
                }
                return a;
            }
          public boolean hasGroupsSizeX(int[] deck) {
                HashMap<Integer,Integer> hm = new HashMap<>();
                // creating a frequency map
                for(int i=0;i<deck.length;i++)
                    hm.put(deck[i],hm.getOrDefault(deck[i], 0)+1);
                // if(hm.size()==1) return true;
                int gcd = hm.remove(deck[0]);
              for (int t : hm.keySet()){
                   int freq = hm.get(t);
                   gcd = gcd(gcd,freq);
                   if(gcd==1) return false;
              }
                return gcd!=1;
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