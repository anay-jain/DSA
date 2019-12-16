public class dprevise{
    public static void display(boolean[][] arr ){
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    public static int stairsproblem(int n , int[] coins){
        int[] memo= new int[n+1];
        memo[0]=1;
        for(int i=0;i<n+1;i++){
            for(int s:coins){
                if(i-s>=0){
                    memo[i] +=  memo[i-s];
                }
            }
            
        }
        return memo[n];
    }
    public static int rodcutting(int[] arr){
        int memo[]= new int[arr.length];
        for(int i=1;i<arr.length;i++){
            memo[i]=arr[i];
            for(int j=i-1;j>0;j--){
                memo[i]=Math.max(memo[i],memo[i-j]+memo[j]);
            }
        }
    return memo[memo.length-1];
    }
    
    public static int longestincreasingsubarray(int[] arr){
        int[] memo = new int[arr.length];
        int max=0;
        memo[0]=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                memo[i] = memo[i-1]+1;
                max = Math.max(max, memo[i]);
            }
            else{
                memo[i]=1;
            }
        }
        return max;
    }
    public static int bitonicsubsequence(int[] arr){
        int[] memoinc = new int[arr.length];
        int[] memodec = new int[arr.length];
        memoinc[0]=1;
        memodec[arr.length-1]=1;
        int max=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                memoinc[i]=memoinc[i-1]+1;
            }
            else{
                memoinc[i]=1;
            }
        }
        for(int i=arr.length-2;i>=0;i--){
           
            if(arr[i]>arr[i+1]){
                memodec[i]= memodec[i+1]+1;
            }
            else{
                memodec[i]=1;
            }
            // System.out.print(memodec[i]+" ");
            max = Math.max(max, memoinc[i]+memodec[i]-1);
        }
        return max;
    }
    public static int longestincreasingsubsequence(int[] arr){
        int[] memo = new int[arr.length];
        int max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<=i-1;j++){
                if(arr[i]>arr[j]){
                    memo[i]= Math.max(memo[i],memo[j]+1);
                }
                max = Integer.max(max , memo[i]);
            }
        }
        return max;
        
    }
    public static void mcm(int[] arr){
        int[][] memo = new int[arr.length-1][arr.length-1];
        for(int gap =0;gap<=arr.length-1;gap++){
            for(int i =0,j=gap+i;j<arr.length-1;j++,i++){
                if(gap==0){
                    memo[i][j]=0;
                }
                else if(gap==1){
                    memo[i][j]=arr[j]*arr[j-1]*arr[j+1];
                }
                else{
                memo[i][j] = Integer.MAX_VALUE;
                for(int k =i;k<j;k++){
                    
                    memo[i][j]=Math.min(memo[i][j],memo[i][k]+memo[k+1][j]+(arr[i]*arr[j+1]*arr[k+1]));
                }
            }
            }
        }
        
         

    }
    public static int countoflongestpalidromicsubsequence(String s){
        int[][] memo= new int[s.length()][s.length()];
        for(int gap=0;gap<memo.length;gap++){
            for(int i=0,j=gap+i;j<memo.length;i++,j++){
                if(gap==0){
                    memo[i][j]=1;
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        memo[i][j]=3;
                    }
                    else{
                        memo[i][j]=2;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                    memo[i][j]= memo[i][j-1]+memo[i+1][j]+1;
                    }
                    else{
                        memo[i][j]=memo[i][j-1]+memo[i+1][j]-memo[i+1][j-1];
                    }
                }
            }
        }
        // display(memo);
        return memo[0][memo[0].length-1];
    }
    public static int longestpalidromicsubsequence(String s){
        int[][] memo= new int[s.length()][s.length()];
        for(int gap=0;gap<memo.length;gap++){
            for(int i=0,j=gap+i;j<memo.length;i++,j++){
                if(gap==0){
                    memo[i][j]=1;
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        memo[i][j]=2;
                    }
                    else{
                        memo[i][j]=1;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                    memo[i][j]= memo[i+1][j-1]+2;
                    }
                    else{
                        memo[i][j]=Math.max(memo[i+1][j-1],Math.max(memo[i+1][j],memo[i][j-1]));
                    }
                }
            }
        }
        // display(memo);
        return memo[0][memo[0].length-1];
    }
    public static int minimumjumps(int[] arr){
        int[] memo = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            memo[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<arr.length;i++){
        memo[0]=0;
            for(int j=1;j<=arr[i];j++){
                if(i+j<arr.length){
                    memo[i+j]=Math.min(memo[i+j], memo[i]+1);
                }
            }
            System.out.print(memo[i]+"  ");
        }
        return memo[arr.length-1];
    }
    public static void targetquestion(int[] arr,int target){
        boolean[][] memo = new boolean[arr.length+1][target+1];
        memo[0][0]=true;
      
            for(int j=0;j<=target;j++){
                for(int i=1;i<=arr.length;i++){
                if(memo[i-1][j]==true){
                    memo[i][j]=true;
                  
                }
                else if((j-arr[i-1])>=0 && memo[i-1][j-arr[i-1]]==true){
                    memo[i][j] = true;
                    
                }
            }
        }
        display(memo);
    }
    private static void targetSum(int[] arr, int t) {
		boolean[][] strg = new boolean[arr.length+1][t + 1];
		 for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				if (i == 0 && j == 0) {
					strg[i][j] = true;
				} else if (i == 0) {
					strg[i][j] = false;
				} else if (j == 0) {
					strg[i][j] = true;
				} else {
					if (strg[i - 1][j] == true) {
						strg[i][j] = true;
					} else if (j >= arr[i - 1] && strg[i - 1][j - arr[i - 1]] == true)
					//ask about strg[i-1][j-arr[i-1]==true
					{
						strg[i][j] = true;
					}
				}
			}
        }
        display(strg);
		System.out.println(strg[strg.length - 1][strg[0].length - 1]);
	}

    public static void main(String[] args){
        // int[] coins={2,3,5};
        // System.out.println(stairsproblem(7, coins));
        // int[] arr={0,3,5,6,15,10,25,12,24};
        // int[] arr ={10,22,9,33,21,50,41,60,80};
        // System.out.println(rodcutting(arr));
        // System.out.println(longestincreasingsubsequence(arr));
        // System.out.println(longestincreasingsubarray(arr));
        // int[] coins={10,22,9,33,21,50,41,60,80};
        // int[] coins={10,22,33,1,2,68,40,60,1};
        // int[] jumps={3,0,2,2,0,4,0,3,1,2,0,1};
        // System.out.println(minimumjumps(jumps));
        // System.out.println(bitonicsubsequence(coins));
        // System.out.println(longestpalidromicsubsequence("babad"));
        int[] arr = {2,3,5,6,1};
        targetquestion(arr, 12);
        System.out.println("--------------------------------------------------");
        targetSum(arr,12);
    }
}