import java.util.ArrayList;

public class BTree{
    // ==== Class of Node
    static class Node{
        int data=0;
        Node left = null;
        Node right = null;

    
   
    Node(int data , Node left , Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
    Node(){

    }
    }
    public static void main(String[] args){
        int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
        Node root = create(arr);
        // so that jo leke aaue vo . vo usko hi point kar rha ho
        // display(root);
        // System.out.println(find(root, 60));
        // ArrayList<Integer> ans = new ArrayList<>();
        // System.out.println(rootToNodePath02(root, 70, ans));
        // System.out.println(ans);
        System.out.println(LCA(root, 70, 90));
    }
    static int idx=0;
    //---- construction -------------------------------
    public static Node create( int[] arr){
        if(idx==arr.length){
            return null;
        }
        
        if(arr[idx]==-1){
            idx++;
            return null;
        }
        Node node = new Node(arr[idx], null,null);
        idx++;
        node.left = create(arr);
        node.right = create(arr);
        return node;
    }
    // ---- display method ----------------------
    public static void display(Node node){
        if(node==null){
            return;
        }
        String str = "";
        
        str+=(node.left==null?".":node.left.data);
        str+=" ->"+node.data+"<- ";
        str+=( node.right==null?".":node.right.data);
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    // -------- Height size find data--------
    public static int height(Node node){
        if(node==null){
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh,rh)+1;
    }
    public static int size(Node node){
        if(node==null){
            return 0;
        }
        int lh = size(node.left);
        int rh = size(node.right);
        return lh+rh+1;
    }
    public static boolean find(Node node , int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        boolean res = false;
        res = res || find(node.left, data);
        res = res || find(node.right , data);
        return res;
    }
  // ----- Root to node path(2 ways)---------------------------------------------------------------
  
  
    public static ArrayList<Integer> shortestPathToNode(Node node, int data){
        if(node==null){

            return null;
        }
        if(node.data==data){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(data);
            return ans;
        }
        ArrayList<Integer> left = shortestPathToNode(node.left, data) ;
        if(left !=null){
            left.add(node.data);
            return left;
        }
        ArrayList<Integer> right= shortestPathToNode(node.right,  data);
        if(right != null){
            right.add(node.data);
            return right;
        }
        return null;
    }
    public static boolean rootToNodePath02(Node node , int data , ArrayList<Integer> ans){
        if(node == null){
            return false;
        }
        if(node.data == data){
            ans.add(node.data);
            return true;
        }
        boolean res = false;
        res = res || rootToNodePath02(node.left, data, ans);
        res = res || rootToNodePath02(node.right, data, ans);
        if(res==true){
            ans.add(node.data);
        }
        return res;
    }
    // -----LCA    ----------------------------------------------------------------------
    public static int LCA(Node node , int data1 , int data2){
        ArrayList<Integer> node1 = shortestPathToNode(node, data1);
        ArrayList<Integer> node2 = shortestPathToNode(node, data2);
        int temp =-1;
        for(int i=node1.size()-1 , j =node2.size()-1;i>=0 && j>=0;i--,j--){
            if(node1.get(i)!=node2.get(j)){
                return temp;
            }
            temp=node1.get(i);
        }
   return temp;
  }
   

}