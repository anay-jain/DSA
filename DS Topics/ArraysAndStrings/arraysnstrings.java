import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class arraysnstrings{
    // leetcode 925 long pressed name
    public boolean isLongPressedName(String name, String typed) {
        int i =0, j =0;
        while(i<name.length() && j<typed.length()){
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }
            else if(j>=1 && typed.charAt(j)==typed.charAt(j-1)){
                j++;
            }
            else{
                return false;
            }
        }
       return name.charAt(name.length()-1)==typed.charAt(typed.length()-1);
    }
    public static void reverse(int[] arr , int i , int j ){
        int l=j;
        for(int t = i;t<=(j+i)/2;t++,l--){
            int temp = arr[t];
            arr[t]=arr[l];
            arr[l]=temp;
        }
    }
    public void rotate(int[] nums, int k) {
     // make it in range
     int n = nums.length;
     k = k%n;
        if(n==1 || k==0 ) return;
     k=k<0?k+n:k;
        n=n-1;
        System.out.print(k);
     reverse(nums, 0,n-k );
     reverse(nums,n-k+1,n);
     reverse(nums, 0, n);

    
    }

    // next greater element
    public int nextGreaterElement(int n) {
        int idx=0;
        if(n<=10) return -1;
         if(n<0 || n>Integer.MAX_VALUE) return -1;
       int justgreater=0;
        boolean flag=false;
       String s = Integer.toString(n);
       StringBuilder sb = new StringBuilder(s);
       int i = s.length()-2;
       for(i=s.length()-2;i>=0;i--){
           int a = (int)s.charAt(i)-'0';
           int b =  (int) s.charAt(i+1)-'0';
           if(a<b){
               int t=i+1;
               justgreater=b;
               idx=t;
               while(t<s.length()){
                 
                   int ele = (int)s.charAt(t)-'0';
                   if(ele>a && ele<=justgreater){
                   justgreater=ele;
                   idx=t;
                   }
                     t++;
                   
                   
               }
               System.out.println(justgreater+" "+idx);
               flag=true;
          
               // swap them
               sb.setCharAt(i, s.charAt(idx));
               sb.setCharAt(idx, s.charAt(i));
               System.out.print(sb.toString());
               
               break;
           }
       }
       int end= s.length()-1;
       for(int st=i+1;st<=(s.length()+i)/2;st++,end--){
           char temp1 = sb.charAt(end);
           char temp2 = sb.charAt(st);
           sb.setCharAt(st, temp1);
           sb.setCharAt(end, temp2);
       }
       
       s=sb.toString();
        // int num=0;
        // for( i=0;i<s.length();i++){
        //     int a = (int)s.charAt(i)-'0';
        //     num= num*10+a;
        // }
        if(s.length()>=10) return -1;
       int num=  Integer.parseInt(s);
        if(num<0 || num>Integer.MAX_VALUE) return -1;
       return flag?num:-1;
   }
   // LEETCODE  53
   // kadane's algorithm 
   public int maxSubArray(int[] nums) {
       if(nums.length==0) return 0;
            int csum = nums[0];
            int osum = nums[0];
            for(int i=1;i<nums.length;i++){
                if(csum>=0){
                    // this means x(-ve) Y(csum) Z(-ve)
                    csum+=arr[i];

                }
                else{
                    cmax=arr[i];
                }
                osum = Math.max(osum, csum);
            }
            return osum;
}
// leetcode  11
public int maxArea(int[] height) {
        int i =  0;
        int j = height.length;
        int max = 0 ;
        while(i<j){
            if(height[i]>height[j]){
                max = Math.max(max , (j-i)*height[i]);
                j++;
                
            }
            else{
                max =  Math.max(max , (j-i)*height[j]);
                i++;
            }
        }
        return max;
}

// leetcode 26

    public int removeDuplicates(int[] nums) {
         if (nums.length == 0 ) return 0;
        int j =0;
         for(int i =1;i<nums.length;i++){
             if(nums[i]!=nums[j]){    
                     j++;
                     nums[j] =nums[i];
             }
         }
     return j+1;
 }
 
 public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i =1;i<nums.length-1;i++){
            prefix[i] = nums[i]*prefix[i-1];
        }
        int suffix=1;
        for(int i =nums.length-1;i>=1;i--){
            prefix[i] = prefix[i-1]*suffix;
            suffix= suffix *nums[i];
        }
        prefix[0]=suffix;
        return prefix;
}
// Find the number of jumps to reach X in the number line from zero
    // LC 754

public int reachNumber(int target) {
            target = Math.abs(target);
            int n = Math.sqrt(target*2);
            if((n*(n+1))/2 < target) n= n+1;
            int offset = (n*(n+1))/2;
            int diff = offset - target;
           while(diff % 2  != 0 ){
            n = n+1;
            diff= diff+n;
        }
        return n ;
}
   // seive of eratosthenes
