class btree{
    public static class Node{
        int node =0;
        Node left = null;
        Node right = null;
        Node(int node , Node left , node right){
            this.node=node;
            this.left=left;
            this.right=right;

        }
        Node(){

        }
    }
    // we dont need node as we are  iterating on the array
    Node construction(int[] arr , int idx){
        if(idx==arr.length){
            return null;

        }
        if(arr[idx]==-1){
            idx++;
            return null;
        }
        Node node = new Node(arr[idx], null, null);
        idx++;
        // isse ek node create ho jayega jo aage node create karega aur last mei iska left mei aage ka aajayega
        node.left  = construction(arr, idx);
        node.right = construction(arr, idx);

        return node;

    }
    void display(Node node ){
        
    }
}