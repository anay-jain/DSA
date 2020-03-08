import java.util.Scanner;

public class gh{
    static Scanner scn = new Scanner(System.in); 
    static int binomialCoeff(int n, int k)  
    { 
      
        // Base Cases 
        if (k == 0 || k == n) 
            return 1; 
          
        // Recur 
        return binomialCoeff(n - 1, k - 1) +  
                    binomialCoeff(n - 1, k); 
    } 
   public static void que( char[][] arr){
        int n = arr.length;
        int ans =0;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(arr[i][j]!='.'){
                    count++;
                }
            }
            if(count>=3){
                ans+=binomialCoeff(count,3);
            }

        }
        for(int i=0;i<n;i++){
            int count =0;
            for(int j=0;j<n;j++){
                if(arr[j][i]!='.'){
                    count++;
                }
            }
            if(count>=3){
                ans+=binomialCoeff(count,3);
            }

        }
        int count =0;
        for(int i=0, j=0;i<n;i++,j++){
            if(arr[j][i]!='.'){
                count++;
            }
        }
        if(count>=3){
            ans+=binomialCoeff(count,3);
        }
        count =0;
        for(int i=0, j=n-1;j>=0;i++,j--){
            if(arr[i][j]!='.'){
                count++;
            }
        }
        if(count>=3){
            ans+=binomialCoeff(count,3);
        }
        System.out.println(ans);

    }
    public static void main(String[] args){
        int t = scn.nextInt();
        while(t!=0){
            int n = scn.nextInt();
            char[][] arr = new char[n][n];
            String s="";
            scn.nextLine();
            for(int i =0;i<n;i++){
                // System.out.println(i);
                     s  =scn.nextLine();
                     for(int j=0;j<s.length();j=j+2){
                        arr[i][j/2]=s.charAt(j);
                     }       
            }

            que(arr);
            t--;
        }
    }
}