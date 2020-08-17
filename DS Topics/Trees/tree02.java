import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class tree02 {
    static int max = -1e6;
    public int maxPathSum(TreeNode root) {
        int left = maxPathSum_(root.left);
        int right = maxPathSum_(root.right);
        int temp = Math.max(left , right);
        int temp1 =  Math.max(temp+root.val , root.val);
        int temp2 = Math.max(root.val+left+right,temp1);
        max = Math.max(temp2 ,max );
        return temp1;

    }
    static HashMap<TreeNode, TreeNode> hm = new HashMap<>();
    public List<Integer> distanceK(TreeNode node, TreeNode target, int K) {
         if(node == null) return new ArrayList<>();
         findparent(node, null);
         Queue<TreeNode> que = new LinkedList<>();
         HashSet<TreeNode> hs = new HashSet<>();
         que.add(target);
         hs.add(target);
         int level=0;
         while(que.size()>0){
             int size = que.size();
             if(level==K) break;
             while(size-->0){
                 TreeNode tn = que.remove();
 
                 if(tn.left != null && hs.contains(tn.left)==false){
                     que.add(tn.left);
                 }
                 if(tn.right != null && hs.contains(tn.right)==false){
                     que.add(tn.right);
                 }
                 TreeNode p = hm.get(tn);
                 if(p != null && hs.contains(p)==false){
                     que.add(p);
                 }
                 hs.add(tn);
             }
             level++;
         }
         List<Integer> li = new ArrayList<>();
         while(que.size()>0){
             TreeNode tn = que.remove();
             li.add(tn.val);
         }
         return li;
     }
 
     public static void findparent(TreeNode node,TreeNode par){
         if(node==null) return;
         hm.put(node,par);
         par = node;
         findparent(node.left, par);
         findparent(node.right, par);
     }

     // lc 1038 
     static int sum =0;
     public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        TreeNode(root.right);
        root.val += sum;
        TreeNode(root.left);
    }
    // lc 199
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> que =  new LinkedList<>();
        que.add(root);
        List<Integer> li = new ArrayList<>();
        while(que.size()>0){
            int size = que.size();
            while(size==0){
                TreeNode rnode = que.remove();
                if(rnode.left!=null) que.add(rnode.left);
                if(rnode.right!=null) que.add(rnode.right);
                if(size==1) li.add(que.peek().val);
                size--;
            }
        }
        return li;
    }

    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> li = new ArrayList<>();

        que.add(root);
        while(que.size()>0){
            int size= que.size();
            List<Integer> arr = new ArrayList<>();
            while(size-->0){
                TreeNode rnode = que.remove();
                arr.add(rnode.val);
                if(rnode.left!=null) que.add(rnode.left);
                if(rnode.right!=null) que.add(rnode.right);
            }
            Collections.sort(arr);
            li.add(arr);
        }
        return li;
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        
        TreeNode ans = null ;
       // first find ans that is its immediate parent if the node movel
   
      while(root!=null){
       if(root.val == p.val){
           p =  root;
           break;
       }   
       else if(p.val < root.val){
             ans = root;
              root = root.left;
            
           }
       else{
              root = root.right;
              
          }
      }
      if(p.right !=null){
          // then find the left most of the right child 
          TreeNode rt = p.right;
          while(rt.left!=null){
               rt = rt.left;

           }
           return rt;    
      }
      else{
          return ans;
      }

    }
    public void addLeaves(TreeNode root , List<Integer> li){
        if(root == null) return;
        addLeaves(root.left);
        if(root.left == null && root.right == null) li.add(root.val);
        addLeaves(root.right);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            if(root == null) return new ArrayList<>();
            // print root \
            List<Integer> li = new ArrayList<>();
            li.add(root.val);
            if(root.left !=null){
                TreeNode lt = root;
                while(lt.left.left!= null){
                  
                    lt= lt.left;
                    li.add(lt.val);
                }
            }
            // print all leaves
            addLeaves(root,li);
            // now print right boundary
            if(root.right!=null){
                TreeNode tr = root;
                while(rt.right.right != null){
                    rt = rt.right;
                    li.add(tr.val);
                }
            }
            return li;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;

            // we will work in post order
            TreeNode leftDone =  lowestCommonAncestor(root.left, p, q);
            TreeNode rightDone = lowestCommonAncestor(root.right, p, q);
            if(root.val == p.val || root.val == q.val) return root;
            if(leftDone!=null && rightDone!=null)
                return root;
            else if (leftDone != null ) return leftDone;
            else return rightDone;
            
            
            }


