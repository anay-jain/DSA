public class callmagic{

    public static void main(String[] args) {
        System.out.println(calls(5));
        
    }

    public static int calls(int n ){
        int count =0;
        if(n<=1){
            System.out.println("Base : "+ n  + "Count : " + count);
            return n+1;
        }
       
        System.out.println("Pre : " + n + "Count : " + count);
        count+=calls(n-1);

        System.out.println("In : "+ n + "Count : " + count);

        count+=calls(n-2);
        System.out.println("Post : "+ n + "Count : " + count);
        return count+3;
    }
}
