import java.util.*;

public class pattern2{
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args){
        int a = scn.nextInt();
        pattern(a);

    }
    public static void pattern(int n){
        for(int i=1;i<=n;i++){
            int res=1 , nsp=(n-i)*2;
            for(int call=1;call<n*2;call++){
                if(call<=i){
                   
                    System.out.print(res);
                    res++;
                    
                }
                if(call>i && call <(i+nsp)){
                    System.out.print(" ");

                }
                if(call >= (i+nsp)){
                    
                    if(res==n+1){
                        res-=1;
                    }
                    else{
                    res-=1;
                
                    System.out.print(res);
                    }
                    
                }
            }
            System.out.println("");
        }
       

    }

}