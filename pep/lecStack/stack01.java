import java.util.ArrayList;

public class stack01{
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> ch = new ArrayList<>();
    public static int priorityseq(char ch ){
        if(ch=='('){
            return 0;
        }
        else if(ch=='+' || ch =='-' ){
            return 1;
        }
        else if(ch=='*' || ch=='/'){
            return 2;
        }
        else if(ch=='%'|| ch == '^'){
            return 3;
        }
        else{
            return 4;
        }
    }
    public static String infixToPostfix(String str){
        

    }
    // Stack st = new Stack()
    public static void main(String[] args){
        String str= "";


    }
}