import java.util.ArrayList;
import java.util.LinkedList;;
public class hashmapImpl{
    public static  class hashmap<K,V>{
        public class HMnode{
            K key ;
            V value;
            HMnode(K key , V value){
                this.key = key;
                this.value = value;
            }
        }
        public hashmap(){
            initBucket(4);
            size =0;
        }
        // size and bucket
        private int size =0;
        private LinkedList<HMnode> bucket[];

        private void initBucket(int n){
            bucket = new LinkedList[n];
            for(int i =0;i<n;i++){
                bucket[i] = new LinkedList<>();
            }
        }
        // to get size
        public int size(){
            return size;
        }
        private int getHash(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % bucket.length;
        }
        private int getNodeFromBucket(K key , int hash){
            int idx =0;
            for(HMnode node : bucket[hash]){
                if(key == node.key) return idx;
                idx++;
            }
            return -1;
        }
        private void rehash(){
            LinkedList<HMnode>[] prev = bucket;
            initBucket(bucket.length * 2);
            size =0;
            // now all the elemets will be put again
            for(int i =0;i<prev.length;i++){
                for(HMnode node : prev[i]){
                    put(node.key, node.value);
                }
            } 
        }
        public void put (K key , V value){
            int hash    = getHash(key);
            // update or delete
            int di = getNodeFromBucket( key , hash);
            if(di==-1){
                // insert
                HMnode node = new HMnode(key,value);
                bucket[hash].add(node);
                size++;
            }
            else{
                // update
                bucket[hash].get(di).value = value;
            }
            // lambda function 
            double lambda = size * 1.0 / bucket.length;
            if(lambda > 4.0){
                rehash();
            }

        }
        public boolean containsKey(K key){
            int hash = getHash(key);
           
            int di = getNodeFromBucket( key , hash);
            if(di==-1){
               
              return false;
            }
            else{
               
            return true;
            }
        }
        public V get(K key){
            int hash = getHash(key);
      
            int di = getNodeFromBucket( key , hash);
            if(di==-1){
              
               return null;
            }
            else{
                
                return bucket[hash].get(di).value;
            } 


        }

        public V remove(K key){
            int hash = getHash(key);
      
            int di = getNodeFromBucket( key , hash);
            if(di==-1){
        
               return null;
            }
            else{
               
                V value =  bucket[hash].get(di).value;
                bucket[hash].remove(di);
                size--;
                return value;
            } 
        }
        
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i =0;i<bucket.length;i++){
                for(HMnode node : bucket[i]){
                    keys.add(node.key);
                }

            }
            return keys;
        }
    }
    public static void main(String[] args) {
        hashmap<Integer,Integer> hm = new hashmap<>();
        hm.put(5, 7);
        System.out.println(hm.get(5));
        
    }
}