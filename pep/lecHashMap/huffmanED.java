import java.util.HashMap;
import java.util.PriorityQueue;

public class huffmanED{
    public static class Node implements Comparable<Node>{
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
        @Override
        public int compareTo( Node o){
            return this.freq - o.freq;
            // java mei default type min heap hoti hai . to(10-3) mtln apne aap ko strong dikhana padega 
            // taki strong wala neeche jaaayega
        }
    }
    static HashMap<String,String> decode = new HashMap<>();
    static HashMap<String,String> encode = new HashMap<>();
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

    public static void construct(){

        // constructing a tree
        while(pq.size()!=1){
        Node node1 = pq.remove();
        Node node2 = pq.remove();
        // remove two nodes ;
        Node nodeParent  = new Node(node1.data+node2.data, node1 , node2 , node1.freq+node2.freq);
        pq.add(nodeParent);
        }
        // jab last ele bachega vohi hmara node hoga
        traverseTree(pq.remove(),"");

    }
    public static void huffman(String str){
        int[] freqmap = new int[26];
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            freqmap[ch-'a']++;   
        }
        for(int i=0;i<26;i++){
            if(freqmap[i]!=0){
                // add them in PQ
                // as vo hmne ek node type ki bani hai
                // phle hmne char mei type cast kia uske baad string mei
                Node root = new Node((char)(i+'a')+"",null,null,freqmap[i]);
                pq.add(root);
            }
        }
        construct();
    }
    public static String encode(String str){
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            String s = ch +"";
            sb.append(encode.get(s));
        }
        // to convert String builder into string
        return sb.toString();
    }
    public static String decode(String str){
        int j=0;
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=str.length();i++){
            // as ith string is not inculded so we have to start from 1 ;
            String str1  = str.substring(j, i);
            if(decode.containsKey(str1)==true){
                sb.append(decode.get(str));
                j=i;
            }    
        }
        return sb.toString();   
    }
    public static void main(String[] args){
        String str ="aaabbbbcccbcbcbcbcbcbcbbdbdbsbbsbsbsbs";
        huffman(str);
        System.out.println(encode);

    }
}