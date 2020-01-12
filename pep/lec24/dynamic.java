import java.util.Scanner;
public class dynamic{
    
    static int[][] mul(int[][] F , int [][] M){
        int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0]; 
        int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1]; 
        int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0]; 
        int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1]; 
        
        F[0][0] = x; 
        F[0][1] = y; 
        F[1][0] = z; 
        F[1][1] = w;
        return F;
    }
    static int[][] apower2(int[][] F , int b){
        int[][] idn={{1,1},{1,0}};
        if(b==1){
            return idn;
        }
        // int[][] idn={{1,1},{1,0}};
         apower2(F, b/2);
        // ans = mul(F, idn);
        return (b%2)==0?mul(F,F):mul(mul(F,F),idn);
    }
    public static int targetjumpstabu(int n){
        int[]  memo = new int[n+1];
        memo[0]=1;
        for(int i =1;i<memo.length;i++){
            for(int j=1;j<7;j++){
                if(i-j>=0){
                    memo[i]+=memo[i-j];
                }
            }
        }
        return memo[n]; 
       }
       public static int targetjumpsmemo(int[] memo , int n ){
            if(n==0){
                return memo[0];
            }   
            if(memo[n]!=0){
                return memo[n];
            }
            int count=0;
            for(int i =1;i<7;i++){
                if(n-i>=0){
                    count+= targetjumpsmemo(memo, n-i);
                //    System.out.println(count);
                }
            }
            memo[n]=count;
            return memo[n];
       }
       static int callsdp=0, callsrec=0,classaddhidp=0;
       public static int mp_memo(int sr , int sc , int er , int ec , int[][] memo){
           callsrec++;
           if(sr==er && sc==ec){
               return 1;
               
           }
           if(memo[sr][sc]!=0){
               System.out.println("dp lagi h bc ");
               return memo[sr][sc];
           }
           classaddhidp++;
           if(memo[sc][sr]!=0){ // only valid for square matrix
               System.out.println("ulta");
               return memo[sc][sr];
           }
           callsdp++;
           if(sr<er){
               memo[sr][sc]+=mp_memo(sr+1, sc, er, ec, memo);
           }
           if(sc<ec){
               memo[sr][sc]+=mp_memo(sr, sc+1, er, ec, memo);
           }
        return memo[sr][sc];
       }
       public static int multimp( int er , int ec , int[][] dp){
           dp[er-1][ec-1]=1;
          // we handled 4 areas by adding an extra dimension so we dont need 4 areas
        
               for(int i=er-1;i>=0;i--){
                for(int j=ec-1;j>=0;j--){
                    for(int jumps =1;jumps<er;jumps++){
                    if(j+jumps<=ec)
                    dp[i][j]+=dp[i][j+jumps];
                    if(i+jumps<=er)
                    dp[i][j]+=dp[i+jumps][j];
                    if(i+jumps<=er&& j+jumps<=ec)
                    dp[i][j]+=dp[i+jumps][j+jumps];
                }
               }
           }
           return dp[0][0];
       }
       public static void input(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println(":s");
            }
        }
       }
       public static void display(int[][] arr ){
           for(int i=0;i<arr.length;i++){
               for(int j=0;j<arr[0].length;j++){
                   System.out.print(arr[i][j]+" ");

               }
               System.out.println(" ");
           }
       }
       public static int costinmp(int[][] arr){
        int er = arr.length-1 , ec=arr[0].length-1;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i=arr.length-1;i>=0;i--){
            for(int j =arr[0].length-1;j>=0;j--){
                if(i==er && j==ec){
                    dp[i][j]=arr[er][ec];
                }
                else if(i==er){
                    dp[i][j]=dp[i][j+1]+arr[i][j];
                }
                else if(j==ec){
                    dp[i][j]=dp[i+1][j]+arr[i][j];
                }
                else{
                    dp[i][j]= arr[i][j]+ Math.min(dp[i+1][j],dp[i][j+1]);
                }
                
            }
         
        // System.out.println(dp[0][0]);
       }   display(dp);
        return dp[0][0];

        }
        public static void minimumjumps(int[] arr ){
            int[] memo = new int[arr.length];
            for(int i=arr.length-2;i>=0;i--){
                int min=10000;
                if(arr[i]==0){
                    memo[i]=10000;
                }
                for(int j=i+1;j<arr[i]+i+1 && j<arr.length;j++){
                //    System.err.println("f");
                   
                        min = Math.min(memo[j], min);
                    
                }
                memo[i]=min+1;
                System.out.print(memo[i]+" ");
                
            }
            System.out.println(memo[0]);
        }
        
        public static int longestpalisubs(String str){
            int[][] memo = new int[str.length()][str.length()];
            for(int gap=0;gap<str.length();gap++){
                for(int i=0,j=gap;j<str.length();i++,j++){
                    if(gap==0){
                        memo[i][j]=1;
                    }
                    else if(gap==1 && str.charAt(i)==str.charAt(j)){
                        memo[i][j]=2;
                    }
                    else if(str.charAt(i)==str.charAt(j)){
                          
                    }
                    else{
                       memo[i][j]= Math.max(memo[i+1][j],memo[i][j-1])+2;
                    }
                }
            }
            return memo[0][str.length()-1];
        }
        public static int singlepairup(int n){
            int[] memo = new int[n+1];
            memo[0]=1;memo[1]=1;
            for(int i=2;i<memo.length;i++){
                memo[i]=memo[i-1]+memo[i-2]*(i+1);
                // System.out.print(memo[i]+" ");
            }
            return memo[n];
        }
        public static void displaymethod(int[][] memo){
            for(int i =0;i<memo.length;i++){
                for(int j=0;j<memo[0].length;j++){
                    System.out.print(memo[i][j]+" ");
                }
                System.out.println("");
            }
        }
      
        public static void  lcs(String a , String b ){
            int[][] memo = new int[a.length()+1][b.length()+1];
            for(int i = a.length()-1 ; i>=0;i--){
                for(int j=b.length()-1 ; j>=0;j--){
                    if(a.charAt(i)==b.charAt(j)){
                        memo[i][j]= memo[i+1][j+1]+1;

                    }
                    else{
                        memo[i][j]= Math.max(memo[i+1][j], memo[i][j+1]);
                    }
                }
            }
            displaymethod(memo);
        }      
        public static void distinctsubseq(String word , String subseq){
            int[][] memo = new int[word.length()+1][subseq.length()+1];
            memo[word.length()][subseq.length()]=1;
            for(int i=word.length()-1;i>=0;i--){
                for(int j=subseq.length();j>=0;j--){
                    if(j== subseq.length()){
                        memo[i][j]=1;
                    }
                    else{
                        if(word.charAt(i)==subseq.charAt(j)){
                            memo[i][j]= memo[i+1][j+1]+memo[i+1][j];
                        }
                        else{
                            memo[i][j]=memo[i+1][j];
                        }
                    }
                }
            }
            displaymethod(memo);
        }  
        static int callslis01=0;
        public static int lis01(int[] arr){
            int[] dp = new int[arr.length];
            for(int i=1;i<arr.length;i++){
                for(int j =0;j<i;j++){
                    callslis01++;
                    if(arr[i]>arr[j]){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
            }
            return dp[arr.length-1];
        }
        public static int lis02(int[] arr ){
            int si =0;
            int li = arr.length;
            int mid =(si+arr.length)/2;
            while(si<=li){

            }
        }
        public static int  distinct(String word, String ans){
            int count =0;
            
            count+= distinct(word.substring(1), ans+word.charAt(0));
            count+=distinct(word.substring(1), ans);
            return count;
        }
        // public static int knapsack01(int[] arr , int target ){
        //     int[][] memo =new int[target+1][2];
        //     int idx=0;
        //     int size = arr.size;
        //     while(size!=0){
        //     int first  = idx%2;
        //     for(int i =0;i<=target;i++){
        //         if(memo[i][])
        //         memo[i][1]=Math.max(memo[i][0], memo);
        //     }
        //     idx++;
        //     size--;
        // }
        // }
       public static void main(String[] args){
        // int[][] idn={{1,1},{1,0}};
        // int[][] newans  = apower2(idn,5);
        // System.out.println(newans[0][1]);
        // System.out.println(targetjumpstabu(5));
        // int[] memo = new int[6];
        // memo[0]=1;
        // System.out.println(target,jumpstabu(5));
        // System.out.println(targetjumpsmemo(memo , 5));
        // int er =4,ec=4;
        // int[][] memo = new int[er+1][ec+1];
    //    System.out.println( mp_memo(0, 0, er, ec, memo));
        // System.out.println(callsdp+ " " + classaddhidp+" and" + callsrec);
        // int[][] arr= {{2,3,0,4},{0,6,5,2},{8,0,3,7},{2,0,4,2}};
        // System.out.println(costinmp(arr));
        // System.out.println(multimp( er, ec, memo));
        // // display(memo);
        // int[] arr1 = {1,3,0,4,0,0,2,1,1,0};
        // minimumjumps(arr1);
        // System.out.println(longestpalisubs("babad"));
        // System.out.println(singlepairup(5));
        // distinctsubseq("geeksforgeeks", "gks");        
        // lcs("abcd", "abed");
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        System.out.println(lis01(arr)+" "+ callslis01);
    }
    
}