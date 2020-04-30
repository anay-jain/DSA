import java.util.PriorityQueue;
import java.util.Scanner;
public class HashMapQuestions {
    // Rearrange characters in a string such that no ajacent are same
    class pair1 implements Comparable<pair1>{
        char ch ;
        int freq=0;
        @Override
        public int compareTo(pair1 o){
            return this.freq-o.freq;
        }
    }
    public static boolean noAdjacentSame(String s){
        // creating a freq map
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[(int)s.charAt(i)-'a']++;
        }
        PriorityQueue<pair1> pq = new PriorityQueue<>();
        
    }
    public static void main(String[] args){
     Scanner scn = new Scanner(System.in);
    //  int t = scn.nextInt();
    //      while(t-->0){
    //          int n = scn.nextInt();
    //      }
    
    // System.out.println(kpalindromic("abccba"));
    
    }
}