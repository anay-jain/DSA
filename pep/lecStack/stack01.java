import java.util.Stack;

public class stack01{
    public static  void  justPrevGreaterElement(int[] arr){
        // creating a new stack
        Stack <Integer> st = new Stack<>();
        // st.push(arr[0]);
        for(int i=0;i<arr.length;i++){
        while(st.size()!=0 && st.peek()<arr[i]){
        // < -> just next greater ele on left , > for lesser
            st.pop();
        }
        if(st.size()==0){
            System.out.println(arr[i] + "-> " + -1);
        }else{
            System.out.println(arr[i] + "-> " + st.peek());
        }
    st.push(arr[i]);

    }

    }
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
    //---- Maximal Rectangle Leetcode-85----------------------------------------------------
    public static int maxRectangle(char[][] arr ){
        int maxarea = 0;
        int[] ar = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                ar[j]= arr[i][j]=='0'?0:(1+ar[j]);
            }
            maxarea =Math.max(largestareainrectangle(ar), maxarea);
        }
        return maxarea;
    }
    // ----  Min stack 185 LC ---------------------------------------------------------------
    class MinStack {
        Stack<Integer> st = new Stack<>();
        int minsf = 0;
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if(st.size()==0){
            st.push(x);
            minsf=x;
            return;
            // taki phir se add na karde
        }
        if(x<minsf){
            st.push(2*x-minsf);
            minsf=x;
        }
        else{
            st.push(x);
        }
    }
    
    public void pop() {
        if(st.size()==0){
            return ;
        }
        int ele = st.pop();
        if(ele<minsf){
            minsf = 2*minsf-ele;
        }
    }
    
    public int top() {
        if(st.size==0){
            return -1;
        }
        // st is not minstack type , it is of min type
        if(st.peek()<minsf){
            return minsf;
        }
        else return st.peek();
    }
    
    public int getMin() {
        return minsf;
    }
}
//-------Balance brackets----------------------------------------------------------------------

   public static void main(String[] args){
        // int[] arr = {1,3,2,4,8,6,5,9,1};
        // justPrevGreaterElement(arr);
    
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestareainrectangle(arr));
        
    }
}