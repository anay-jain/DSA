import java.util.ArrayList;
public class recursion{
    public static int maximum(int[] arr, int vidx){
        if(vidx == arr.length-1){
            return arr[vidx];   
        }
        int max = maximum(arr, vidx+1);
        max = arr[vidx]<max?max:arr[vidx];
        return max;
    }
   
    public static int lastindex(int[] arr , int vidx, int data){
        if(vidx == arr.length){
            return -1;
        }
        int recAns= lastindex(arr, vidx+1, data);
        if(vidx != -1){
            return recAns;
        }
        else{
            return arr[vidx]==data?vidx:-1;
        }

    }
    public static int[] allindex(int[] arr, int vidx , int data,int count){
        if(vidx==arr.length){
            // for creating an array one time , we declare in the base
            int[] ans = new int[count];
            return ans;
        }
       
        if(arr[vidx]==data){
            count++;
        }
        int[] ans = allindex(arr,vidx+1,data,count);
        if(arr[vidx]==data){
            ans[count-1]=vidx;
            // count--;
        }
        return ans;
    }
    public static ArrayList<String> subsequences(String ques){
        if(ques.length()==0){
            // returns an empty array list
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char ch = ques.charAt(0);
        ques = ques.substring(1);
        ArrayList <String> myans = new ArrayList<>();
        // if not , then answer will be only on string;
        ArrayList<String> recAns = subsequences(ques);
        myans.addAll(recAns);
        for(String s: recAns){
            myans.add(ch+s);
        }
        return myans;
    }
    public static String removeHi(String ques){
       
        if(ques.length()==0){
            return "";
        }
        char ch1 = ques.charAt(0);
        if(ques.length()==1){
            
            return ch1+"";
        }
    //    string = " " and char = ' '
        char ch2 = ques.charAt(1);
        // ArrayList <String> ans = new ArrayList<>();
        if(ch1=='h' && ch2=='i'){
            return removeHi(ques.substring(2));
        }
        else{
            return ch1+ removeHi(ques.substring(1));
        }
    }
    public static void main(String[] args){
        // int[] arr={4,265,15,265,265,26,56,25,3};
        // System.out.println(allindex(arr, 0, 265, 0));
        System.out.println(removeHi("hifskhsdifhsdifsdihj"));
    }
}