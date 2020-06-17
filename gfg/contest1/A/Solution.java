import java.util.Scanner;
import java.util.*;
public class Solution {
    static class Pair {
        int value;
        int count;

        Pair(int value, int count) {
           this.value = value;
           this.count = count;
       }
    }

public static void mostOccurrences(int[] array, int k) {
    Map<Integer, Pair> occurrences = new HashMap<>();
    for(int element : array) {
        int count = 1;
        Pair pair = new Pair(element, count);
        if(occurrences.containsKey(element)) {
            pair = occurrences.get(element);
            pair.count++;
        }
        else {
            occurrences.put(element, pair);
        }
    }

    List<Pair> pairs = new ArrayList<>(occurrences.values());
    pairs.sort(new Comparator<Pair>() {
        @Override
        public int compare(Pair pair1, Pair pair2) {
            int result = Integer.compare(pair2.count, pair1.count);
            if(result == 0) {
                return Integer.compare(pair2.value, pair1.value);
            }
            return result;
        }
    });

    int[] result = new int[k];
    for(int i = 0; i < k; i++) {
        Pair pair = pairs.get(i);
        result[i] = pair.value;
    }

    for(int i=0;i<k;i++){
        System.out.print(result[i]+" ");
    }
    System.out.println();
    // System.out.println(Arrays.toString(result));

}

public static void main(String [] arg)
{
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    while(t-->0){
    int n = scn.nextInt();
    int[] array = new int[n];
    for(int i=0;i<n;i++){array[i] = scn.nextInt();}
    int k = scn.nextInt();
  
 
    
    Solution.mostOccurrences(array, k);
    }
  
}
}