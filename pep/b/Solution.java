import java.io.*;
import java.util.*;

public class Solution {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       double x1=scn.nextDouble();
        double y1 = scn.nextDouble();
        double x2 = scn.nextDouble();
        double y2 = scn.nextDouble();
        double r1 = scn.nextDouble();
        double r2 = scn.nextDouble();
        double d = ((x1-x2)*(x1-x2)) +((y1-y2)*(y1-y2));
        d= Math.sqrt(d);
        double sum = r1+r2;
        
        double diff = r1>r2?r1-r2:r2-r1;
        double mul = (r1+r2)*(r1+r2);
        
         if(d==0 && r1==r2){
            System.out.println("overlaps");
        }
        else if(d == sum ){
            System.out.println("touches at 1 point");
        }
        else if(d<sum && d>diff){
            System.out.println("touches at 2 point");
        }
       
        else if(d==0){
            System.out.println("concentric");
        }else if (d>sum){
           
                System.out.println("far-apart");
            
        }
        else{
            System.out.println("overlaps");
        }
        

        // if(x1 == x2 && y1 == y2 && r1!=r2){
        //     System.out.println("concentric");
        // }
        // else if(d==mul){
        //     System.out.println("touches at 1 point");
        // }
        // else if(mul>d){
        //     System.out.println("touches at 2 point");
        // }
        // else if(mul<d){
        //     System.out.println("far-apart");
        // }
        // else{
        //     System.out.println("overlap");
        // }
    
        
    }
    
}