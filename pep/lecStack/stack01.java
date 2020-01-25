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
            if(st.peek()== -1 || st.peek()<arr[i]){
                st.push(arr[i]);
            }
            else if(st.peek()>arr[i]){
                // resolve karvana padega kyuki ho ab ele aaya hai vo chota hai 
                while(){
                    // height of 1st pop element -> which will take as refernece kyuki usske aage aur current
                    // element ke beech mei sab bade honge
                    int ht = arr[st.pop()];
                    int idx = st.peek();
                    int area = ht * (i-idx-1);
                    maxarea = Math.max(maxarea, area);

                }
            }

        }
    }
    public static void main(String[] args){
        int[] arr = {1,3,2,4,8,6,5,9,1};
        justPrevGreaterElement(arr);
    }
}