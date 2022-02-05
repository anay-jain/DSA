import java.util.Scanner;
public class facedir{
   
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-->0){
            // int n = scn.nextInt();
            int x = scn.nextInt(); 
            String[] l = {"North","East","South","West"};
            int rem = x%4;
            System.out.println(l[rem]);
            

        }
    }
}