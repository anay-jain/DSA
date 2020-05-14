import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

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
        // int[] arr1 = {10,20,30,40,50,60,70,80,90};
        // Node root1 = makeBST(arr1, 0, arr1.length-1);
        // display(root1);
        // Node BST_node  = BST_LCA(root1, 10, 90);
        // System.out.println(BST_node.data);
        // ArrayList<ArrayList<Integer>> myAns = new ArrayList<>();

        // pathSum2_02(root, 60, new ArrayList<Integer>(), myAns);
        // for(ArrayList<Integer> i: myAns){
        //     for(int j:i){
        //         System.out.print(j+ " ");
        //     }
        //     System.out.println("");
        // }
        // leafToLeafMaxSum(root);
        // System.out.println(maxSum);
        // boundaryView(root);
        // verticalOrder_01(root);
        rangeBST(root, 30, 70);
        
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
// Diameter 3 ways---------------------------------------------------------------

public static int Diameter_01(Node node){
    // dia is in terms of edges
    if(node == null){
        return 0;
    }
    int  lh = height(node.left);
    int rh =height(node.right);
    int maxSide = Math.max(lh,rh)+1;
    return Math.max(maxSide, lh+rh+2);

    
}

static int maxdia =0;
public static int diameter_02(Node root){
    if(root == null){
      return -1;
  }
  int lh = diameter_02(root.left);
  int rh = diameter_02(root.right);
  maxdia = Math.max(maxdia , lh+rh+2);
  return Math.max(lh,rh)+1;
}
public static int[] diameter_03(Node node){
    if(node == null){
        return new int[]{0,-1};
    }
    int[] ld = diameter_03(node.left);
    int[] rd = diameter_03(node.right);

    int[] ans = new int[2];

    ans[0] = Math.max(Math.max(ld[0], rd[0]), ld[1] + rd[1] + 2); //isme diameter
    ans[1] = Math.max(ld[1], rd[1]) + 1; // iske andr hm apni height store kar rhe hai

    return ans;
}
// ---- Binary tree max path sum---------------------------------------------------------------
public static int nodeToNodeMaxSum(Node node) {
    if (node == null)
        return 0;

    int leftsum = nodeToNodeMaxSum(node.left);
    int rightsum = nodeToNodeMaxSum(node.right);
    
    int sideMax = Math.max(leftsum, rightsum) + node.data;
    maxSum = Math.max(Math.max(maxSum, sideMax), Math.max(leftsum + rightsum + node.data, node.data));

    return Math.max(sideMax, node.data);
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

    // -----LCA   2 methods  ----------------------------------------------------------------------
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
  static Node lca_node = null;
  public static boolean lca_02(Node node , int p , int q){
      if(node==null){
          return false;
      }
      boolean selfDone = node.data==p || node.data==q;
      boolean left = lca_02(node.left, p, q);
      if(lca_node != null){
          return true;
      }
      boolean right = lca_02(node.right, p, q);
      if(lca_node != null){
          return true;
      }

      if((left&& right ) || (left && selfDone) ||(right && selfDone )){
         lca_node= node;
      } 
      return left|| right|| selfDone;

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
static int prev  = (int)-1e6; 
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
public static class BSTPair{
    boolean isBST=true;
    int count =0;
    int size =0 ;
    Node root; // as we have to save largest root node
    int minofmax = (int)-1e6;
    int maxofmin = (int)1e6;
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
    if(lp.isBST && rp.isBST && lp.maxofmin < node.data && rp.minofmax>node.data){
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
static Node head  = null; // ye circular mei kaaam aayega
public static void DLL(Node node){
    if(node ==null){
        return ;
    }
    DLL(node.left);
    if(prev_ == null){
        head= node; // for circular DLL
    }
    else{
        prev_.right = node;
        node.left = prev_;
 
    }
    prev_= node;
    // vo apne aap ko change karke reight ki cl lagayega ... 
    DLL(node.right);

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
      res = res || sumpath1(node.right , target-node.data , ans + node.data);
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
  public static void pathSum2_02(Node node , int tar , ArrayList<Integer> small , ArrayList<ArrayList<Integer>> ans){
      if(node == null){
          return ;
      }
      if(node.right == null && node.left== null && node.data-tar==0){
          ArrayList<Integer> base = new ArrayList<Integer>(small);
          // this will copy small to base(deep copy);
          base.add(node.data);
          ans.add(base);
          return;

      }
      // ate wqt small me add karo
      small.add(node.data);
      pathSum2_02(node.left, tar-node.data, small, ans);
      pathSum2_02(node.right, tar-node.data, small, ans);
      small.remove(small.size()-1);
  }
  static int maxSum =0;
  public static int leafToLeafMaxSum(Node node){
      int lsum =0 , rsum=0;
      if(node == null){
          return 0;
      }
           lsum = leafToLeafMaxSum(node.left);
           rsum = leafToLeafMaxSum(node.right);
          if(lsum != -1 && rsum!=-1){
              maxSum = Math.max(maxSum , lsum+rsum+node.data);
          }
  
      
      return Math.max(lsum , rsum )+node.data;
  
  }
  // --------------------------------------------------------------------------------------------
  public static Node makeBST(int[] arr , int si , int li){
    if(li<si){
        return null;
    }
    int mid = (li+si)>>1; // si+(ei-si)/2 -> to manage overflow
    // System.out.println(si +" "+mid + " "+ li);
    Node root = new Node(arr[mid],null,null);
    root.left = makeBST(arr, si, mid-1);    
    root.right = makeBST(arr, mid+1, li);

    return root;
  }
  public static Node  addNodeInBST(Node node, int data){
      if(node == null){
          Node root = new Node(data , null , null);
          return node;
      }
      if(data<node.data){
          node.left = addNodeInBST(node.left,data);

      }
      else{
          node.right = addNodeInBST(node.right, data);
      }
      return node;
  }

  public static Node remove(Node node , int data){
    // first find data
    if(node.data>data){
        node.left = remove(node.left, data);
    }
    else if(node.data<data){
        node.right = remove(node.right,data);
    }
    else{
        // data is equal
        // 3rd condn and 2nd 
        if(node.left==null || node.right ==null){
            // hmr 3rd condition mei hi null return karna gota hai
            // parent ko hi hum node ka left aur right child return kar skte hai
            return node.left==null?node.right:node.left;
        }
        // 1st condtion
        Node rdata = findMaxInBst_forremove( node.left);
        node.data = rdata.data;

        node.left = remove(node.left, rdata.data);
    }
    return node;
  }
  Node FindMaxPrev(Node node){
      if(node== null)
      return null;
      Node prev =null;
      Node rnode = node;
      while(rnode.right == null){
          prev = rnode;
          rnode=rnode.right;
      }
      return prev;
  }


  // Swap ele to make it bst
  static Node x , y , z;

  // z will be our prev
  public static boolean swapBst(Node node){
    if(node == null){
        return false;

    }
    boolean res = false;
    res = res || swapBst(node.left);
    if(z!= null && z.data >node.data){
        y = node;
        if(x==null){
            x = z;
        }
        else{
            return true;
        }
       
        
    } 
    z=node;
    res = res || swapBst(node.right);
    return res;

  }
  // --- Preoder to BST TREE------------------------------------------------------

  static int Preorder_idx=0;
  public static Node preorderToBst(int[] arr ,  int lb , int ub){
      if(Preorder_idx>=arr.length || arr[Preorder_idx] <lb || arr[Preorder_idx]>ub ){
          return null;
      }
      Node nnode = new Node(arr[idx],null,null);
      Preorder_idx++;
      if(Preorder_idx<arr.length){
          nnode.left = preorderToBst(arr, lb, arr[idx]);
      }
      if(Preorder_idx<arr.length){
          nnode.right = preorderToBst(arr, arr[idx] , ub);
      }
      return nnode;
  }

  // height of BST traveral----------------------------------------------
  static int height_idx=0;
  public static int heightFromBstPreorder(int[] arr , int lb , int ele , int ub){
      if(height_idx== arr.length || ele<lb || ele>ub){
          return 0;
      }
      int ele_ = arr[height_idx];
      height_idx++;
      int lh = 0, uh=0;
      if(height_idx<arr.length ){
          lh  = heightFromBstPreorder(arr, lb, arr[idx],ele_ );
        
      }
      if(height_idx<arr.length ){
        uh  = heightFromBstPreorder(arr, ele_, arr[idx],ub);
      
    }
    return Math.max(lh,uh)+1;
  }
  // jb divergence condition hogi thats our ans;
  // ---- Traversal and views -----------------------------------------------------------
  static int level_=-1;
  public static void leftView_01(Node node, int level){
    if(node == null){
        return;
    }
    leftView_01(node.left, level+1);
    leftView_01(node.right, level+1);
    if(level!=level_){
        System.out.print(node.data);
        level_=level;
    }
  // right view ke lie call ko swap kardo bas  
  }

  public static void leftView_02(Node node){
    
      LinkedList<Node> que = new LinkedList<>();
      que.add(node);
      int level=0;
      while(!que.isEmpty()){
          int size = que.size();
          Node prev = null;
          while(size-->0){
              Node rnode = que.removeLast();
              if(prev == null){
                  System.out.print(rnode.data);
                  prev = rnode;
              }
              if(node.left!=null)
              que.addFirst(node.left);
              if(node.right != null)
              que.addFirst(node.right);
          }
          level++;
      }
  }
public static void boundaryView(Node node){
    LinkedList<Node> que = new LinkedList<>();
    que.addLast(node);
    que.addLast(null);
    Node prev = null;
    int level =0;
    while(que.size()>1){
        Node rnode = que.removeFirst();
        if(rnode.left !=null){
            que.addLast(rnode.left);
        }
        if(rnode.right !=null)
        que.addLast(rnode.right);
        if(prev == null && level !=0 && que.size()>1){
            System.out.print(rnode.data+" ");
            prev= que.peekFirst();
        }
        if(que.peekFirst()==null){
            level++;
            prev = null;
            que.addLast(null);
            que.removeFirst();
            System.out.print(rnode.data+" ");
            System.out.println("");
        }
    }

}
  public static boolean findNodeInBst(Node node , int data){
      if(node==null){

          return false;
      }
      if(node.data == data){
          return true;
      }
      if(node.data>data){
          return findNodeInBst(node.left, data);
      }
      if(node.data<data){
        return  findNodeInBst(node.right, data);
      }
     return false;
  }
  public static Node BST_LCA(Node node , int a  , int b){
      // as hme LCA node return karna hai
      if(node.data<a){
        return BST_LCA(node.right, a, b);
      }
      if(node.data>b){
          return BST_LCA(node.left, a, b);
      }
      // divergence condition
      else{
          if(findNodeInBst(node, a) == true && findNodeInBst(node, b)==true){
              return node;
          }
          return null;
      }
     }
  public static Node findMaxInBst_forremove(Node node){
      // left ki sabse max value jo hme milegi node right par
      while(node.right!=null){
         return  findMaxInBst_forremove(node.right);
      }
      return null;
  }
 // bottm views -------------------------------------------------------------------------------
 public static void width_03(Node node , int level , int[] ans){
     if(node == null){
         return ;
     }
     ans[0] = Math.min(ans[0] , level);
     ans[1] = Math.max(ans[1] , level);
     width_03(node.left ,level-1, ans);
     width_03(node.right, level+1, ans);

 }
 // in this we make static width 

  // -- vertical order View 2 ways-----------------------------------------------------------
  public static class verticalPair{
      Node node = null ;
      int level =0;
      verticalPair(Node node , int level){
          this.node = node;
          this.level=level;
      }
  }
  public static void verticalOrder_01(Node node){
      if(node == null){
          return;
      }
      HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
      LinkedList<verticalPair> que = new LinkedList<>();
      verticalPair vpair = new verticalPair(node, 0);
      que.addLast(vpair);
      ArrayList<Integer> base = new ArrayList<>();
      base.add(node.data);
      map.put(0, base);
      int minlevel = 0 , maxlevel = 0;
      while(!que.isEmpty()){
          int size = que.size();
          while(size-->0){
              verticalPair rpair = que.removeFirst();
              int level = rpair.level;
              maxlevel = Math.max(maxlevel, level);
              minlevel = Math.min(minlevel, level);
              if(rpair.node.left!=null){
                  que.addLast(new verticalPair(rpair.node.left, level-1));
                  ArrayList<Integer> left =  map.getOrDefault(level-1, new ArrayList<>());
                  left.add(rpair.node.left.data);
                  map.put(level-1, left);
                //   System.out.println(left+ " "+level);
              }
              if(rpair.node.right != null){
                  que.addLast(new verticalPair(rpair.node.right, level+1 ));
                  ArrayList<Integer> right =  map.getOrDefault(level+1, new ArrayList<>());
                  right.add(rpair.node.right.data);
                  map.put(level+1, right);
                //   System.out.println(right+ " "+level);


              }

          }
      }
      for(int i=minlevel; i<=maxlevel;i++){
        ArrayList<Integer> arr = map.get(i);
        // System.out.println(i);
        // System.out.println(arr);
        // System.out.println(map.keySet());
        if( arr.size()>0){
            for(int itr : arr){
            System.out.print(itr+ " ");
        }
        System.out.println("");
        }
        
      }

  }
  static int maxlevel1 =0 ;
  static int minlevel1 = 0;
public static void width(Node node , int level){
    if(node == null){
        return ;
    }
    minlevel1 = Math.min(minlevel1 , level);
    width(node.left, level-1);
    width(node.right, level+1);

}
public static void verticalOrder_02(Node node){
    if(node == null){
        return;

    }
    width(node , 0);
    // rtather than making a class make 2 que 
    LinkedList<Node> que1 = new LinkedList<>();
    LinkedList<Integer> que2 = new LinkedList<>();
    // similar as class jisme ek node aur level hota
    ArrayList<Integer>[] arr = new ArrayList[maxlevel1-minlevel1];
    que1.add(node);
    que2.add(-minlevel1); // to map 0
    // arr[-minlevel1].add(node.data);
    while(que1.size()>0){
        int size = que1.size();

        while(size-->0){
            Node rnode = que1.removeFirst();
            int rdata = que2.removeFirst();
            arr[rdata].add(rnode.data);
            if(rnode.left!=null){
                que1.addLast(rnode.left);
                que2.addLast(rdata-1);
            }
            if(rnode.right!=null){
                que1.addLast(rnode.right);
                que2.addLast(rdata+1);
            }
            
        }
    }
}
// find range BST
public static void rangeBST(Node node, int a , int b){
    if(node == null){
        return ;
    }
    if(
        node.data<a){
        // right side lie karegs
        // node.data<a<b;
        rangeBST(node.right, a ,b);
    }
    else if(node.data>b){
        rangeBST(node.left, a, b);

    }
    else{
        System.out.print(node.data);
        rangeBST(node.left, a, b);
        rangeBST(node.right,a , b);
    }

}
// width Another method
public static int width_02(Node node, boolean isLeftWidth){
    if(node == null){
        return -1;
    }
    int lw = width_02(node.left, isLeftWidth)+ (isLeftWidth?1:-1);
    int rw = width_02(node.right, isLeftWidth) + (isLeftWidth?-1:1);
    return Math.max(lw, rw);
}
// Diagonal print
// public static void diagonalPrint(Node node){
//     if(node == null){
//         return;

//     }
//     int lh = width_02(node, true);
//     int[] arr  = new int[lh];
//     diagonalPrint(node);
// }

// Vertical order Sum (Doubly LinkedList Solution)-------------------------------------------
public static class LLnode{
    int data =0;
    LLnode next = null;
    LLnode prev  = null;
    LLnode(int data){
        this.data = data;
    }
}
static LLnode head_ = null;
static LLnode tail_ = null;
public static void verticalSum_03(Node node){
    // setting up head and tail 
//     static LinkedList<LLnode> dll = new LinkedList<>();
// static Node head_ = null
// static Node tail_ = null;
// rather than making them null , we can make them point to sinngle node to manage excpetns
    LLnode lnode  = new LLnode(0);
    head_ = lnode;
    tail_ = lnode;
    verticalSum_03_(node , lnode);
    // data display below
}


public static void verticalSum_03_(Node node , LLnode lnode){

    // sabse phele aake preorder mei apne app ko add karenge
    lnode.data += node.data;
    if(node.left!=null){
        if(lnode.prev== null){
            // ll node -> creation
            lnode.prev = new LLnode(0);
            head_ = lnode.prev;
            lnode.prev.next = lnode;

        }
        verticalSum_03_(node.left , lnode.prev);
    }
    if(node.right != null){
        if(lnode.next==null){
            lnode.next = new LLnode(0);
            lnode.next=tail_;
            lnode.next.prev = lnode;

        }
        verticalSum_03_(node.right, lnode.next);
    }
}
// Leetcode(968) -> BINARY TREE CAMERAS-------------------------------------------------------
// static int min_cameras=0;
// public static int binarytreecamera(Node node ){
//     int bleft = binarytreecamera(node.left);
//     int bright = binarytreecamera(node.right);
//     // 1 -> i have camera
//     // 0 -> i am covered by my child
//     // -1 -> i need camera
//     if( bleft ==-1|| bright ==-1){

//         min_cameras++;
//         return 1;
//     }
//     if(bleft==1 || bright==1){
//         return 0;
//     }
//     if(bleft ==0 || bright == 0 ){
//         if()
//     }
// }

//------ 508 MOst frequent subarray sum--------------------------------------------------
static HashMap<Integer,Integer> map = new HashMap<>();
static int maxfreq =0;
// public static int[] mostFrequentsum_(Node node){
//     if(node == null){
//         return new int[0];
//     }
//         mostFrequentsum(node);
//         int count =0;
//         for(Integer key: map.keySet()){

//         }
// }
// public static int mostFrequentsum(Node node){
//     if(node == null){
//         return 0;
//     }
//     int sum = mostFrequentsum(node.left)+ mostFrequentsum(node.right)+ node.data;
//     map.put(sum, map.getOrDefault(sum, 0)+1);
//     maxfreq = Math.max(maxfreq, map.get(sum));
//     return sum; 
// }
// public void morrisTraversalInorder(Node node){
//     Node curr = node;
//     while(curr != null){
//         Node next = curr.left;
//         if(next== null || next.right==curr){
//             // agar uska koi left child nahi h to . print the node
//             if(next==null){
//             System.out.print(curr.data);
//             continue;
//             }
//             System.out.print(next.right);
//             next.right=null;
//             curr = curr.right;
//         }
//         else{
            
//         }
//     }
// }
class traversal{
    Node node=null;
    boolean selfDone = false;
    boolean leftDone = false;
    boolean rightDone = false;
    traversal(Node node){
        this.node = node;
    }
}
public void traversalPreOrder(Node node ){
    Stack<traversal> st = new Stack<>();
    st.push(new traversal(node));
    while(!st.isEmpty()){
        traversal rpair = st.peek();
        if(rpair.selfDone==false){
            System.out.println(rpair.node.data);
            rpair.selfDone= true;
        }
        else if(rpair.leftDone == false){
            rpair.leftDone = true;
            if(rpair.node.left !=null){
                st.add(new traversal(rpair.node.left));
            }
        }
        else if(rpair.rightDone == false){
            
        }
    }
     
}
   
}