public class sortFunctions{
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
    
    public static void main(String[] args){
        //1st method simple Arrays.sort chala do.. vo class ke comparable ke hisaab se sort karke aajyega
        Node[] arr = new Node[10];
        Arrays.sort(arr);
        // 2nd method is Lambda function
        Arrays.sort(arr,(Node a , Node b) ->{
            return b.freq-a.freq;
        });

    }
}