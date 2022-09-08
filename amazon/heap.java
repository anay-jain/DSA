import java.util.*;
public class heap{

    public static class priortityQueue{
        ArrayList<Integer> data;
        priortityQueue(){
            data = new ArrayList<>();
        }
        // get size
        public int size(){
            return data.size();
        }
        // get min
        public int peek(){
            if(data.size()==0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }
        public void add(int num){
            data.add(num);
            upheapify(data.size()-1);
        }
        private void upheapify(int di){
            if(di ==0) return;
            int pi = (di-1)/2;
            if(data.get(pi)<data.get(di)){
                swap(pi,di);
                upheapify(di);
            }
        }
        public void swap(int i , int j ){
            int ith = data.get(i);
            int jth = data.get(j);
            data.set(i, jth);
            data.set(j, ith);   
        }
        private void downheapify(int pi){
            int li = 2 * pi + 1;
            int mini = pi;
            if(li<data.size() && data.get(li)<data.get(mini)){
                mini = li;
            }
            int ri = 2*pi + 2;
            if(ri <data.size() && data.get(ri)<data.get(mini)){
                mini =  ri;
            }
            if(mini !=pi){
                swap(mini , pi);
                downheapify(mini);
            }
        }
        public int remove(){
            if(data.size()==0){
                System.err.println("Underflow");
                return -1;
            }
            swap(0,data.size()-1);
            int val = data.get(data.size()-1);
            data.remove(data.size()-1);
            downheapify(0);
            return val;
        }
    }


public static void main(String[] args) {
        priortityQueue pq = new priortityQueue();
        pq.add(23);
        pq.add(2);
        pq.add(-3);
        System.out.println(pq.peek());
    }   
}