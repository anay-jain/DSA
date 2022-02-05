import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees{
    // leetcode 96 Unique binary search trees
    public static int numTrees(int n) {
        if(n==0 || n==1) return 1;
        if(n==2)return 2;
        
        int sum =0;
        for(int i =1;i<=n;i++){
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
  
    public List<TreeNode> generateTrees(int n) {

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
     if(p == null && q == null){
         return true;

     }   
     if(p == null || q == null){
         return false;
     }
     if(p.val != q.val){
         return false;
     }
     boolean left = isSameTree(p.left  ,q.left);
     boolean right = isSameTree(p.right, q.right);
     return (left && right);
    }

    //  leetcode 102
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null )return new LinkedList<>();
        List<List<Integer>> li = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        List<Integer> base = new LinkedList<>();
        base.add(root);
        li.add(base);
        while(que.size()!=0){
            int size = que.size();
            List<Integer> child = new LinkedList<>();
            while(size-->0){
                
                TreeNode rm = que.removeFirst();
                if(rm.left !=null){
                    que.addLast(rm.left);
                    child.add(rm.val);
                }
                if(rm.right!=null){
                    que.addLast(rm.right);
                    child.add(rm.val);
                }
            }
            li.add(child);
        }
        return li;
    }
    static int count = 1;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null )
        return 0;
        ArrayList<Integer> alLeft = pathSum(root.left, targetSum);
        ArrayList<Integer> alRight = pathSum(root.right, targetSum);
        if(root.val == targetSum) count++;
    
    }
    public static void main(String[] args){
        System.out.println(numTrees(3));
    }
}