public static boolean[] sieve(int n ){
    // maing a booelean array .
    boolean[] vis = new boolean[n+1];
    for(int i=2;i<=(int)Math.sqrt(n);i++){
        if(vis[i]==false){
            for(int j=2;j*i<=n;j++){
                vis[i*j]=true;
            }
        }
    }
    return vis;
}

// leetcode 204
public int countPrimes(int n) {
    if(n<3) return 0;
    boolean[] vis = new boolean[n];
int count = n-2;
for(int i=2;i<=(int)Math.sqrt(n);i++){
    if(vis[i]==false){
        for(int j=2;j*i<n;j++){
            if(vis[i*j]!=true)count--;
            vis[i*j]=true;
            
        }
    }
}
return count;
}
// maximum sum in the configuration GFG
int max_sum(int arr[], int n)
{
    // finding prefix sum
    int ps = 0;
    for(int i =0;i<n;i++){
        ps+=arr[i];
    }
    // finding the cost of inital array
    int cost = 0 ;
    for(int i=0;i<n;i++){
        cost+=(arr[i]*i);
    }
    // cost always store the current config cost
    // maxcost stores the highest
    int maxcost = cost;
    for(int i=0;i<n;i++){
        cost = cost - ps + arr[i]*n;
        maxcost = Math.max(maxcost,cost);
    }
    return maxcost;


}
// search in sorted and rotated arrays
public int search(int[] nums, int target) {    
    int pivot = findPivot(nums);
System.out.println(pivot);
    int left = bs(nums, 0, pivot, target);
    int right = bs(nums, pivot+1, nums.length-1, target);
    if(left!=-1){
        return left;
    }   
    if(right!=-1){
        return right;
    } 
    return -1;
}
public static int findPivot(int[] arr){
int si = 0 , ei = arr.length-1;
while(si<=ei){
    int mid = (si+ei)/2;
    if(arr[mid] > arr[(mid-1+arr.length)%arr.length] && arr[mid]>arr[(mid+1)%arr.length]){
        return mid;
    }
    // this works because we are finding the pivot -1 element c<a>b b is pivot but we are finding a
    else if (arr[si]<=arr[mid]){
        si = mid+1;
    }
    else 
        ei = mid-1;
}
return -1;
}
public int bs(int[] nums , int start , int end , int target)
{
while(start<=end){
    int mid = (start+end)/2;
    if(nums[mid] == target){
        return mid;
    }
    if(nums[mid]>target){
        end = mid-1;
    }
    else{
        start = mid+1;
    }
    
}
return -1;
}


//Given a sorted and rotated array, find if there is a pair with a given sum
public static boolean pairInSortedRotated(int arr[], int n, int x){
    // find pivot;
    int pivot = findPivot(arr);
    pivot++;
    int start = pivot;
    int end = (pivot +n -1)%arr.length;
    while(start!=end){
        int sum = arr[start]+ arr[end];
        if(sum  == x){
            return true;
        }
        else if( sum < x){
            if(start == n-1) start = -1;
            start++;
        }
        else{
            if(end == 0) end = n;
            end--;
            
        }
        
    }
    return false;


}

//  // get median in running stream of integers
//  public static int getMedian(int[] arr , int n ){
//      // make a min and max PQ
//      PriorityQueue<Integer>minPQ = new PriorityQueue<>();
//      PriorityQueue<Integer>maxPQ = new PriorityQueue<>(Collections.reverseOrder());
     
     
//  }

// Rearrange positive and negative numbers in O(n) time and O(1) extra space

// perform a quick sort , make a pivot point 
public static void swap(int[] arr , int i , int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j]= temp;
}
public static void rearrange(int[] arr , int n){

    int pivot =0;
    for(int i=0;i<n;i++){
        if(arr[i]<0){
            swap(arr, pivot , i);
            pivot++;
        }
    }
    if(pivot == n-1 || pivot == n) return ;
    // now swap accordingly
    // and the -ve elements will automatically come to the right when +ve gets exhausted
    int itr =0 ;
    while(pivot != n && itr <= pivot){
        if(itr%2==0){
            swap(arr, itr , pivot);
            pivot++;
        }
        itr+=2;
  }
}
public static void swap(ArrayList<Integer> arr , int i , int j){
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
}
// Three way partitioning of an array around a given range
    public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> arr , int low , int high){
          // take two ptr l and r 
        // [.. , l ...r ...]
        int l =0; int r =0;
        System.out.println(arr.size());
        for(int  i=0;i<arr.size() ; i++){
           int ele = arr.get(i);
   
           if( ele<low){
               // will be in 1st range
               // here will swap(i , l )
               swap(arr , i , l );
               l++;
               r++;
           }
           else if ( ele >= low && ele <= high){
               r++;
               swap(arr, r , i);
              
           }
         
           }
           for(int i =0;i< arr.size();i++)
           System.out.println(arr.get(i));
           
           return arr;
    }

    
}