import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class stackQuestions {
    class pair implements Comparable<pair>{
        int dist=0;
        float time=0;
        pair(int dist , float time){
            this.dist = dist;
            this.time= time;
        
        }
        @Override
        public int compareTo(pair o){
            return this.dist - o.dist;
        }
    }
    // next greater on right-------------------------------------------------------------------------
    public int[] ngor(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        // we will store index in stack
        int[] arr1= new int[n];
        for(int i =0;i<n;i++){ //for(int i=n-1;i>=0;i--) -> ngol
            while(st.size()!=0 && arr[st.top]<arr[i]){ // for right <  , for left >
                int temp = st.top();
                st.pop();
                arr1[temp]=arr[i];

            }
            st.push(i);

        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        ArrayList<pair> arr = new ArrayList<>();
        for(int i =0;i<n;i++){
            int temp = target-position[i];
            float rem = temp/speed[i];
            arr.add(new pair(temp, rem));
        }
        Collections.sort(arr);
        float max=0;
        int count=0;
        for(int i=n-1;i>=0;i--){
            if(max<arr.get(i).time){
                max=arr.get(i).time;
                count++;
        }

        }
        return count;
        
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gpetrol =0;
        int gdist=0;
        int n = gas.length;
        int petrol =0;
        int dist=0;
        int temp=-1;
        for(int i=0;i<n;i++){
            petrol+=gas[i];
            dist+=cost[i];
            if(petrol<dist){
                temp=i;
                petrol=dist=0;
                
            }
            gpetrol+=gas[i];
            gdist+=cost[i];
        }
        if(gpetrol>=gdist){
            return temp+1;
        }
        else{
            return -1;
        }
        
    }
    public static void main(String[] args){

    }
}