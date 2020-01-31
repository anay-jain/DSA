public class heapsort{
    
    public static void main(String[] args){
        int[]  arr  = {2,3,-1,10,4};

    }
    public static void downHeapify(int[] arr , int idx,int n){
        int maxidx = idx; // parent 
        int lci = (2*idx)+1;
        int rci = (2*idx)+2;
        // n hmesha kam hota rhega as array piche se sorted hota rhega
        if(lci < n && comparable(arr[lci], arr[maxidx], isMax)>0){
            maxidx=lci;
        }
        if(rci<n && comparable(arr[rci], arr[maxidx], isMax)>0){
            maxidx= rci;
        }
        if(maxidx!=idx){
            // agar vo parent ke equal nahi h to .. call kardo swap
            swap(arr , idx1 , idx2);
        }

    }
    public static void swap(int[] arr , int idx1 , int idx2){
        int temp = arr[idx1];
        arr[idx1]= arr[idx2];
        arr[idx2]=temp;

    }
    public static int comparable(int val1 , int val2 , boolean isMax){
        if(isMax){
            return val1-val2;
        }
        else{
            return val2-val1;
        }
    }
}