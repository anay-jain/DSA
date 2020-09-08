import java.util.*;
public class sol1{
	public static int solve(int n  , int x ,int[] arr){
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(arr[i]!=-1){
				hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
			}
		}
			int count =0;
			for(Integer i : hm.keySet()){
				if(hm.get(i)>=x){
					count++;
				}
			}

		
		return count;
	}
	public static void main(String[] args){
		int[] arr= {-1,0,0};
		int n = arr.length;
		int x = 1;
		System.out.println(solve(n , x, arr));
	}
}