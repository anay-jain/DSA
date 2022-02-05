import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashSet;
import java.util.List;
import java.util.Collection;

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
    public int trapRainWater_01(int[][] heightMap) {
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

    // sol2 
    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static class pair2 implements Comparable<pair2>{
        int x;
        int y ;
        int val;
        public int compareTo(pair2 o){
            return this.val-o.val;
        }
        pair2(int x , int y , int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }
  public int trapRainWater(int[][] heightMap) {
     
        PriorityQueue<pair2> pq = new PriorityQueue<>();
        int ans =0;
        int n = heightMap.length;
        int m = heightMap[0].length;
      if(n==0 || m==0) return 0;
        // creating a boolean array and pQ
        boolean[][] vis = new boolean[n][m];
        // add all corner elements in PQ
        for(int i=0;i<n;i++){
            pq.add(new pair2(i, 0, heightMap[i][0]));
            pq.add(new pair2(i,m-1,heightMap[i][m-1]));
        }
        for(int j=0;j<m;j++){
            pq.add(new pair2(0, j, heightMap[0][j]));
            pq.add(new pair2(n-1,j,heightMap[n-1][j]));
        }
        while(pq.size()>0){
            pair2 rem = pq.poll();
            vis[rem.x][rem.y]=true;
            for(int i=0;i<dir.length;i++){
            int nx = rem.x+dir[i][0];
            int ny = rem.y + dir[i][1]; 
            if(nx>=0 && nx<n && ny>=0 && ny<m && vis[nx][ny]==false){
                // jisko add karne ja rhe hai vo chota ho skta hai ya bada
                if(heightMap[nx][ny]<rem.val){
                    // because we are ensuring ki side wale bade honge
                    ans+=(rem.val - heightMap[nx][ny]);
                    heightMap[nx][ny]=rem.val;
                    
                }
                // else mei to bas add hi karna tha
                pq.add(new pair2(nx,ny,heightMap[nx][ny]));
            }
            }
            
        }
        return ans;
    }

    // maximum frequency stack LC 895
    class FreqStack {
        HashMap<Integer,Stack<Integer>> hm_freq = new HashMap<>();
        HashMap<Integer,Integer> hm_num = new HashMap<>();
        int maxfreq=0;
        public FreqStack() {
                  
        }
        
        public void push(int num) {
            // sabse phele num to freq ++;
            int freq = hm_num.getOrDefault(num,0)+1;
            hm_num.put(num, freq);
            Stack<Integer> st = hm_freq.getOrDefault(freq,new Stack<>());
            st.add(num);
            hm_freq.put(freq,st);
            maxfreq = Math.max(maxfreq, freq);
        }
        
        public int pop() {
            Stack<Integer> st = hm_freq.getOrDefault(maxfreq,null);
            int rem = st.pop();
            hm_num.put(rem, hm_num.getOrDefault(rem,1)-1);
            if(st.size()==0){
                maxfreq--;
            }
            return rem;
        }
    }

 // sliding window LC 239
 public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;    
        int[] maxleft= new int[n];
        int[] maxright = new int[n];
        // making our leftMax
        for(int i=0;i<n;i++){
            if(i%k==0){
                // on line 
                maxleft[i]=nums[i];
            }else{
                maxleft[i]=Math.max(maxleft[i-1],nums[i]);
            }

        } 
        for(int i=n-1;i>=0;i--){
            if((i+1)%k==0 || i==n-1){
                maxright[i]=nums[i];
            }
            else{
                maxright[i]=Math.max(maxright[i+1],nums[i]);
            }
        }
        for(int i=0;i<n;i++) System.out.print(maxright[i]+ " ");
        // ans dp of length 0 to 
        int[] ans = new int[n-k+1];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=Math.max(maxright[i], maxleft[i+k-1]);
        }
        return ans;
}
class RandomizedSet {
    HashMap<Integer,Integer> hm = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
            if(hm.get(val)==null){
                this.arr.add(val);
                hm.put(val,this.arr.size()-1);
            }
        else{
            return false;
        }
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.get(val)==null){
            return false;
        }
        else{
            int idx=hm.get(val);
            // swap the idx
            int lastidx=arr.size()-1;
            int lastval= arr.get(lastidx);
            // int val = arr.get(idx);
            arr.set(lastidx, val);
            arr.set(idx,lastval);
            arr.remove(lastidx);
            hm.remove(val);

            if(arr.size()==0){
                return true; // it list gets empty
            }
            if(lastidx!=idx)
            hm.put(lastval,idx); // update it with new idx
             
            
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int range = arr.size();
        if(range==0) return 0;
        int randIdx = (int)Math.floor(Math.random()*range);
        return arr.get(randIdx);
        
    }
}


// LC 381 

