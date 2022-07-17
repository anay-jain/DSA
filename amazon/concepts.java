import java.util.*;

public class concepts{
    public static class pair{
        int a ;
        int b ;
        pair(int a, int b){
            this.a =a ;
            this.b=b;
        }

    }

    public static void main(String[] args) {
        // default is of min type
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return a-b;
            // b-a for making max
        });
    }
    public static void sortFn(){
        Integer[] arr = {1,2,9,52,23,456,23};
        Arrays.sort(arr, (a,b) ->{
            // max type
            return b-a;
        });
    }
}