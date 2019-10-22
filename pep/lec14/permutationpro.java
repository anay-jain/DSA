import java.util.ArrayList;
public class permutationpro{
    public static void main(String[] args){
        // System.out.println(encoding("01561"));
        String[] keys={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
         System.out.println(keypad_01("245",keys));
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
           ArrayList<String> base = new ArrayList<>();
           base.add("");
           return base;
       }
       char ch = ques.charAt(0);
    //    ques= ques.substring(1);
       ArrayList<String> ans = new ArrayList<>();
       if(ch=='0'){
           return encoding(ques.substring(1));

       }
       else{
           ArrayList <String> recAns = encoding(ques.substring(1));
           // converting int to mapped char and adding it in ans
           char ch1 = (char)('a' + ch-'1');
           for(String s:recAns){
               ans.add(ch1+s);
               
           }
       }
       if(ques.length()>1){
           char ch1 = ques.charAt(1);
           int num = (ch1-'0')*10+(ch-'1');
           // another methif
        //    int num = Integer.parseInt(ques.substring(1));
        if(num<27){
           ArrayList<String> recAns = encoding(ques.substring(2));
           for(String s: recAns){
               char twodigit = (char)('a' + num-1);
               ans.add(twodigit+s);
           }
        }

        
       }
       return ans;
   }
   public static ArrayList keypad_01(String ques , String[] keypad){
       if(ques.length()==0){
           ArrayList <String> base = new ArrayList<>();
           base.add("");
           return base;
       }
       ArrayList ans = new ArrayList<>();   
       char ch = ques.charAt(0);
    //    ques = ques.substring(1);
       int idx= ch- '0';
       String key = keypad[idx];
       for(int i=0;i<key.length();i++){
           ArrayList<String> recAns = keypad_01(ques.substring(i), keypad);
           for(String s: recAns){
               ans.add(key.charAt(i)+s);
           }
       }
       return ans;
   }
   public static ArrayList<String> keyPad_01(String ques,String[] keys){
if(ques.length()==0){
    ArrayList<String> base=new ArrayList<>();
    base.add("");
    return base;
}

    
        char ch=ques.charAt(0);
        String roq=ques.substring(1);
        int idx=ch-'0';
        String word=keys[idx];

        ArrayList<String> myAns=new ArrayList<>();
        ArrayList<String> recAns=keyPad_01(roq,keys);
        for(String s: recAns){
            for(int i=0;i<word.length();i++)
               myAns.add(word.charAt(i)+s);
        }
         return myAns;
    }
 
}