import java.util.*;


public class boundaryTraversal{
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int item ){
            val = item;
            left = right = null;
        }
    }
    public static void boundary2(Node root){
        if(root == null) {
            return;
        }
        // print the node first;
        System.out.print(root.val +" ");
        // first print left view and dont print leafs in it
        leftView(root.left);

        // leafs
        bottomview(root);
        rightView(root.right);

        
    }
    public static void boundary(Node root){
        // 1. print left view
        if(root == null){
            return ;
        }
        Queue<Node> que = new LinkedList<Node>();
        que.add(root);
       ArrayList<Integer> left = new ArrayList<>();
       ArrayList<Integer> right = new ArrayList<>();
        int level =1;
        while(!que.isEmpty()){
            int size = (int)que.size();
            Node firstLeft =null;
            Node lastRight = null;
        
        while(size-- > 0){
            Node ele = que.peek();
            que.remove();
            if(firstLeft==null){
                firstLeft = ele;
              
            }
            lastRight = ele;
            if(ele.left!=null) que.add(ele.left);
            if(ele.right!=null) que.add(ele.right);
        }
        level++;
        left.add(firstLeft.val);
        right.add(lastRight.val);

    }
    
}
    public static void bottomview(Node root){
        if(root == null) return;
        
        if(root.left!=null) bottomview(root.left);
        if(root.left == null && root.right == null){
            System.out.print(root.val+" ");
        }
        if(root.right!=null) bottomview(root.right);

        

    }
    public static void rightView(Node root){
        if(root == null) return;
    
      
        if(root.right!=null){
            rightView(root.right);
        }
        else if (root.left!=null){
            rightView(root.left);
        }
        if(root.left !=null || root.right !=null){
            System.out.print(root.val);
        }

    }
    public static void leftView(Node root){
        if(root == null) return;
    
        if(root.left !=null || root.right !=null){
            System.out.print(root.val);
        }
        if(root.left!=null){
            leftView(root.left);
        }
        else if (root.right!=null){
            leftView(root.right);
        }
     

    }

    public static void main(String[] args) {
        Node node = new Node(10);
    }
}