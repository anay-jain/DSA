import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class posspew{
   public static int[] solve(int[] arr , int k){
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
           
            arr = solve(arr, k);
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
            }


                    }
    }
}