// ------------------------------------------------------------------------------------------            
             
            // LCA -> o(h) solution
            static HashMap<TreeNode , TreeNode> hmp = new HashMap<>();
            static HashMap<TreeNode, Integer> hml = new HashMap<>();
            
            // preprocessing of nodes to make our parent and levvel hashmap

            public TreeNode traversalPreprocessing(TreeNode root , TreeNode parent , int level ){
                    if(root == null) return  null;
                    hmp.put(root, parent);
                    hml.put(root, level);
                    traversalPreprocessing(root.left, root, level+1);
                    traversalPreprocessing(root.right, root, level+1);
            }

            public TreeNode lowestCommonAncestor02(TreeNode root , TreeNode p ,TreeNode q ){
            // using  hashmap of parrent and level
            if(root == null) return null;
            int levelp = hml.get(p);
            int levelq = hml.get(q);

            if(levelp > levelq){
                while(levelp!=levelq){
                    p = hmp.get(p);
                    levelp=hml.get(p);
                }

            }
            else if(levelq > levelp){
                while(levelp!=levelq){
                    q = hmp.get(q);
                    levelq=hml.get(q);
                }
            }
            while(p!=q){
                p = hmp.get(p);
                q = hmp.get(q);

            }

            return p;


        }

// leetcode 979 distribute coins in binary tree
static int transfer=0;
public int distributeCoins_(TreeNode root){
    if(root == null) return 0;

int left  = distributeCoins_(root.left);
int right = distributeCoins_(root.right);       
int ans =  left+right + root.val -1;
transfer += Math.abs(left);
transfer += Math.abs(right);
return ans;
}
public int distributeCoins(TreeNode root) {
transfer=0;
distributeCoins_(root);
return transfer;

}
    // leeetcode 450  delete node from bst
    public TreeNode deleteNode_(TreeNode root){
        if(root.left == null && root.right == null){
            // if both are null
            return null;
        }
        else if(root.left == null){
            return root.right;
        }
        else if (root.right == null){
            return root.left;
        }
        else{
            // left subtree of root to be placed at left most of the right subtree
            TreeNode rn = root.right;
            while(rn.left!=null) rn = rn.left;
            rn.left = root.left;
            return root.right;
        }
    }
    
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)  return null;
        if(root.val == key){
            return  deleteNode_(root);
        }
        if(root.val>key){
            root.left = deleteNode(root.left, key);
        
        }
        else{
            root.right = deleteNode(root.right, key);
        }        
        return root;
    }

    // 105 construct binary tree from inorder and preoder 
    
        static HashMap<Integer, Integer> hmmp = new HashMap<>();
        public TreeNode buildTree_(int[] preorder , int[] inorder , int ps , int pe , int is , int ie  ){
            if(ps>pe || is > ie ) return null;
            // first ele of preorder will be the root
            TreeNode root = new TreeNode(preorder[ps]);
            // get the index of the hashMap
            int idx = hmmp.get(root.val);
            int count = (idx-1) - ps + 1;
            root.left = buildTree_(preorder, inorder, ps+1, ps+count, is, idx-1);
            root.right = buildTree_(preorder, inorder, ps+count+1, pe, idx+1, ie);
            return root;
        
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // make hashmap to store ele and their index

            for(int i =0;i<inorder.length;i++){
                hmmp.put(inorder[i],i);
            }
            int n = preorder.length ;
            return buildTree_(preorder, inorder, 0, n, 0, n);
    }

}