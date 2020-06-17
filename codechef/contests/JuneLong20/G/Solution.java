    import static java.lang.Math.*;
import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

public class Solution implements Runnable {
   static  int max =3;
    public boolean fn (int[] arr , int level){
        if(level >3){
            return false;
        }
        if(completed){
            max = Math.min(level, max);
        }
        ArrayList<Integer> count = new ArrayList<>();
        for(int f=0;f<8;f++){
            int c= 0 ;
            int k =f;
            while(k>=0){
                if(((k&1) ==1 ) && arr[c]!=ans[c]){
                    count.add(c);
                }
                c++;
                k>>=1;
            }
        
        long min=1;
       long diff =0;
     boolean flagdiff = true;
        if(count.size()>2){
            min = ans[count.get(0)]/arr[count.get(0)];
            diff = ans[count.get(0)]-arr[count.get(0)];
            for(int i=1;i<count.size();i++){
                min = Math.min(ans[count.get(i)]/arr[count.get(i)],min);
            }
        }
    

      }
        for(int i=0;i<3;i++){
            if(ar[i]==true && (arr[i]-ans[i])!=0){
                if(count.size()==0) {
                    min=Math.floor(ans[i]/arr[i]);
                    count.add(i);
                
    }
                count.add(i);
                min = Math.min(min,arr[i]/ans[i]) ;
            }
        }
        if(count.size() >1 && min!=-1){
          for(Integer i:count){
              arr[i]*=min;
          }
        }
        if(count==1){
            arr[i]=ans[i];
        }
        bool completed = true;
        for(int i=0;i<3;i++){
            if(ans[i]!=arr[i]) completed = false;
        }

    }

    }
    public void solve() throws Exception {
        int t = sc.nextInt();
        while(t-->0){
           int n = sc.nextInt();
            int[] arr = new int[n+1];
            for(int i =1;i<=n;i++) arr[i]=sc.nextInt();
            int count =0;
            int[] b = new boolean[n+1];

            for(int i=1;i<=n;i++){
                if(arr[i]==i){
                    b[i]=true;
                }

            }
            
            // if(count ==0 ) System.out.println("YES");
            if(count){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        
       

       
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