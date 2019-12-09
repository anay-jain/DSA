public class subsplay{
    public static void lcs(String a, String b){
        int[][] memo =new int[a.length()+1][b.length()+1];
        for(int i =1;i<a.length()+1;i++){
            for(int j =1;j<b.length()+1;j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    memo[i][j]=Math.max(memo[i][j-1], memo[i-1][j]);
                }
                else{
                    memo[i][j]=memo[i-1][j-1]+1;
                }
            }
        }
        display(memo);
    }
    public static void display(int[][] memo){
        for(int i=0;i<memo.length;i++){
            for(int j=0;j<memo[0].length;j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args){
        lcs("abcd", "aecd");
    }

}   