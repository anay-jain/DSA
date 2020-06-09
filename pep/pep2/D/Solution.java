import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MaxRangeQueries solver = new MaxRangeQueries();
        // int testCount = Integer.parseInt(in.next());
        
            solver.solve(1, in, out);
        out.close();
    }

    static class MaxRangeQueries {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int count =0;
            Debug debug = new Debug();
            int n = in.nextInt();
            int K = in.nextInt();
            int m = in.nextInt();
            int[][] queries = new int[n][];

            int[] a = new int[100011];
            for (int i = 0; i < K; ++i) {
                int L = in.nextInt() - 1;
                int R = in.nextInt() - 1;
                queries[i] = new int[]{L, R};
                a[L] += 1;
                a[R + 1] -= 1;
            }
            for (int i = 1; i < a.length; ++i) a[i] += a[i - 1];

            int[] countKadd1 = new int[a.length];
            int[] countK = new int[a.length];
            for (int i = 0; i < a.length; ++i) {
                if (a[i] == K) ++countK[i];
                if (a[i] == K + 1) ++countKadd1[i];
                if (i != 0) {
                    countK[i] += countK[i - 1];
                    countKadd1[i] += countKadd1[i - 1];
                }
            }
            int sum = countK[a.length - 1];
            int ans = -1;
//        debug.tr(ans);
            for (int i = 0; i < n; ++i) {
                int L = queries[i][0] - 1;
                int R = queries[i][1];

                int kc = countK[R];
                if (L >= 0) kc -= countK[L];

                int k1c = countKadd1[R];
                if (L >= 0) k1c -= countKadd1[L];
//            debug.tr(L + 2, R + 1, kc, k1c, sum - kc + k1c);
                ans =  sum - kc + k1c;
              
                if(ans==m){
                    count++;
                }
            }
            out.println(count);
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String next() {
            return nextString();
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String nextString() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = pread();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class Debug {
        PrintWriter out;
        boolean oj;
        long timeBegin;
        Runtime runtime;

        public Debug(PrintWriter out) {
            oj = System.getProperty("ONLINE_JUDGE") != null;
            this.out = out;
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

        public Debug() {
            oj = System.getProperty("ONLINE_JUDGE") != null;
            OutputStream outputStream = System.err;
            this.out = new PrintWriter(outputStream);
            this.timeBegin = System.currentTimeMillis();
            this.runtime = Runtime.getRuntime();
        }

        public void finalize() {
            out.flush();
            out.close();
        }

    }
}