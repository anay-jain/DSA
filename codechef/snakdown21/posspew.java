import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class posspew{
    public static int solve(int[] arr , int k){
        int n = arr.length;
        boolean temp = true;
        // to check the edge condition -- of every element is 0
        for(int i= 0;i<n;i++){
            if(arr[i]!=0) temp = false;
        }
        if(temp == true) return 0;
        int lc = -1;
        int[] track = new int[n];
        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                lc=0;
                track[i]=0;
            }
            else if(lc==-1){
                track[i]=Integer.MAX_VALUE;

            }
            else{
                lc++;
                track[i]=lc;
            }

        }
        // now iterating through right.
        int rc=Integer.MAX_VALUE;
        for(int i =0;i<n;i++){
            if(arr[i]!=0){
                rc=0;
            }
            else if(arr[i]==0 && rc!=Integer.MAX_VALUE){
                rc++;
               track[i] = Math.max(rc, track[i]);
           } 
        }
        int count =0;
        for(int i=0;i<n;i++){
            count += (arr[i] + Math.max(0, 2*(k-track[i])));
        }
        return count;
    }
   public static int[] solve1(int[] arr , int k){
       int n = arr.length;
       HashMap<Integer,Integer> hm = new HashMap<>();
       for(int i=0;i<n;i++){
       if(arr[i]>0){
           hm.put(i, arr[i]);
       }
    }
       if(hm.size()==0) return arr;
      
       for(int j=0;j<k;j++){
        Set<Integer> s = hm.keySet();
           for (int key : s){ 
            //    System.out.println(key);
            int key1 = key;
                   int less = (int)(key1-1)%n;
                   int more = (int)(key1+1)%n;
                   System.out.println(more);
                   hm.put(less, hm.getOrDefault(less, 0)+1);
                   hm.put(more, hm.getOrDefault(more, 0)+1);   
           }
       }
       for(int key:hm.keySet()){
           arr[key] = hm.get(key);
       }
       return arr;

   }
    

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            int k= scn.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
            }
           
            System.out.println(solve(arr, k)); 
            


                    }
    }
}

/*

7 8 9 1 2 3 4 5 6


arr[i] = 3  4  5  1  2 
i =      0  1  2  3  4
unroated 1  2  3  4  5


*/