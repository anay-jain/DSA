import java.util.ArrayList;

public class stack01{
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Character> ch = new ArrayList<>();
    public static int priorityseq(char ch ){
        
        if(ch=='+' || ch =='-' ){
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
    public static boolean isch(char ch ){
        if(ch == '+' || ch=='-' || ch =='/' || ch =='%'){
            return true;
        }
        return false;
    }
    public static int calculate(int val1, int val2 , char ch){
        if(ch =='+')return val2+val1;
        else if(ch == '-')return val2-val1;
        else if(ch == '*') return val2*val1;
        else if(ch=='/') return val2/val1;
        else return -1;
    }
    public static void justnextgreaterele(int[] arr){
            
        }
    }
    // Stack st = new Stack()
    public static void main(String[] args){
        String str= "";


    }
}