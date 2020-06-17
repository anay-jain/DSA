import java.util.Scanner;
class Solution{
	public static void solve(int[] arr,int[] bucket, int n, int q , int one , int two, int bs){

		if(q==1){
			// query
			query(arr, bucket ,one , two ,bs);
		}
		else{
			update(arr, bucket, one , two , bs);
		}
}	
		
	
	
	public static void query(int[] arr, int[] bucket , int li , int ri, int bs ){
		int sum =0;
		int n =bucket.length;
		while(li%bs!=0 && li<=ri){
			sum+=arr[li++];  
		}
		while(li+bs<=n){
			sum+=bucket[li/bs];
			li+=bs;
			
		}
		while(li<=ri){
			sum+=arr[li++];
		}
		
		
	}
	public static void update(int[] arr, int[] bucket , int idx , int val, int bs ){
		bucket[idx/bs] += (val-arr[idx]);
			arr[idx]=val;
	}
	public static void main(String[] args){
 Scanner scn = new Scanner(System.in);
	int t = scn.nextInt();
	while(t-->0){
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]= scn.nextInt();
}
		int bs = (int)Math.sqrt(n)+1;
		int[] bucket = new int[bs];
		for(int i =0 ;i<n;i++){
			bucket[i/bs] +=arr[i];
		}
		int q = scn.nextInt();
		while(q-->0){
			int type = scn.nextInt();
			int one =  scn.nextInt();
			int two =  scn.nextInt();
			solve(arr, bucket, n , type , one , two ,bs);
	for(int i=0;i<bs;i++){
	System.out.print(bucket[i]+" ");
}
			
						
		}
		
	}	
	}
}