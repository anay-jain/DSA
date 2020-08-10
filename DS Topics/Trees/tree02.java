import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public void bs
    
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
       TreeNode ans = null ;
       while(true){
           
       }
    }
}