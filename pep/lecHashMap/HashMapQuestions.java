import java.util.PriorityQueue;
import java.util.Scanner;
public class HashMapQuestions {
    // Rearrange characters in a string such that no ajacent are same
    public static class pair1 implements Comparable<pair1>{
        char ch ;
        int freq=0;
        @Override
        public int compareTo(pair1 o){
            return -(this.freq-o.freq);
        }
        pair1(char ch , int freq){
            this.ch = ch;
            this.freq = freq;
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
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(new pair1((char)('a'+i),freq[i]));
            }
        }
        pair1 prev = pq.poll();
        prev.freq--;
        while(pq.size()>0){
            pair1 rem = pq.poll();
            if(prev.freq>0) pq.add(prev);
            rem.freq--;
            prev=rem;
            // System.out.print(rem.ch);
        }
        return prev.freq==0 ;
    }

    // Trapping rain water LC-42

    public int trap(int[] height) {
        int n= height.length;
        // finding left max from 0 to i-1;
       if(n==0 || n==1) return 0;
        int[] leftMax = new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }    
        int[] rightMax = new int[n];
        rightMax[n-1]=height[n-1];
        for(int i= n-2;i>=0;i--){
            rightMax[i]=Math.max(rightMax[i+1], height[i]);
        }
        int ans=0;
        for(int i=1;i<n-1;i++){
            int temp =(Math.min(leftMax[i-1], rightMax[i+1]) -height[i]);
            if(temp>0){
                ans+=temp;
            }
        }
        return ans;
    }

    // Trapping rain water LC 407
    public int trapRainWater(int[][] heightMap) {
        int ans=0;
        for(int t=1;t<heightMap.length-1;t++){
            int[] height = heightMap[t];
            int n = height.length;
            int[] leftMax = new int[n];
            leftMax[0]=height[0];
            for(int i=1;i<n;i++){
                leftMax[i]=Math.max(leftMax[i-1],height[i]);
            }    
            int[] rightMax = new int[n];
            rightMax[n-1]=height[n-1];
            for(int i= n-2;i>=0;i--){
                rightMax[i]=Math.max(rightMax[i+1], height[i]);
            }
          
            for(int i=1;i<n-1;i++){
                int temp =(Math.min(leftMax[i-1], rightMax[i+1]));
                int temp2 =Math.min(heightMap[t-1][i],heightMap[t+1][i]);
                int temp3=Math.min(temp,temp2);
                temp = temp3-heightMap[t][i];

                if(temp>0){
                    ans+=temp;
                }
            }
        }
        return ans;
        
    }
    public static void main(String[] args){
     Scanner scn = new Scanner(System.in);
    //  int t = scn.nextInt();
    //      while(t-->0){
    //          int n = scn.nextInt();
    //      }
    System.out.println(noAdjacentSame("geeksforgeeks"));
    
    // System.out.println(kpalindromic("abccba"));
    
    }
}