import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

public class stackQuestions {
    class pair implements Comparable<pair>{
        int dist=0;
        float time=0;
        pair(int dist , float time){
            this.dist = dist;
            this.time= time;
        
        }
        @Override
        public int compareTo(pair o){
            return this.dist - o.dist;
        }
    }

    // implement queue using stack LC 232--------- 
    class MyQueue {

        Stack<Integer> st= new Stack<>();
           Stack<Integer> st1= new Stack<>();
        /** Initialize your data structure here. */
        public MyQueue() {
        //    Stack<Integer> st = new Stack<>(); 
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            st.push(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(st.size()==0){
                return -1;
            }
            // Stack<Integer> st1 = new Stack<>();
            reverse(st,st1);
            int temp = st1.peek();
            st1.pop();
            reverse(st1,st);
            return temp;
        }
        
        /** Get the front element. */
        public int peek() {
             if(st.size()==0){
                return -1;
            }
            // Stack<Integer> st1 = new Stack<>();
            reverse(st,st1);
            int temp = st1.peek();
            reverse(st1,st);
            return temp;
            
            
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return st.size()==0;
            
            
        }
        public void reverse(Stack<Integer> st1, Stack<Integer> st2){
            while(st1.size()>0){
                int temp = st1.peek();
                st1.pop();
                st2.push(temp);
            }
        }
        

    }
    //implementing stack using queue LC 225
    class MyStack {
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> que1 = new LinkedList<>();
        int top=-1;
        /** Initialize your data structure here. */
        public MyStack() {
            
        }
        
        /** Push element x onto stack. */
        public void push(int x) {
        que.add(x);
            top =x;
        }
        
        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(que.size()>1){
                top = que.remove();
                que1.add(top);
            }
            int rm = que.remove();
            Queue<Integer> temp = que;
            que=que1;
            que1=temp;
            return rm;
        }
        
        /** Get the top element. */
        public int top() {
            return top;
        }
        
