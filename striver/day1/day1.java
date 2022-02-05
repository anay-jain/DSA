import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class day1{
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        // find the sum of array
        long arrSum = 0;
        int n = A.size();
        long arrSquareSum = 0;
        for(int i =0;i<n;i++){
            arrSum+=(long)A.get(i);
            arrSquareSum += (long)(A.get(i)*A.get(i));
        
        }
        long nSum = (long)(n*(n+1))/2;
        long nSquareSum = (long)(n*(long)(n+1)*(long)((2*n)+1))/6   ;
        
        long xDy = arrSum - nSum;
        long x2Dy2 = arrSquareSum-nSquareSum;
        long xSy = x2Dy2/xDy;
        int x = (int)(xSy+xDy)/2;
        int y = x-(int)xDy;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(x);
        res.add(y);
        return res;           
          



}  
static int count =0;
public static int[] mergeTwoArrays(int[] arr1 , int[] arr2){
    int[] arr = new int[arr1.length + arr2.length];
    int p1 = 0;
    int p2= 0;
    int ptr =0;
    while(p1<arr1.length && p2<arr2.length){
        
        if(arr1[p1]<arr2[p2]){
            arr[ptr] = arr1[p1];
            p1++;
            ptr++;
        }
        else{
            arr[ptr] = arr2[p2];
            count+=(arr1.length-p1);
            p2++;
            ptr++;
        }
        while(p1<arr1.length){
            arr[ptr] = arr1[p1];
            ptr++;
            p1++;
        }
        while(p2<arr2.length){
            arr[ptr] = arr2[p2];
            ptr++;
            p2++;
        }

    }
    return arr;
}
public static int[] mergesort(int[] arr , int si , int ei){
    if(si==ei){
        int[] base = new int[1];
        base[0]=arr[si];
        return  base ;
    }
    int mid = (si+ei)/2;
    int[] left = mergesort(arr, si, mid);
    int[] right = mergesort(arr, mid+1, ei);
    int[] ans = mergeTwoArrays(left, right);
    return ans;


}
public boolean searchMatrix(int[][] matrix, int target) {

    int si =0;
    int m = matrix.length;
    int n = matrix[0].length;
    int ei = m*n-1; 
    int mid = ei/2;

    // apply BS
    while(si<=ei){
        mid = (ei+si)/2;
        int rmid = mid/n;
        int cmid = mid%n;
        // why n ? Do a example
        if(matrix[rmid][cmid]==target){
            return true;

        }
        else if (matrix[rmid][cmid]>target){
            ei = mid-1;

        }
        else{
            si =mid+1;
        }
    }
    return false;
}
public int majorityElement(int[] nums) {
    int ele = -1;
    int count =0;
    for(int i =0;i<nums.length;i++){
        if(count==0){
            ele = nums[i];
            count++;
        }
        else if (nums[i]==ele){
            count++;
        }
        else{
            count--;
        }
    }
    return ele;
        

}
public int solve(ArrayList<Integer> A, int B) {
HashMap<Integer,Integer> hm = new HashMap<>();
int xr=A.get(0)^A.get(1);
hm.put(xr, 1);
int count=0;
for(int i=2;i<A.size();i++){
    xr=xr^A.get(i);
    
    int y = xr^B;
    if(hm.containsKey(y))
    count+=hm.get(y);
    if(xr==B){
        count++;
    }
    hm.put(xr, hm.getOrDefault(xr, 0)+1);

}
return count;
}

public int subarraywithZeroSum(int[] arr){
    HashMap<Integer,Integer> hm = new HashMap<>();
    int sum =0;
    int max =0;
    for(int i =0;i<arr.length;i++){
        sum+=arr[i];
        if(sum==0) max = i+1;
        else{
        if(hm.containsKey(sum)){
            max = Math.max(i-hm.get(sum), max);
        }else{
            hm.put(sum, i);
        }   
    }
    }
    return max;
}
static int reverseCount = 0;

public int mergeSortReverse(int[] left , int[] right){
    // 1st loop to check the number of revese
    int i =0;
    int j =0;
    while(i<left.length && j <right.length){
        if(left[i]>2*right[j]){
            reverseCount+=(i);
        }
    }
    // now sort , two sorted arrays
    int[] ans = new int[left.length + right.length ];
    while(i<left)
}
public int[] mergeReverse(int[] nums , int si , int ei){
    if(si==ei){
        return new int[]{nums[si]};
        int mid = (si+ei)/2;
    int[] left = mergeReverse(nums, si, mid);
    int[] right = mergeReverse(nums, mid+1, ei);
    int[] ans = mergeSortReverse( left ,  right);
    return ans;

    }
}

public int reversePairs(int[] nums) {
        
}


    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(5);
        // ArrayList<Integer> al = repeatedNumber(A);
        // for(Integer i : al){
        //     System.out.println(i);
        // }
        // int[] arr = {73,46,49,81,10};
        int[] arr = {2,4,1,3,5};
        mergesort(arr, 0, arr.length-1);
        System.out.println(count);  
            // System.out.println(getInversions(arr, 3));

    }
}