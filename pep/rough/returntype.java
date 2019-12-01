import java.util.ArrayList;
import java.util.Scanner;


public class returntype{
    public static void main(String args[]){
        System.out.println(subseq("abc"));

    }

    public static ArrayList<String> subseq(String ques){
        if(ques.length()==0){
            // return an empty arraylist
            ArrayList<String> base = new ArrayList<>();
            base.add(""); // adding an empty string to array list
            return base;
        }
        char ch = ques.charAt(0);
        Sstring ros = ques.substring(1);
        ArrayList<String> finalans = new ArrayList<>();
        ArrayList<String> reference = subseq(ros);
        for(String s: reference){
            finalans.add(ch+s);
        }
        finalans.addAll(reference);

        return finalans;

    }
    //==========compression=================================================================
    public static string compression(String ques ,int count){
        if(ques.length()==0){
            return "";
        }
        if(ques.length()>1 && q){

        }
        
    }
}