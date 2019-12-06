import java.util.ArrayList;
public class dp{
    public static void main(String[] args){
        // System.out.println(mazepath_dp(3, 3));
        // int[] coins = {2,3,5}
        //  System.out.println(coin_Change_dp_combi(coins, 7));
        // int[] costs={0,3,5,6,15,10,25,12,24};
        // System.out.println(rod_cutting(costs));
        int[] costs={10,22,33,1,2,68,40,60,1};
        int[] coins={10,22,9,33,21,50,41,60,80};
        int[] jumps={3,0,2,2,0,4,0,3,1,2,0,1};
        // minimumjumps(jumps);
        int[] coins1={2,3,5,6,1};
        int[] wts = {2,5,1,3,4};
        int[] price = {15,14,10,45,30};
        int capacity=7;
    //    System.out.println(targetpossible(coins1, 17)); 
        // System.out.println(longestincreasingsubsequence(coins));
        // System.out.println(maximumcommonsequence("abcd", "aecd"));
        System.out.println(eggdrop(7, 2));
    }
    public static int fibo_memo(int n, int[] strg){
        if(n==0 || n==1){
            return n;
        }
        if(strg[n]!=0){
            return strg[n];
        }
        strg[n]=fibo_memo(n-1,strg)+fibo_memo(n-2,strg);
        return strg[n];
        
    }
    public static int fibo_tabu(int n){
        int[] strg = new int[n+1];
        strg[0]=0;
        strg[1]=1;
        for(int i=2;i<=n;i++){
            strg[i]=strg[i-1]+strg[i-2];
        }
        return strg[n];
    }
    public static int mazepath_dp(int er , int ec){
        // divide array into 4 areas .
      // and we dont have any cost matrix
        int[][] mp = new int[er+1][ec+1];
        mp[er][ec]=1;
        for(int i=mp.length-1;i>=0;i--){
            for(int j=mp[0].length-1;j>=0;j--){
                // we will use area here .
                if(i==mp.length-1 && j==mp.length-1){
                    mp[i][j]=1;

                }else if(i==mp.length-1){
                    mp[i][j]=1;
                }
                else if(j==mp[0].length-1){
                    mp[i][j]=1;
                }
                else{
                    mp[i][j]=mp[i+1][j]+mp[i][j+1];
                }
            }
        }
        return mp[0][0];
    }
    // public static int mazepath_costdp(int[][] arr){
    //     int[][] mini = new int[arr.length][arr[0].length];
    //     for(int i=arr.length-1;i>-0;i--){
    //         for(int j=arr.length-1;j>=0;j--){
    //             // area 1
    //             if(i==arr.length-1 && j==arr[0].length-1){
    //                  mini[i][j]=arr[i][j];
    //             }
    //         }
    //     }
    // }

    public static int coin_Change(int[]  coins ,  int target){
        if(target<0){
            return 0;
        }
        if(target==0){
            return 1;
    
        }
        
        int count=0;
        for(int i=0;i<coins.length;i++){
            count += coin_Change(coins, target-coins[i]);
        }
        return count ;
    }
    public static int coin_Change_dp_combi(int[]  coins ,  int target){
        int[] memo = new int[target+1];
        memo[0]=1;
        
        
       
            for(int coin: coins){
                for(int i=0;i<memo.length;i++){
            if(coin<=i){
                memo[i]+= memo[i-coin];
            }
        }
        }
        return memo[target] ;
    }
    public static int rod_cutting(int[] costs){
        int[] memo = new int[costs.length];
        int max=0;
        for(int i=0;i<costs.length;i++){
            // int length=i;
            memo[i] = costs[i];
            for (int j =0;j<i;j++){
                
                    // memo[i]+=costs[j];
                    // memo[i] = Math.max(costs[i-j] ,costs[j]);
                    max= memo[j]+memo[i-j];
                    memo[i] = Math.max(max , memo[i]);
            }
        }
        for(int i : memo){
            
            if(max<i){
                max=i;
            }
        }
        return max;
    }
    public static int longestincreasingsubarray(int[] costs){
        int[] memo = new int[costs.length];
        int max=0;
        for(int i =0;i<costs.length-1;i++){
            if(costs[i]<costs[i+1]){
                memo[i]=memo[i-1]+1;
            }
            else{
                memo[i]=1;
            }
        }
        for(int i : memo){
            
            if(max<i){
                max=i;
            }
        }
        return max;
    }
    public static int longestbitonicsubsequence(int[] costs){
        int[] memoincreasing = new int[costs.length];
        int[] memodecresing = new int[costs.length];
        int max=0;
        memoincreasing[0]=1;
        memodecresing[costs.length-1]=1;
        
         
        for(int i =1;i<costs.length;i++){
            if(costs[i-1]<costs[i]){
                memoincreasing[i]=memoincreasing[i-1]+1;
            }
            else{
                memoincreasing[i]=1;
            }
            
        }
        
            // int tempmax= Math.max(memoincreasing[i-1]+memodecresing[i],memoincreasing[i]+memodecresing[i-1]);
            // if(max<memoincreasing[i]+memodecresing[i]-1){
            //     max=memoincreasing[i]+memodecresing[i]-1;
            // }
        
            for(int i=costs.length-1;i>0;i--){   
                if(costs[i-1]>costs[i]){
                    memodecresing[i-1] =memodecresing[i]+1;
                }
                else{
                    memodecresing[i-1]=1;
                }
                max = Math.max(max,memoincreasing[i]+memodecresing[i]-1);
            }
        // for(int i : memo){
            
        //     if(max<Math.abs(i)){
        //         max=Math.abs(i);
        //     }
        // }
        return max;
    }
    public static int longestincreasingsubsequence(int[] coins){
        int[] memo = new int[coins.length];
        // memo[0]=1;
        int max=0;
        for(int i =0;i<coins.length;i++){
            memo[i]=1;
            for(int j =i-1;j>=0;j--){
                // if(coins[i]<coins[j]){
                    if(coins[i]>coins[j])
                    memo[i] = Math.max(memo[i],memo[j]+1);
                  
                // }
            }
            System.out.print(memo[i]+" ");
            
            max=Math.max(max, memo[i]);
        }

        

        return max;
    }