        /** Returns whether the stack is empty. */
        public boolean empty() {
            
            return que.size()==0;
            
        }
    }
    // remove outermost string LC 1021
    public String removeOuterParentheses(String s) {
        int ob=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' && ob++ > 0) ans+=ch;
            if(ch==')' && ob-- > 1) ans+=ch;
        }   
        return ans;
    }

    // longest valid paranthesis -- LC 32 -------------------------------------------------
    public int longestValidParentheses(String str) {
        Stack<Integer> st= new Stack<>();
       st.push(-1);;
       int max=0;
       //so that we can include the index 0 (in between)
       for(int i=0;i<str.length();i++){
           char ch = str.charAt(i);
           if(ch=='('){
               st.push(i);
           }else if(ch==')'){
               if(st.size()>1 && str.charAt(st.peek())=='('){
                   st.pop();
                   int max_ = (i-st.peek());
                   max = Math.max(max , max_);
               }else{
                   st.push(i);
               }
           }
       }
       return max;   
       }
       // largest rectange in histo LC -84
       public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int maxarea=0;
        st.push(-1);
        // bcs  to hm 0 se bhi between maan ske 
        for(int i =0;i<arr.length;i++){
            if(st.peek()== -1 || arr[st.peek()]<arr[i]){
                st.push(i);
            }
            else {
                // resolve karvana padega kyuki ho ab ele aaya hai vo chota hai 
                while(st.peek()!=-1 && arr[st.peek()]>=arr[i]){
                    // height of 1st pop element -> which will take as refernece kyuki usske aage aur current
                    // element ke beech mei sab bade honge
                    int ht = arr[st.pop()];
                    int idx = st.peek();
                    int area = ht * (i-idx-1);
                    // System.out.println(ht+" "+i+ " "+ idx);
                    maxarea = Math.max(maxarea, area);   
                    
            }     
            st.push(i);
        }
        // System.out.print(maxarea+ " ");
    }
        // jab ar khtm hogya tab bi kuch ele stack mei bacheve honge
        while(st.peek()!=-1 ){
            int ht = arr[st.pop()];
            int idx = st.peek();
            int area = ht * (arr.length-idx-1);
            maxarea = Math.max(maxarea, area);
        }
        return maxarea;
    }
    // Maximal Rectangle Leetcode 85----------------------------------------------------------------
    public static int largestareainrectangle(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxarea=0;
        st.push(-1);
        // bcs  to hm 0 se bhi between maan ske 
        for(int i =0;i<arr.length;i++){
            if(st.peek()== -1 || arr[st.peek()]<arr[i]){
                st.push(i);
            }
            else {
                // resolve karvana padega kyuki ho ab ele aaya hai vo chota hai 
                while(st.peek()!=-1 && arr[st.peek()]>arr[i]){
                    // height of 1st pop element -> which will take as refernece kyuki usske aage aur current
                    // element ke beech mei sab bade honge
                    int ht = arr[st.pop()];
                    int idx = st.peek();
                    int area = ht * (i-idx-1);
                    // System.out.println(ht+" "+i+ " "+ idx);
                    maxarea = Math.max(maxarea, area);   
                    
            }     
            st.push(i);
        }
        // System.out.print(maxarea+ " ");
    }
        // jab ar khtm hogya tab bi kuch ele stack mei bacheve honge
        while(st.peek()!=-1 ){
            int ht = arr[st.pop()];
            int idx = st.peek();
            int area = ht * (arr.length-idx-1);
            maxarea = Math.max(maxarea, area);
        }
        return maxarea;
    }
    public int maximalRectangle(char[][] arr) {
        if(arr.length==0){
            return 0;
        }
         int maxarea = 0;
        int[] ar = new int[arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                ar[j]= arr[i][j]=='0'?0:(1+ar[j]);
            }
            maxarea =Math.max(largestareainrectangle(ar), maxarea);
        }
        return maxarea;
    }
    // next greater on right-------------------------------------------------------------------------
    public int[] ngor(int[] arr){
        int n = arr.length;
    
        Stack<Integer> st = new Stack<>();
        // we will store index in stack
        int[] arr1= new int[n];
        for(int i =0;i<n;i++){ //for(int i=n-1;i>=0;i--) -> ngol
            while(st.size()!=0 && arr[st.peek()]<arr[i]){ // for right <  , for left >
                int temp = st.peek();
                st.pop();
                arr1[temp]=arr[i];

            }
            st.push(i);

        }
        return arr1;
    }
    // next greater element 1 LC 496 ----------------------------------------------------------
    static HashMap<Integer,Integer> hm = new HashMap<>();
    public void  ngor_(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        // we will store index in stack
      
        for(int i =0;i<n;i++){ //for(int i=n-1;i>=0;i--) -> ngol
            while(st.size()!=0 && arr[st.peek()]<arr[i]){ // for right <  , for left >
                int temp = st.peek();
                st.pop();
                hm.put(arr[temp], arr[i]);

            }
            st.push(i);

        }
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        hm.clear();
            ngor_(nums2);
            int[] arr = new int[nums1.length];
            for(int i=0;i<nums1.length;i++){
                int temp= hm.getOrDefault(nums1[i], -1);
                arr[i]=temp;

            }
            return arr;
    }


    // next greater elelemt 2 LC 503----------------------------------------------------------
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int m = 2*n;
         Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=-1;
        }
        for(int i=0;i<m;i++){
            int t = i%n;
            while(st.size()!=0 && nums[st.peek()]<nums[t]){
                int rem = st.peek();
                st.pop();
                arr[rem]=nums[t];
            }
            st.push(t);
            
        }
        return arr;
    }


    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        ArrayList<pair> arr = new ArrayList<>();
        for(int i =0;i<n;i++){
            int temp = target-position[i];
            float rem = temp/speed[i];
            arr.add(new pair(temp, rem));
        }
        Collections.sort(arr);
        float max=0;
        int count=0;
        for(int i=n-1;i>=0;i--){
            if(max<arr.get(i).time){
                max=arr.get(i).time;
                count++;
        }

        }
        return count;
        
    }
    // Leetcode Gas Station -----------------------------------------------------
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gpetrol =0;
        int gdist=0;
        int n = gas.length;
        int petrol =0;
        int dist=0;
        int temp=-1;
        for(int i=0;i<n;i++){
            petrol+=gas[i];
            dist+=cost[i];
            if(petrol<dist){
                temp=i;
                petrol=dist=0;
                
            }
            gpetrol+=gas[i];
            gdist+=cost[i];
        }
        if(gpetrol>=gdist){
            return temp+1;
        }
        else{
            return -1;
        }
        
    }
    // trapping rain water LC 42-- 2 approaches---------------------------------------------------------
    public int trap(int[] height) {
        int n = eight.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max =-1;
        for(int i=0;i<n;i++){
            if(height[i]>max){
                
                max = height[i];
            }
            left[i]=max;
        }
        max = -1;
        for(int i = n-1 ;i>=0;i--){
            if(height[i]>max){
                max= height[i];
            }
            right[i]=max;
        }
        int water=0;
        for(int i=0;i<n;i++){
            water+=(Math.min(left[i],right[i])-arr[i]);
        }
        return water;
    }
    // int trap(vector<int> &arr)
    // {
    //     stack<int> st;
    //     int water=0;
    //     for(int i=0;i<arr.size();i++){
    //         while(st.size()!=0 && arr[i]>=arr[st.top()]){
    //             int h=arr[st.top()]; st.pop();
    //             if(st.size()==0) break;
    
    //             int oh=min(arr[st.top()],arr[i])-h;
    //             water+=oh*(i-st.top()-1);
    //         }
    //         st.push(i);
    //     }
    
    //     return water;
    // }
    // asteroid collision Leetcode -735
     // in cpp 
     /* 
     vector<int> asteroidCollision(vector<int>& asteroids) {
      stack<int> st;
        for(int i=0;i<asteroids.size();i++){
            int ele = asteroids[i];
                if( ele>0){
                    st.push(ele);
                    
                }
            else{
                while(st.size()>0 && st.top()>0 &&  st.top()< -(ele)){
                    st.pop();
                }
                if(st.size()!=0 && st.top() == -ele){
                    st.pop();
                }
                else if(st.size()==0 || st.top() <0){
                    st.push(ele);
                }
            }
                
            
        }
        vector<int> arr(st.size(),0);
        int t=st.size()-1;
        while(st.size()>0){
            int ele= st.top();
            arr[t]=ele;
            t--;
            st.pop();
        }
        return arr;
    }*/
    public static void main(String[] args){

    }
}