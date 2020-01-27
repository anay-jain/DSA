import java.util.Stack;

public class stack01{
   
    // ------ INFIX EVALUATION ---------------------------------------------------------------
    public static int precedence(char ch ){
        if(ch == '+' || ch  == '-'){
            return 1;
        }
        else if(ch == '*' || ch == '/'){
            return 2 ;
        }
        else  if(ch == '^'){
            return 3;
        }
        else{
            return -1;
        }
}
public static int calculate(char ch , int val1 , int val2){
    if(ch == '+'){
        return val1+val2;

    }
    else if(ch == '-'){
        return val2-val1;
    }
    else if(ch == '*'){
        return val2*val1;

    }
    else if(ch == '/'){
        return val2/val1;
    }
    else if(ch == '^'){
     return (int) Math.pow(val2, val1);
    }
    else{
        return -1;
    }
}
    public static int infixeval(String str){
        Stack<Integer> num = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            //  cant be    if (ch >= '0' && ch <= '9')
            if(ch-'0' >=0 && ch-'0'<=9){ // this means it is a single dight num
                // System.out.print(ch+" ");
                num.push(ch-'0');
            }else if(ch=='('){
                operatorStack.push(ch);
            }else if(ch == ')'){
                while(operatorStack.size()>0 && operatorStack.peek()!='('){
                    int val1= num.pop();
                        int val2 = num.pop();
                        char ch1 =  operatorStack.pop();
                        int ans = calculate(ch1, val1, val2);
                        num.push(ans);
                }
                if(operatorStack.size()>0){
                    operatorStack.pop();
                }else{
                    return -1;
                }
                    

            }
            else{
                if(operatorStack.size()==0){
                    operatorStack.push(ch);
                }
                else {
                    // resolve condition
                    while(operatorStack.size()>0 &&operatorStack.peek()!='(' && precedence(ch)<=precedence(operatorStack.peek())){
                        int val1 = num.pop();
                        int val2 = num.pop();
                        int ans = calculate(operatorStack.pop(), val1, val2);
                        num.push(ans);
                    }
                    operatorStack.push(ch);
            }
        }
        }
        while(operatorStack.size()>0){
            int val1 = num.pop();
            int val2 = num.pop();
            int ans = calculate(operatorStack.pop(), val1, val2);
            num.push(ans);
        }
        return num.peek();
    }

    // -- Just previous greater element -------------------------------------------------------------
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
    // INFIX TO POSTFIX EVALUATION-----------------------------------------------------------
    



    // Largest area in rectangle------------------------------------------------------------
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
            for(int j =0;j<arr[0    ].length;j++){
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
        if(st.size()==0){
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
    public static boolean isopench(char ch ){
        if(ch =='(' || ch == '{' || ch=='[')
        return true;
        return false;
    }
    public static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch  = s.charAt(i);
            if(isopench(ch)){
                st.push(ch);
            }
            else{
                if(ch==')' && st.peek()==')'){
                    st.pop();
                }
                else if(ch == '}' && st.peek()=='{'){
                    st.pop();
                }
                else if(ch == ']' && st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }

        }
     return st.size()==0;
    }
//----- longest valid parenthesis -------------------------------------------------------
public static int largestvalidParenthesis(String str){
    Stack<Integer> st= new Stack<>();
    st.push(-1);;
    int max=0;
    //so that we can include the index 0 (in between)
    for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        if(ch=='('){
            st.push(i);
        }else if(ch==')'){
            if(st.size()>0 && str.charAt(st.peek())=='('){
                st.pop();
                int max_ = (i-st.peek());
                // ismme -e ahi hoga kiyuki we have to include the last one too.
                max = Math.max(max , max_);
            }else{
                st.push(i);
            }
        }
    }
    return max;
    }   
// ---- Remove unnecessary brackets------------------------------------------------------------------\
static  String str = "[{((a+b))+(c+d)}]";
    public static void removebracket(int idx1 , int idx2){
        
        str = str.substring( 0, idx1) +'$'+ str.substring(idx1+1);
        str = str.substring(0, idx2) +'$'+ str.substring(idx2+1);
        // System.out.println(idx1+ " " + idx2+ " " +str);
    }
    public static void removeUnnecessaryBrackets(){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(isopench(ch)){
                st.push(i);
            }else if(ch == ']' || ch == '}' || ch==')'){
                if(ch == ']'){
                    if(st.peek()==-1){
                        st.pop();
                        if(str.charAt(st.peek())=='['){ st.pop();
                        }else{
                            System.out.println("invalid");
                       return ;
                   }
                    }
                    else{
                        if(str.charAt(st.peek())=='['){
                            int idx1 = st.pop();
                            removebracket( idx1, i);
                            }else{
                                System.out.println("invalid");

                           return ;
                       }
                    }
                   
                }
                else if(ch == '}'){
                    if(st.peek()==-1){
                        st.pop();
                        if(str.charAt(st.peek())=='{'){ st.pop();
                        }else{
                            System.out.println("invalid");

                       return ;
                   }
                    }
                    else{
                        if(str.charAt(st.peek())=='}'){
                            int idx1 = st.pop();
                            removebracket( idx1, i);
                            }else{
                                System.out.println("invalid");

                           return ;
                       }
                    }
                   
                }else if(ch == ')'){
                    if(st.peek()==-1){
                        st.pop();
                        if(str.charAt(st.peek())=='('){ st.pop();
                        }else{
                       
                       System.out.println("invalid");
                        return ;
                   }
                    }
                    else{
                        if(str.charAt(st.peek())=='('){
                            int idx1 = st.pop();
                            removebracket( idx1, i);
                            }else{
                           
                           System.out.println("invalid");
                            return ;
                       }
                    }
                   
                }
                
            }
            else{
                if(st.peek()!=-1){
                    st.push(-1);
                }
            }
        }
        return ;
    }

   public static void main(String[] args){
            //  myStack stack = new myStack();
            dynamicStack stack = new dynamicStack();

            for(int i =0;i<50;i++){
                stack.push(i);
            }
            stack.print();
            // stack.push(-1);
            // stack.print();
        // int[] arr = {1,3,2,4,8,6,5,9,1};
        // justPrevGreaterElement(arr);
    
        // int[] arr = {2,1,5,6,2,3};
        // System.out.println(largestareainrectangle(arr));
        // System.out.println(largestvalidParenthesis("()(()"));
        // removeUnnecessaryBrackets();
        // for(int i=0;i<str.length();i++){
        //     if(str.charAt(i)!='$') System.out.print(str.charAt(i));
        // }
        // System.out.println(str);
            // String s = "8+4*3-9/3^(2-1)";
            // System.out.println(infixeval(s)); 
    }

}