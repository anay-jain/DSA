import java.util.Stack;

public class stack{

    public static int nextGreater(int[] arr , int num){
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i =0;i<arr.length;i++){
            int ele= arr[i];
            while(st.size()>0 && ele > st.peek()){
                int rem = st.pop();
                if(rem == num){
                    return ele;
                }
                st.push(ele);
            }
        }
        return -1;
    }
    public int largestRectangleArea(int[] heights) {
        
    }
   

    public int largestRectangleArea(int[] heights) {

        if(heights.length ==0) return 0;
        int max =0;
        Stack<Integer> st = new Stack<>();   
        st.push(-1);
        st.push(0);
        for(int i =1;i<heights.length;i++){
            int secondele =heights[st.peek()];
            if(secondele<heights[i])
                st.push(i);
            else{
                while(st.size()>1 &&  heights[st.peek()]>heights[i]){
                    int h = st.pop();
                    int count = heights[h]*(st.peek()-i-1);
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    
    }
    public int longestValidParentheses(String s) {
        if(s.length() <1) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max=0;
        for(int i=0;i<st.size();i++){
           
           while(st.size()>1 && s.charAt(st.peek()) == '(' && s.charAt(i)== ')'){
               int h = st.pop();
               max = Math.max(max, i-st.peek()-1);
           }
           st.push(i);
        }
        return max;
    }
    public boolean duplicateParanthesis(String s){
        if(s.length()<2) return false;
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            
        }
    }
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);

            }
            else{
                    while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(asteroids[i])){
                        st.pop();
                    }
                    if(st.size()==0 || st.peek()<0){
                        st.push(asteroids[i]);
                    }

            }
        }
        int[] arr = new int[st.size()];
        int i=st.size();
        while(st.size()!=0){
            arr[i--] = st.pop();
        }
        return arr;
    }
    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            int n = (int) (num.charAt(i)-'0');
                    while(st.size()>0 && k>0 && st.peek()>n){
                        st.pop();
                        k--;
                    }
                    st.push(n);
                }
                while(st.size()!=0){
                    
                }
            }
        
            public boolean validateStackSequences(int[] pushed, int[] popped) {
                Stack<Integer> st = new Stack<>();
                int idx=0;
               
             for(int i = 0;i<pushed.length;i++){
                 while(st.peek()==popped[idx]){
                     idx++;
                     st.pop();
                 }
                 st.push(pushed[i]);
             }
             if(idx==popped.length) return true;
             return false;
            }
    public static void main(String[] args) {
        
    }
}