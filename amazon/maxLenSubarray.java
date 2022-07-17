import java.util.*;

public class maxLenSubarray{
    public int getMaxLen(int[] nums) {
        int lMinus =-1;
        int rMinus =-1;
        int zeroIdx = -1;
        int oneCount = 0;
        int max =0;
        int candidate =0;
        for(int i =0;i<nums.length;i++){

            if(nums[i]==0){
                lMinus =-1;
                rMinus = -1;
                zeroIdx = i;
                oneCount=0;
            }
            else{
                if(nums[i]<0 && lMinus == -1){
                    lMinus =i;
                }
                if(nums[i]<0){
                    rMinus =i;
                    oneCount++;
                }
                if(oneCount%2 == 0){
                    max = Math.max(max, i-zeroIdx);
                   }
                   candidate = Math.max(i-lMinus-1, rMinus-zeroIdx-1);
                   max = Math.max(max, candidate);
               }
            }
            return max;
            

        }

 
  
    public static void main(String[] args) {
        
    }
}