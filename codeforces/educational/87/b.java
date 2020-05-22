public class b{
    public static int solve(String s){
        if(s.length()<3) return 0;
        int min = 50000;
        int[] count = new count[3];
        int present =0;
        for(int i=0;i<3;i++){
            int ch = s.charAt(i)-'0';
            count[ch+1]++;
            if(count[ch+1]==1) present++;
        }
        for(int i=1;i<s.length()-2;i++){
            // sliding window
            int prev = s.charAt(i-1)-'0';
            int next = s.charAt(i+2)-'0';
            count[next]++;
            if(count[next]==1)present++;
            count[prev]--;
            if(count[prev]==0)present--;
            if( )
        }   

    }
    public static void main(String[] args){

    }
    
}