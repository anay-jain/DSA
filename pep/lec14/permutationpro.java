import java.util.ArrayList;
public class permutationpro{
    public static void main(String[] args){
        System.out.println(permuation("a"));
    }
    public static ArrayList<String> permuation(String ques){
        // base case
        if(ques.length()==0){
            ArrayList <String> base = new ArrayList<>();
            return base;
        }
     
        if(ques.length()==1){
            ArrayList <String> base = new ArrayList<>();
            base.add(ques);
            return base;
        }
           char ch= ques.charAt(0);
        ques = ques.substring(1);
        // rec 
        // we have to pass every string thats why we have taken string loop above
        ArrayList <String> ans = new ArrayList<>();
        ArrayList <String> recAns = permuation(ques);
        for(String s: recAns){
            for(int i =0;i<=s.length();i++){
                String pre = s.substring(0, i);
                String post =s.substring(i);
                ans.add(pre+ch+post);

            }
        }
        return ans ;


        
    }

    public static ArrayList<String> encoding(String ques){
        if(ques.length()==0){
            ArrayList <String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        ch = ques.charAt(0);
        ques=ques.substring(1);

        if(ch=='0'){
            
        }
    }
}