    public static void minimumjumps(int[] jump){
        int[] memo = new int[jump.length];
        for(int i=jump.length-1;i>=0;i--){
            if(jump[i]==0){
                memo[i]=100000;
            }
            
            int min=10000;
            for(int j = 1;j<=jump[i];j++){
                if((i+j)<jump.length){

                    memo[i]=Math.min(memo[i+j], min)+1;
                }
               
            }
            System.out.print(memo[i]+" ");
        }
        
    }
    public static boolean targetpossible(int[] coins , int target){
        boolean memo[][] = new boolean[coins.length][target+1];
        memo[0][0]=true;
        memo[0][coins[0]]=true;
        for(int i=1;i<coins.length;i++){
            memo[i][0]=true;
            for(int j=1;j<=target;j++){
                if(memo[i-1][j]==true){
                    memo[i][j]=true;
                }
                if(memo[i-1][j]==false){
                    
                    if(j>coins[i] && memo[i-1][j-coins[i]]==true){
                            memo[i][j]=true;
                    }
                    
                }

            }
        }
        return memo[coins.length-1][target];
    }
    public static int knapsack(int[] price , int[] weights , int capacity){
        int[] memo = new int[capacity+1];
        for(int i=0;i<capacity+1;i++){
            for(int j=0;j<weights.length;j++){
                if(i>=weights[j]){
                    memo[i] =  Math.max(memo[i], price[j]+memo[i-weights[j]]);
                }
            }
        }

        return memo[capacity];

    }
    public static int maximumcommonsequence(String a , String b){
        int[][] memo = new int[a.length()+1][b.length()+1];
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    memo[i][j]= memo[i-1][j-1]+1;
                }
                else{
                    memo[i][j]=Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[a.length()][b.length()];
    }
    public static int longestpalidromicsubstring(String a , String b){
        int[][] memo = new int[a.length()+1][b.length()+1];
        for(int i=1;i<a.length()+1;i++){
            for(int j=1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    memo[i][j]= memo[i-1][j-1]+1;
                }
                else{
                    memo[i][j]=Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[a.length()][b.length()];
    }
    // public static int countoflongestpalidromicsubs(String a){
    //     int[][] memo = new int[a.length()][a.length()];
    //     for(int gap=0;i<a.length();i++){
    //         for()
    //     }
    // }

    public static int eggdrop(int floors , int eggs){
        
        int[][] memo = new int[eggs+1][floors+1];
        for(int i=1;i<memo.length;i++){
            for(int j=0;j<=floors;j++){
                
                if(i==1){
                    memo[i][j]=j;
                }
                else if(j==0||j==1){
                    memo[i][j]=j;
                }
                else{
                    
                    int min= Integer.MAX_VALUE;
                    for(int k=1;k<=j;k++){
                        int max = Math.max(memo[i][j-k],memo[i-1][k-1]);
                        if(max<min){
                            min=max;
                            min=min+1;
                        }
                    }
                    memo[i][j]=min;
                }
            }
        }
        return memo[eggs][floors];
    }

 
}