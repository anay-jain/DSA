public class toString{
    static class Node{
        int data =0;
        Node left = null;
        Node(int data){
            this.data =0 ;
    
        }
        @Override
        public String toString(){
            return "Hello";
        }
    }
    public static void main(String[] args){
        Node node = new Node(4);
        System.out.println(node);
    }
}