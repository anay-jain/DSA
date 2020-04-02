import java.util.ArrayList;

public static class priorityQueue{
    public static class priorityqueue{
        ArrayList<Integer> arr = new ArrayList<>();
        boolean isMax = true;
    
        //  calling two differnet type of constuctors

    priorityqueue(boolean isMax){
        this.isMax = isMax;
    }
    priorityqueue(int[] arr1, boolean isMax){
        this.isMax = isMax;
        for(int i=0;i<arr1.length;i++){
            arr.add(arr1[i]);
        }
        for(int i=arr.size()-1;i>=0;i--){
            downHeapify(arr, i,arr.size(), isMax);
        }
    }
public int remove(){ // removes top element
    swap(0,arr.get(arr.size()-1));

    int top = arr.get(arr.size()-1);
    arr.remove(arr.size()-1);
    downHeapify(arr, 0, n, isMax);
    return top;

}
public int update(int prevVal , int newVal){
    int idx=-1;
    for(int i=0;i<arr.size();i++){
        if(arr.get(i)==prevVal){
            idx=i;
            break;
        }
    }
    if(idx==-1) return -1;
    arr.set(idx, newVal);
    upHeapify(idx);
    downHeapify(arr,idx,n.isMax);
}
    public int top(){
        return arr.get(0);
    }
    public int size(){
        return arr.size();
    }
    public void add(int x){
        arr.add(x);
        upHeapify(arr.size()-1);
    }
    public void downHeapify(ArrayList<Integer> arr , int idx , int n , boolean isMax){
        int maxidx = idx;
        int lci = 2*idx+1;
        int rci = 2*idx+2;
        // compare val1 -> will be child and val2-> will be parent
        if(lci<n && comparable(arr.get(lci), arr.get(maxidx), isMax)>0){
            maxidx=lci;
        }
        if(rci<n && comparable(arr.get(rci), arr.get(maxidx), isMax)>0){
            maxidx=rci;
        }
        if(maxidx!=idx){
            swap(maxidx,idx);
            downHeapify(arr, maxidx, n, isMax);
        }
    }
    public void upHeapify(int ci){
        int pi = (ci-1)>>1;
        while(Comparable(arr.get(ci), arr.get(pi))>0){
            swap(ci,pi);
            upHeapify(pi);


        }
    }
    public  int comparable(int val1 , int val2 , boolean isMax){
        if(isMax)
            return val1-val2;
        else
        return val2-val1;
    }
    public  void swap(int x, int y){
        Integer val1 = arr.get(x);
        Integer val2 = arr.get(y);

        // cant use normal temp method
        arr.set(x, val2);
        arr.set(y, val1);
    }

    } 
    public static void main(String[] args){

    }

}