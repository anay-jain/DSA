import java.util.Scanner;
public class b {
        public static int solve(int n ){
            int count =0;
                for(int i =1;i<=Math.sqrt(n)+1;i++){
                    if(n%i==0)
                    if(((n/i)/10)==0){
                        if((n/i) == i) count++;
                        else count+=2;
                    }
                }
               return count;
        }
        public static void main(String[] args){
            Scanner scn = new Scanner(System.in);
                int t = scn.nextInt();
                // int sqr = Math.sqrt(n);
                
                for(int n =1;n<=t;n++){
                int count =0;
                for(int i =1;i<=Math.sqrt(n)+1;i++){
                    if(n%i==0)
                    if(((n/i)/10)==0){
                        if((n/i) == i) count++;
                        else count+=2;
                    }
                }
                System.out.println(count);
            }
        }
}