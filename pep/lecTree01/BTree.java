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
        // kfar02(root, 2, 60);
    
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
    
    Node pred = null; // just prev valuee
    Node prev =null; // previous will always change according gi he ndoe 
    Node succ = null; // just aage wali value
    
    allPair(){

    }
}
public static void allsoln(Node node, int level ,  int data, allPair sol){
    if(node== null){
        return ;
    }
    // hm node ko call karte ja rhe hai aur hmare pasbs ek class object hai jo hm baar usekartr ja rhe hai
    // har node ke lie alag ni bna rhe bas allpair soln ko hi update kar rhe h

    sol.size++;
    sol.findele = sol.findele || (node.data==data);
    sol.height = Math.max(sol.height, level);
    if(node.data>data && sol.ceil>node.data){
       sol.ceil = node.data;
    }
    if(node.data<data && sol.floor<node.data){
        sol.floor = node.data;
    }
    if(node.data == data && sol.pred==null){
        sol.pred = sol.prev;
    }
    if(sol.pred!=null && sol.succ == null && sol.prev.data==data){
        sol.succ = node;
    }
    sol.prev = node;
    allsoln(node.left, level+1, data, sol);
    allsoln(node.right, level+1, data, sol);
    // will update height accordingly
    
}

// ----- IS BST---------------------------------------------------------------------------
// prev sould be static as hme usko har level par change nahi karna 
static int prev  = -1e6; 
public static boolean isBST(Node node ){
    if(node == null){
        return true;
    }
    if(!isBST(node.left)){
        return false;
    }
     // jo bhi prev  hai usko apne app se check karta hazi
    if(node.data <prev){
        return false;
    }
   
    prev = node.data; 
    // right ko call lagane se phele vo apne app ko phele prev set karta hai phir roght ki call lagata
    if(!isBST(node.right)){
        return false;
    }
    return true;

}
// ----- BST Pair , count all bST, largest BST and its size----------------------------------------
public class BSTPair{
    boolean isBST=true;
    int count =0;
    int size =0 ;
    Node root; // as we have to save largest root node
    int minofmax = -1e6;
    int maxofmin = 1e6;
    BSTPair(){

    }
}
// public static boolean isValidBST(Node node){
//     if(node == null){
//         return true;
//     }

// }

public static BSTPair BSTsoln(Node node  ){
    if(node == null){
        return new BSTPair();
    }
    BSTPair lp = BSTsoln(node.left);
    BSTPair rp = BSTsoln(node.right);

    // new BST pair 
    BSTPair sol = new BSTPair();
    // count of all bst phele hi hoga
    sol.count = rp.count + lp.count;
    if(lp.isBst && rp.isBST && lp.maxofmin < node.data && rp.minofmax>node.data){
        sol.isBST = true;
        sol.count++;
        // ye islie kyuki iska itna size hoga
        sol.size = sol.count;
        sol.root = node;
    }else{
        sol.isBST = false;
        // else likhna islie zarrrri hai suppose sabse upr wala bst ni hua . to neche ki info ko store
        // karke rkhe aur last mei jb hm return node kare to vo vali stored info dede
        if(lp.size>rp.size){
            sol.size =lp.size;
            sol.root = lp.root;
        }
        else{
            sol.size = rp.size;
            sol.root = rp.root;
        }
    }
    sol.minofmax = Math.min(node.data , Math.min(lp.minofmax, rp.minofmax));
    sol.maxofmin = Math.max(node.data , Math.max(lp.maxofmin, rp.maxofmin));
    return sol;
}
// -- LINEAR TREE ---------
public static Node lineartree(Node node){
    if(node == null){
        return null;
    }
    if(node.left == null && node.right == null){
        // mtlb vo ek perfect leaf hai 
        return node;
    }
    Node leftTail = lineartree(node.left);
    Node rightTail = lineartree(node.right);

    // dono ek mangwaye
    // agar left tail kuch ni hai to as it is node.left mei jake lag jao 
    if(leftTail == null){
        node.left = node.right;
        // node ka left bhi null hi hoga
    }
    else{
        leftTail.left = node.right;
    }
    node.right =null;
    // kyuki node right wala kisis ko point nhi karega
    return rightTail!=null?rightTail:leftTail;
}
// convert into doubly linked list -----------------------------------------------------
static Node prev_ = null;
static Node head  = null;
public static void DLL(Node node){
    if(node ==null){
        return ;
    }
    DLL(node.left);
    if(prev_ == null){
        head= node;
    }
    else{
        prev_.right = node;
        node.left = prev;

    }
    prev= node;

}
//---- PATH SUM 1 (lc-112) -------------------------------------------------------
  // sumpath(node->leaf ) = target
  public static boolean sumpath1(Node node , int target, String ans){
      if(node == null){
          return false;
      }
      if(node.left == null && node.right == null && node.data-target==0){
          return true;
      }
      boolean res = false;
      res  = res || sumpath1(node.left, target-node.data, ans+node.data);
      res = res || sumpath1(node.right , target-node.data , ans + node.data)
      return res;
  }
  // -----  print all paths that make that target---------------
  public static  ArrayList<ArrayList<Integer>> sumpath2_01(Node node , int target){
      if(node == null){
          return null;
      }
      // leaf condition
      if(node.left == null && node.right==null && node.data-target==0){
          ArrayList<ArrayList<Integer>> base = new ArrayList<>();
            ArrayList<Integer> base1 = new ArrayList<>();
            base1.add(node.data);
            base.add(base1);
          return base;
      }
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      ArrayList<ArrayList<Integer>> left = sumpath2_01(node.left, target-node.data);
      if(left!=null){
          for(ArrayList<Integer> i : left){
            i.add(node.data);
            ans.add(i);
          }
      }
      ArrayList<ArrayList<Integer>> right = sumpath2_01(node.right, target-node.data);
      if(right!=null){
          for(ArrayList<Integer> i : right){
            i.add(0,node.data); // ye O{n} ka kaam hai . kyuki aaage aad karva rhe hai
            ans.add(i); // o(1) ka kaam because refernece hi copy karrhe hai
          }
      }
      return ans;
  }
  
}