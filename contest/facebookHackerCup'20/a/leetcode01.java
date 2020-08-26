public class leetcode01 {
    public List<String> fizzBuzz(int n) {
        List<String> li  = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if( i %3==0 && i%5==0){
                li.add("FizzBuzz");
            }
            else if ( i % 5 ==0){
                li.add("Buzz");

            }
            else if( i % 3 ==0 ) li.add("Fizz");
            else {
                String s = Integer.toString(i);
                li.add(s);
            }
        }   
        return li;     
    }
    public static int mincostTickets_(int[] days , int[] costs , int idx , int validity, int[] memo){
        // base case
        if(idx >= days.length){
            return 0;
        }
        if(memo[idx]!=0) return memo[idx];
        if(days[idx] <=validity)
             return  mincostTickets_(days, costs, idx+1,validity, memo); 
        else{
           
           int  a  =mincostTickets_(days, costs, idx+1,days[idx], memo)+costs[0];
            int b =  mincostTickets_(days, costs, idx+1,days[idx]+6, memo)+costs[1];
            int c = mincostTickets_(days, costs, idx+1,days[idx]+29 . memo)+costs[2];
            memo[idx] =  Math.min(a, Math.min(b, c));
            return memo[idx];
        }
    }
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days.length];
        return mincostTickets_(days, costs, 0, -1 , memo
    }
   public static void main(String[] args){

        }
}