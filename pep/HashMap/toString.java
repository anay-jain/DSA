public  class toString{
    static class Node{
        int data =0;
        Node left = null;
        Node(int data){
            this.data =data;
    
        }
        @Override
        public String toString(){
            return "Hello";
        }
        public void display(){
            System.out.println(data);
        }
    }
    public static void main(String[] args){
        Node node = new Node(4);
        System.out.println(node.toString());
        node.display();
    }
}