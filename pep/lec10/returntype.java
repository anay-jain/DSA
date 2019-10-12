import java.util.ArrayList;
public class returntype{

    public static void main(String[] args){
        ArrayList <String> ans = subseq("ABC");
        for(String s: ans){
            System.out.print(s + " ");
        }
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

}