public class binarysearch{
    public static boolean bs(int[] arr , int potential  ){
        // setting active range
        int low = 0;
        int high = arr.length-1;

        while(low<=high){
            int mid =   low + (high-low)/2; // (low+high)/2; 
            if(arr[mid]==potential){
                return true;
            }
            // updating range
            if(arr[mid]<potential){
                low = mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {1,3};
        System.out.println(bs(arr,3 ));
    }
}