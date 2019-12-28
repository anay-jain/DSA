import java.util.ArrayList;
public class recrevise{
    public static ArrayList<String> subseq(String s){
        if(s.length()==0){
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;

        }
        char ch = s.charAt(0);
        ArrayList<String> finalans = new ArrayList<>();
        ArrayList<String> ans = subseq(s.substring(1));
        for(String str : ans ){
            finalans.add(ch+str);
        }
            finalans.addAll(ans);
        return finalans;
    }
   
    public static void main(String[] args){
            System.out.println(subseq("abc"));
    }
}