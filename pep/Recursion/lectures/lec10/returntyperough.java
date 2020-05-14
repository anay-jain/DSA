import java.util.ArrayList;

public class returntype{

    public static void main(String[] args){
         System.out.println(subseq("ABC")); 


    }

    public static ArrayList <String> subseq( String str){
        if(str.length()==0){
            ArrayList base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList <String> resArray = subseq(ros);
        // now we will creare  a new array that will haave all value of res array;
        ArrayList <String> myAns = new ArrayList<>(); // we will copy all elements to another array
        myAns.addAll(resArray); // if element not taken

        for(String s : resArray){
            myAns.add(ch+s); // if element taken
        }
        return myAns;




        // if(str.size()==0){
        //     return 
        // }
        // ArrayList str1 = subseq(str,size-1);
        //     print
        // return str1;
        
    }
    // public static String removeHi(String ques){
    //     if(hi){
    //         String res  = ques.substring(beginIndex)
    //     }

        public  static String removedupiclates(String ques){
            String myans="";
            if(ques.length()==0){
                
            }  
            
            char ch = ques.charAt(0);
            if(ques.charAt(0)==myans.charAt(0)){
                return ch+removedupiclates(ques.substring(1));
            }
        }
    }
    
}
