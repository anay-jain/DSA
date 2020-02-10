import java.util.ArrayList;
import java.util.LinkedList;


public class hashmapImplementation{

   public class Node{
        Integer key;
        Integer val;
        Node(Integer key , Integer val){
            this.key = key;
            this.val = val;
        }
        @Override 
        public String toString(){
           return key +"="+val;
        }
    }

    // ye ek linkedlist of type node ka  array ban gaya .
    static Integer size =0;
    static LinkedList<Node>[] buckets = new LinkedList[10];
    hashmapImplementation(){
        for(int i =0;i<buckets.length;i++){
            buckets[i]= new LinkedList<>();
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(int i =0;i<buckets.length;i++){
            LinkedList<Node> group = buckets[i];
                int size =group.size();
            if(size>0){
                while(size-->0){
                    Node rnode = group.getFirst();
                    // System.out.println(rnode);
                    sb.append(rnode+" ,");
                    group.addLast(group.removeFirst());

                }
            }
        }
        // sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(" }");
        return sb.toString();

    }

    public static int hashmap(Integer key){
        Integer code= key.hashCode();
        return code% buckets.length;
        // ye btayega konsi bucket mei lie kar rha hai vo

    }
    public  void put(Integer key , Integer value){
        
        Node getNode = get(key);
        if(getNode==null){
            // iska mtlb vo abhi tak usme present nhi hai
            int code = hashmap(key);
            Node nNode = new Node(key,value);
        //kyuki node type  hi linkedlist mei ja skti hai
            buckets[code].addFirst(nNode);  
            // 1) which bucket it should be present
            size++;
            double lambda = (double) buckets[code].size()/buckets.length;
            // no need for double type for buckets length because it will tpecast
            if(lambda >1.0){
                rehash();
            }

        }
        else{
            // update val to new val
            getNode.val = value;
        }

    }
    public static Node get(int key){
        int code = hashmap(key);
        Node rn = foundInGroup(buckets[code], key);
        return rn ;
    }
    public static Node remove ( int key) throws Exception{
        int code = hashmap(key);
        // code nikalo ki vo kis bucket mei present hogi
        Node rNode = get(key);
        if(rNode != null){
             buckets[code].removeFirst();
             size--;
             return rNode;
        }
        else{
            throw new Exception("Ele not found : -1");

        }
       
        
    }
    public static boolean containsKey(int key){
        Node rn =  get(key);
        if(rn!=null){
            return true;
        }
        return false;
    }
    public ArrayList<Integer> keySet(){
        ArrayList<Integer> ks = new ArrayList<>();
        for(int i =0;i<buckets.length;i++){
            if(buckets[i].size()!=0){
                Integer  size = buckets[i].size();
               LinkedList<Node> group = buckets[i];
                while(size-->0){
                    Node rn = group.getFirst();
                    ks.add(rn.key);
                    group.addLast(group.removeFirst());

                }
            }
        }
        return ks;
    }
    public static Node foundInGroup(LinkedList<Node> bucket , int data){
        Node rn = null;
        int size = bucket.size();
        // we can see linkedlist size
        while(size-->0){
            rn = bucket.getFirst();
            if(rn.key!=data){
                bucket.addLast(bucket.removeFirst());
            }
        }
        return rn;
    }
    public  void rehash(){
        LinkedList<Node>[] oldBucket = buckets;
        buckets = new LinkedList[buckets.length*2];
        for(int i =0;i<buckets.length;i++){
            buckets[i]= new LinkedList<>();
        }
        for(int i =0;i<oldBucket.length;i++){
            LinkedList<Node> group = oldBucket[i];
            int size = group.size();
            if(size!=0){
                while(size-->0){
                    Node rnode = group.removeFirst();
                    // int key = rnode.key;
                    // int code = hashmap(key);
                    // buckets[code].addLast(rnode);
                    put(rnode.key, rnode.val);

                }
            }
        }

    }
   
  
}