import java.util.ArrayList;
public class permutationofstring{

    public static void main(String[] args){
        // String[][] dirname = {{"1","a"},{"2","b"},{"3","c"},{"4","d"},{"5","e"},{"6","f"},{"7","g"},{"8","i"},{"9","j"},{"10","k"},{"11","m"}};
        System.out.println(encoding("2343"));
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
    // public static boolean isValid(String[][] dirname , String res){
    //     // int q = res.charAt(1) -'a';
    //     // int q1 = res.charAt(0) -a;
    //     for(int i =0;i<dirname.length;i++){
    //         if(dirname[i][0]==res){
    //             return true;
    //         }
    //         return false;
    //     }
    // }
    // public static ArrayList<String> chmapping(String ques , int i , String[][] dirname){
    //     if(ques.length()==0){
    //         ArrayList <String> base = new ArrayList<>();
    //         return base;
    //     }

    //     ArrayList <String> myans = new ArrayList<>();
    //     if(ques.charAt(i)=='0'){
    //         return ans;
    //     }
    //     String ch = ques.substring(0,i);
    //         ques = ques.substring(i);

    //     if(i<ques.length()-1 ){
           
    //         ArrayList <String> one = chmapping(ques,i+1,dirname);
    //         for(String s:one){
    //             myans.add(ch+s);
    //         }
    //     }
        
    //     if(i<ques.length()-2 && isValid(dirname , ques.substring(0,2))){
                
    //         ArrayList <String> two = chmapping(ques, i+2,dirname);
    //         for(String s:two){
    //             myans.add(ch+s);
            
    //     }
        
    // }
    // return myans; 
// }
public static ArrayList <String> encoding(String ques){
    if(ques.length()==0){
        ArrayList base = new ArrayList<>();
        base.add("");
        return base;
    }
     char ch=ques.charAt(0);
    ArrayList myans = new ArrayList<>();
    if(ch=='0'){
        encoding(ques.substring(1));
    }
    else{
       
      ArrayList <String> recAns = encoding(ques.substring(1));
        for(String s: recAns){
            char ch1 = (char)('a' + ch-'1');
            myans.add(ch1+s);
        }


    }
    if(ques.length()>1){
        // int num - (ch - '0')*10 + (ch1 - '0');
        int num = Integer.parseInt(ques.substring(0,2));
    
    if(num<27){
        ArrayList <String> recAns = encoding(ques.substring(2));
        for(String s: recAns){
            char ch1 = (char)('a' + num-1);
            myans.add(ch1+s);
        }
    }
    }
    return myans;
}

}