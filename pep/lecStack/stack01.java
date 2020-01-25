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
    public static void main(String[] args){
        int[] arr = {1,3,2,4,8,6,5,9,1};
        justPrevGreaterElement(arr);
    }
}