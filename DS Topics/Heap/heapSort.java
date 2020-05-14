public class heapSort{

    public static void heapsort(int[] arr ){
        boolean isMax = true;
        // phele ek bar max heap create karni padegi
        for(int i =arr.length-1;i>=0;i--){
            downHeapify(arr, i, arr.length-1, isMax);
        }
        for(int i =0;i<arr.length;i++){
            downHeapify(arr, 0 , arr.length-1-i, isMax);
            swap(arr , 0,arr.length-1-i);
        }
        for(int ele:arr)
        System.out.print(ele+" ");
    }
    public static void downHeapify(int[] arr , int idx , int n , boolean isMax){
        int maxidx = idx;
        // parent to be stored in maxidx;
        int lci =(2*idx)+1;
        int rci =(2*idx)+2;
        if(lci<=n && comparable(arr[lci], arr[maxidx], isMax)>0){
            maxidx=lci;
        }
        if(rci<=n && comparable(arr[rci], arr[maxidx], isMax)>0){
            maxidx=rci;
        }
        if(maxidx!=idx){
            swap(arr , maxidx , idx);
            downHeapify(arr, maxidx, n, isMax);
        }
    }
    public static int comparable(int val1 , int val2 , boolean isMax){
        // val1 apne rspct mei check karega
        if(isMax){
            return val1-val2;

            }
            else{
                return val2-val1;
            }
    }
    public static void swap(int[] arr , int idx1 , int idx2){
        int temp = arr[idx1];
        arr[idx1]= arr[idx2];
        arr[idx2]=temp;
    }

    public static void main(String[] args){
        
        int[] arr= {7,5,4,3,-2,33,445,6,-6};
        heapsort(arr);
    }
}