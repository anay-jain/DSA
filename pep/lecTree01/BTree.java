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
        // System.out.println(LCA(root, 70, 90));
        // kfar01(root, 2, 60);
        kfar02(root, 2, 60);
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
  
  
    public static ArrayList<Node> shortestPathToNode(Node node, int data){
        if(node==null){

            return null;
        }
        if(node.data==data){
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }
        ArrayList<Node> left = shortestPathToNode(node.left, data) ;
        if(left !=null){
            left.add(node);
            return left;
        }
        ArrayList<Node> right= shortestPathToNode(node.right,  data);
        if(right != null){
            right.add(node);
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
    //------- Diameter two methods ------------------------------------------------------

    // -----LCA    ----------------------------------------------------------------------
    public static int LCA(Node node , int data1 , int data2){
        ArrayList<Node> node1 = shortestPathToNode(node, data1);
        ArrayList<Node> node2 = shortestPathToNode(node, data2);
        int temp =-1;
        for(int i=node1.size()-1 , j =node2.size()-1;i>=0 && j>=0;i--,j--){
            if(node1.get(i).data!=node2.get(j).data){
                return temp;
            }
            temp=node1.get(i).data;
        }
   return temp;
  }
  // ---- KFAR 2 methods----------------------------------------------------------
    // kaway for kfar
    public static void kaway(Node node, int k , Node rnode){
        if(node==null){
            return ;
        }
        if(node == rnode){
            return ;
        }
        if(k==0){
            System.out.println(node.data +" ");
        }
        kaway(node.left, k-1, rnode);   
        kaway(node.right, k-1, rnode);
    
    
    }
    public static void kfar01(Node node , int k , int data){
        ArrayList<Node> path =shortestPathToNode(node, data);
        // as this arraylist will point to that node only
        Node rnode = null;
        // this rnode has to be leaved kyuki isme se to aaya tha vo
        for(int i=0;i<path.size();i++){
            kaway(path.get(i), k-i, rnode);
            rnode = path.get(i);
            }
    }
    public static int kfar02(Node node , int k , int data){
        if(node== null){
            return -1;
        }
        if(node.data == data){
            kaway(node, k, null);
            return 1;
        }
        int lh = kfar02(node.left, k, data);
        if(lh!=-1){
            //mtlb isse kahi node mila 
            if(lh==k){
                System.out.println(node.data);
                // return lh+1;
            }
            else{
                kaway(node, k-(lh), node.left);
            }
            // yahi se return kardo 
            return lh+1;
        }
        int rh = kfar02(node.right, k, data);
        if(rh!=-1){
            if(rh==k){
                System.out.println(node.data);
                // return rh+1;
            }
            else{
                kaway(node, k-(rh), node.right);
            }
            return rh+1;
        }
        return -1;
    }
       
// ----- one function(find , height , prec , ssucc , ceil,size  , floor , diameter)------------
class allPair{
    boolean findele = false;
    int height =0;
    int size =0;
  
    int ceil = (int)-1e8;
    int floor =(int)1e8;
    int diameter =0;
    
    Node pred = null;
    Node prec =null;
    Node succ = null;
    
    allPair(){

    }
}
public static void allsoln(Node node, int level ,  int data, allPair sol){
    if(node== null){
        return ;
    }
    // hm node ko call karte ja rhe hai aur hmare pasbs ek class object hai jo hm baar usekartr ja rhe hai
    // har node ke lie alag ni bna rhe
    sol.size++;
    findele = findele || (node.data==data);
    sol.height = Math.max(sol.height, level);
    // will update height accordingly
    


}

}