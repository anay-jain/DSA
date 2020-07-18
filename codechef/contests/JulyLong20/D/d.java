import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class d {
    
    
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            int n = scn.nextInt();
            HashMap<Integer,ArrayList<Integer>> hmx = new HashMap<>();
            HashMap<Integer, ArrayList<Integer>> hmy = new HashMap<>();
            for(int i =0;i<n;i++){
                int x = scn.nextInt();
                int y = scn.nextInt();
                ArrayList<Integer> arr = hmx.getOrDefault(x, new ArrayList<>());
                ArrayList<Integer> arr1 = hmy.getOrDefault(y, new ArrayList<>());
                arr.add(y);
                arr1.add(X);
                hmx.put(x, arr);
                hmy.put(y,arr1);
                }
                
        }
    }
}