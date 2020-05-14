public class lpsrec{
    public static int ps(String ques , String ans , int i , int j ){
        if(i==j || j-i ==1){
            if(i==j){
                ans = ans.substring(0,ans.length()/2)+ques.charAt(i)+ans.substring(ans.length()/2);
                System.out.println(ans);
                return 1;
            }
            else{
                if(ques.charAt(i)==ques.charAt(j)){
                    System.out.println(ques.charAt(i)+ans+ques.charAt(i) );
                    return 1;
                }
                return 0;
            }
        }
        int count=0;
        // if not equal
        if(ques.charAt(i) != ques.charAt(j)){
            // to mauka do 
            count += ps(ques , ans , i+1 ,j);
            count += ps(ques,ans, i, j-1);
        }
        else{
            count+=ps(ques , ques.charAt(i)+ans+ques.charAt(i) , i+1 , j-1);
        }
        return count;
    }
    public static void main(String args[]){
        System.out.println(ps("baefeabd", "", 0, 7));
    }
}