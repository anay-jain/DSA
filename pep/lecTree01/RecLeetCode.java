public class RecLeetCode{
    static int ans =-(int)1e6;
        
    public static int burstballons(int[] arr , int st , int end){
        if(st ==-1 || end == arr.length){
            return 0;
        }
        if(st==end){
            return arr[st];
        }
        int left =0;
        int right =0;
             
        if(st==0)
            left =1;
        else
            left=arr[st-1];
        
        if(end==(arr.length-1))
            right =1;
        else
            right =arr[end+1];
         // left and right are set.
         for(int i = st ;i<=end ;i++){ 
            ans  = Math.max(ans , (burstballons(arr, st, i-1) + left*arr[i]*right + burstballons(arr, i+1, end)));
        }
        return ans;
    }
    public static int bb(int[] arr)
    public static void main(String[] args){
        int[] arr  = {3,1,5,8};
        System.out.println(burstballons(arr, 0, arr.length-1));

}