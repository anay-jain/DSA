import java.util.Scanner;

class b{
    public static int sumDigits(String s){
        int sum =0;
        for(int i =0;i<s.length();i++){
            sum += (s.charAt(i)-'0');
        }
        return sum;
    }
    public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int t= scn.nextInt();
    while(t-->0){
        int n = scn.nextInt();
        int[] points  = new int[2];
        for(int i =0;i<n;i++){
            String a = scn.next();
            String b = scn.next();
            if(sumDigits(a)>sumDigits(b)) points[0]++;
            else if(sumDigits(a)<sumDigits(b)) points[1]++;
            else { points[0]++ ; points[1]++;}
        }
        if(points[0]>points[1]) {System.out.print(0); System.out.println(" " + points[0]); }
        else if (points[1]>points[0]) {System.out.print(1) ;System.out.println(" " + points[1]); }
        else {System.out.print(2);System.out.println(" " + points[0]); }
    
    
    }    
    }
}