import java.util.ArrayList;
public class returntype{

    public static void main(String[] args){
        // ArrayList <String> ans = subseq("ABC");
        // for(String s: ans){
        //     System.out.print(s + " ");
        // }
            // System.out.println(removeHi("hidsahdioshdiashihihdhasihd"));
            // System.out.println(dontremoveHit("hijhkhit"));
            // System.out.println(countchars("aaaabbbcde7",1));
            // System.out.println(duplicates("aaaabbbccccdddd"));
            brackets("(w(co)rd)", 0, 0, "");
        }

        public static String brackets(String word,int idx , int count,String res){

            // base case
            if(idx==word.length()){
                return "";
            }
            
            if(word.charAt(idx)=='('){
                res.add(idx);
                return brackets(word,idx+1,count +1,res);
            }                                                                                                 
            if(word.charAt(idx)==')'){
                return brackets(word, idx+1, count-1,res);
            }
            if(count ==0){
                res="";
                return idx + brackets(word, idx+1, count, res);
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
    public static String dontremoveHit(String word){

        if(word.length()==0){
            return "";
        }


        if(word.length()>=3 && word.substring(0, 3).equals("hit")){
            String hit = word.substring(0,3);
            return hit+dontremoveHit(word.substring(3));
        }
        if(word.length()>=2 && word.substring(0, 2).equals("hi")){
            return dontremoveHit(word.substring(2));
        }
        else{
            char ch = word.charAt(0);
            return ch+dontremoveHit(word.substring(1));
        }
      
    }
    public static String countchars(String word,int count){
        if(word.length()==0){
            return "";
        }
        
        char ch = word.charAt(0);
        if(word.length()>1 && ch==word.charAt(1)){
            count++;
            // System.out.print(count + " ");
            return countchars(word.substring(1),count);
        }
        else{
            String chs = "";
            chs+=ch;
            if(count!=1){
        
            chs += Integer.toString(count);
                
            }
           count=1;
            return chs+ countchars(word.substring(1),count);
        }

        
        }
        public static String duplicates(String word){
            if(word.length()==0){
                return "";
            }
            char ch=word.charAt(0);
            if(word.length()>1 && ch==word.charAt(1)){
                return duplicates(word.substring(1));
            }
            else{
                return ch+duplicates(word.substring(1));
            }
        
        
        }

       
}