    import static java.lang.Math.*;
    import java.util.*;
    import java.io.*;
    import java.math.*;
    import java.awt.geom.*;

    public class Solution implements Runnable {
        
        public int longestValidParentheses(String str) {
            Stack<Integer> st= new Stack<>();
        st.push(-1);;
        int max=0;
        //so that we can include the index 0 (in between)
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st.push(i);
            }else if(ch==')'){
                if(st.size()>1 && str.charAt(st.peek())=='('){
                    st.pop();
                    int max_ = (i-st.peek());
                    max = Math.max(max , max_);
                }else{
                    st.push(i);
                }
            }
        }
        // int t = st.peek();
        // while(st.size()!=0) 
        // {
        //     int c = st.peek();
        //     if(c==-1) break;
        //     max = Math.max(t-c+1,max);
        //     st.pop();
        // }
        if(max==str.length()) return max-1;
        //    if(st.size()==0) return str.length()-1;
        return str.length();   
        }
        public void solve() throws Exception {
            Scanner scn = new Scanner(System.in);
        
            String s =scn.next();
            System.out.println(longestValidParentheses(s));       

        
        
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