import java.util.ArrayList;
public class returntype{

    public static void main(String[] args){
        // ArrayList <String> ans = subseq("ABC");
        // for(String s: ans){
        //     System.out.print(s + " ");
        // }
            System.out.println(removeHi("hidsahdioshdiashihihdhasihd"));
    }

    public static ArrayList <String> subseq(String word){
        if(word.length()==0){
            ArrayList <String> base = new ArrayList<> ();
            base.add(" ");
            return base;
        }
        char ch = word.charAt(0);
        String ros = word.substring(1);

        ArrayList <String> recAns = subseq(ros);
        // at every recusrive iteration we are making a new array and copying values to it thorugh addall fn
        ArrayList <String> finalans = new ArrayList<>();
        finalans.addAll(recAns);
        for(String s: recAns){
            finalans.add(ch+s);
        }
        return finalans;
    }
    public static String removeHi(String word){
        // make a string which will store all non Hi 
        if(word.length()==0){
            return "";
        }
        
        // base case;
       
        if((word.length()>1) && (word.charAt(0)=='h') &&(word.charAt(1)=='i')){
            String ans = word.substring(2);
            return removeHi(ans);
        }
        else{
            char ch = word.charAt(0);
             String ans = word.substring(1);
            return ch+removeHi(ans);
        }

       

    }
}