class RandomizedCollection {
    HashMap<Integer,HashSet<Integer>> hm = new HashMap<>();
    ArrayList<Integer> arr = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        // here we also can new 
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int size = arr.size()-1;
        // abhi tak ka size;
        arr.add(val);
        HashSet<Integer> ht = hm.getOrDefault(val, new HashSet<>());
        // if(ht.size()>0){
        //     if(ht.contains(size+1)) return false;
        // }
        ht.add(size+1);
        hm.put(val,ht);
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)==true){
            // vo val konse index par aa rhi h usme se koi ek.
            HashSet<Integer> remhs = hm.get(val);
            int remidx=-1;
            for(Integer i: remhs){
                remidx=i;
                break;
            }
            // getting last index and last value
            int lastidx = arr.size()-1;
            int lastval = arr.get(lastidx);
            // swapping last idx and remidx in array list

            arr.set(lastidx, val);
            arr.set(remidx,lastval);
            // now chaging the idx accordingly in hashmap.
              HashSet<Integer> lasths = hm.get(lastval);
            lasths.remove(lastidx);
            lasths.add(remidx);
            arr.remove(lastidx);
             remhs.remove(remidx);
            if(lastidx==remidx || remhs.size()==0){
                // same last idx;
               
               if(remhs.size()==0) hm.remove(val);
               return true;
            }
            // chainging lastidx
          
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int range = arr.size();
        if(range==0) return 0;
        int randIdx = (int)Math.floor(Math.random()*range);
        return arr.get(randIdx);
        
    }
}

 // k sorted array
 public static int[] ksortedarray(int[] arr , int k){
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // i+k+1 = n-1;
    int n = arr.length;
    int[] ans = new int[n];
    // o ke lie phele hi chala lenhe
    k= n>k?k:n-1;
    for(int i=0;i<=k;i++){
        pq.add(arr[i]);
    }
    ans[0]=pq.remove();
    int t=0;
    for(int i =k+1;i<n;i++){
        pq.add(arr[i]);
        int top = pq.remove();
        t=i-k;
        ans[t] = top;
    }
    
    while(pq.size()>0){
        int top = pq.remove();
        t+=1;
        ans[t] =top;
    }
    return ans;
 }

  // length of longest substring
  public static int lengthlongestsubsting(String s){
    int n= s.length();
    HashMap<Character,Integer> hm = new HashMap<>();
    // acquired and release
    int start =0,end=0;
    int ans=1;
    for(int i=0;i<n;i++){
      char ch = s.charAt(i);
      if(hm.containsKey(ch)==false){
          // acquired as equation is statisfied
          hm.put(ch, 1);
      }
      else{
          // start release
          while(s.charAt(start)!=ch){
              hm.remove(s.charAt(start));
              start++;
          }
          // start is at point where it is equal
          // hm.remove(s.charAt(start));
          start++;
      }
      end=i;
      ans= Math.max(ans,end-start+1);
    }
    return ans;
}
// leetcode 914
public static int gcd(int a , int b){
    //  euclidian algorithm
            while(a!=b){
                if(a>b){
                    a = a-b;
                }
                else{
                    b= b-a;
                }
             
            }
            return a;
        }
      public boolean hasGroupsSizeX(int[] deck) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            // creating a frequency map
            for(int i=0;i<deck.length;i++)
                hm.put(deck[i],hm.getOrDefault(deck[i], 0)+1);
            // if(hm.size()==1) return true;
            int gcd = hm.remove(deck[0]);
          for (int t : hm.`()){
               int freq = hm.get(t);
               gcd = gcd(gcd,freq);
               if(gcd==1) return false;
          }
            return gcd!=1;
        }
        // 954 brickwall
        public int leastBricks(List<List<Integer>> wall) {
            HashMap<Integer,Integer> hm = new HashMap<>();
            int max=0;
            for(int i=0;i<wall.size();i++){
             int ans =0;
                for(int j=0;j<wall.get(i).size()-1;j++){
                    ans+=wall.get(i).get(j);
                    hm.put(ans , hm.getOrDefault(ans, 0)+1);
                    max = Math.max(max, hm.get(ans));
                    // System.out.println(max+" ");
                }
            }
           return wall.size()-max;
        }
        public int numRabbits(int[] answers) {
            HashMap<Integer,Integer> hm = new HashMap<>();
           int ans=0;
            for(int i=0;i<answers.length;i++){
                if(answers[i]==0){
                    ans+=1;
                    continue;
                }
                hm.put(answers[i], hm.getOrDefault(answers[i], 0)+1);
            }
          
            for(int key : hm.keySet()){
                int val = hm.get(key);
                double a = (val*1.0)/(key+1);
                double tmp=(Math.ceil(a));
                ans+=(tmp*(key+1));
            }
            return (int)ans;
        }
        // public static class coord implements Comparable<coord>{
        //     int x;
        //     int y;
        //     double d;
        //     coord(int x , int y ,double d){
        //         this.x=x;
        //         this.y=y;
        //         this.d=d;
        //     }
        //     public int compareTo(coord o){
        //         return -(this.d-o.d);
        //     }
        // }
        // public int[][] kClosest(int[][] points, int K) {
            
            
        // }
        // public int[][] kClosest(int[][] points, int K) {
        
        // }
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
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