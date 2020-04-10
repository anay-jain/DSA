import java.util.LinkedList;

public class hm{
   public class Node{
       int key;
       int val;
       Node(int key, int val){

       }
  
        int n = 10;
        LinkedList<Node>[] buckets = new LinkedList[n];
        hm(){
            for(int i=0;i<n;i++){
                // new kardo sari buckets ko
                buckets[i]=new LinkedList<>();
            }
        }
        public Node foundInGroup(LinkedList<Node> bucket, int key){


        }
        public int getHashCode(int key){
            Integer code =  key.hashCode();
            return Math.abs(code)/n;

        

    }
    public static void main(String[] args){

    }
}