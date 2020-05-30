import java.io.*;
import java.util.*;

class cc{

    public static void main(String[] args) {
      try{
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int arr[] = new int[n];
            arr = in.nextIntArray(n);
            if(check(arr, n)){
              w.println("YES");
            }else{
              w.println("NO");
            }
        }
        w.close();
      }catch(Exception E){
      }
    }