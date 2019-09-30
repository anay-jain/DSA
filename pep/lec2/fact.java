import java.util.Scanner;

public class fact{

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args){
        int n = scn.nextInt();
        int r = scn.nextInt();
        int ans=1,nfact=1,rfact=1,nrfact=1;
        for(int i=1;i<=n;i++){
            ans*=i;
            if(i==r){
                rfact=ans;
                
            }
            if(i==(n-r)){
                nrfact = ans;
            }
            if(i==n){
                nfact=ans;
            }
        }
        int permut = nfact/nrfact;
        int comb = nfact/(nrfact*rfact);
        System.out.println(nfact);
        System.out.println(permut);
        System.out.println(comb);
        
        
    }
    
}