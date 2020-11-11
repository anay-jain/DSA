public class sol{


    public static void p2(int n){
        int space=0;
        char c = 'A';
        for(int i=0;i<n;i++){
            c='A';
            for(int j=0;j<space;j++){
                System.out.print(" ");
                c++;
                
            }
            for(int j =0;j<(n-space);j++){
                System.out.print(c);
                c++;
            }
            System.out.println();
            if(i < n/2){
                space+=2;
            }else{
                space-=2;
            }

        }
    }
    public static void p5(int n){
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            int x = n-i;
            for(int j=0;j<n;j++){
                if(j>i-1){
                arr[i][j]=x;
                arr[j][i]=x;
                }
            }
        
        }   
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        p5(1000);
    }
}