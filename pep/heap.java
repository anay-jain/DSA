public class heap{
    public static class heap{
        ArrayList<Integer> arr= new ArrayList<>();
        boolean isMax = true;
    }    
    public static int compareable(int val1 , int val2){
        if(isMax==true){
            return val1-val2;
            // we are assuming val1 to be strong;
        }
        else{
            return val2-val1;
        }
    }
    
    public static void main(String[] args){
        
    }
}