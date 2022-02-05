import java.util.*;

public class rangeaddition {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static int[] getModifiedArray(int length, int[][] queries) {
        int[] arr = new int[length];
        for(int i=0;i<queries.length;i++){
            int si = queries[i][0];
            int ei = queries[i][1];
            int inc = queries[i][2];
            arr[si] +=inc;
            if(ei<length-1) arr[ei+1]-=inc;

        }
        int ps=0;
        // maintain a prefix sum
        for(int i=0;i<arr.length;i++){
            ps+=arr[i];
            arr[i]=ps;
        }
        return arr;

    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int length = scn.nextInt();

        int nq = scn.nextInt();
        
        int[][] queries = new int[nq][3];

        for(int q = 0; q < nq; q++) {
            queries[q][0] = scn.nextInt();
            queries[q][1] = scn.nextInt();
            queries[q][2] = scn.nextInt();
        }


        int[] res = getModifiedArray(length, queries);

        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}