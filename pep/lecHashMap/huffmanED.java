import java.util.HashMap;
import java.util.PriorityQueue;

public class huffmanED{
    public static class Node implements Comparable{
        String data ;
        Node left = null;
        Node right = null;
        int freq =0;
        Node(String data , Node left , Node right , int freq){
            this.data = data;
            this.left = left;
            this.right = right;
            this.freq = freq;
        }
    }
    static HashMap<String,Character> decode = new HashMap<>();
    static HashMap<Character,String> encode = new HashMap<>();
    // PriorityQueue 
    public static void traverseTree(Node node, String ans){
        if(node.left == null && node.right == null){
            // leaf par hi sare characters hoge
            encode.put(node.data , ans);
            decode.put(ans, node.data);
            return;
        }
        traverseTree(node.left, ans+"0");
        traverseTree(node.right, ans+"1");
    }
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static int
    public static Node construct(Node node){
        
    }
    public static void main(String[] args){

    }
}