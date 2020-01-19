import java.util.ArrayList;

class btree{
    public static class Node{
        int data=0;
        Node left = null;
        Node right = null;
        Node(int data , Node left , Node right){
            this.data=data;
            this.left=left;
            this.right=right;

        }
        Node(){

        }
    }
    // construction of tree=========================================================
    // we dont need node as we are  iterating on the array
    static int idx=0;
 public static Node construction(int[] arr ){
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
        node.left  = construction(arr);
        node.right = construction(arr);

        return node;

    }
    public static void display(Node node ){
        if(node == null ){
            return ;
        }
        String str = "";
        str +=  node.left==null?" .":node.left.data;
        str +=  "-> "+ node.data + " <- ";
        str +=  node.right==null?".":node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);

    }
    // inorder traversal ==========================================================
    public static void inorderdisplay(Node node , ArrayList<Node> arr){
        if(node==null){
            return;
    }   
    arr.add(node);
    inorderdisplay(node.left,arr);
    // System.out.print(node.data+ " -> ");
  
    inorderdisplay(node.right,arr);
    }
    public static int[] diameter2(Node node) {
        if (node == null) {
            return new int[2];
        }

        int[] left = diameter2(node.left);
        int[] right = diameter2(node.right);

        int[] myAns = new int[2];
        myAns[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + 1);
        myAns[1] = Math.max(left[1], right[1]) + 1;
        return myAns;

    }
    //=============================================================================
    public static void swapNodeInBst(ArrayList<Node> arr, Node data){
        Node[] arr1 = new Node[3];
        arr1[1]=null;
        arr1[2]=null;
        arr1[0]=data;
        for(int i =0;i<arr.size()-1;i++){
            if(arr.get(i).data>arr.get(i+1).data){
                arr1[1]=arr.get(i);
            }
        }
    }
    // public static Node preorderBST(int[] arr, int idx){
    //     if(idx==arr.length){
    //         return null;
    //     }
    //     Node node = new Node(arr[idx],null,null);
    //     // if(arr)
        
    // }
    // =====IS_BST====================================================================
    public class BSTpair{
        boolean isBST = true;
        int bstcount =0;
        int maxsize =0;
        Node rnode = null;
        int max = -(int)(1e8); // max(left)
        int min = (int)1e8;
    }
  
    public static void main(String[] args){

        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        Node root = construction(arr);
        // display(root);
        inorderdisplay(root);

    }
}