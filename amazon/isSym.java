package amazon;

public class isSym {
    public boolean isSym(TreeNode root1 , TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
            
        }
        if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val == root2.val){
            return isSym(root1.left, root2.right)  && isSym(root1.right , root2.left);
        }
    return false;
    
}
public boolean isSymmetric(TreeNode root) {
    if(root.left == null && root.right == null) return true;
   return isSym(root.left , root.right);
}
    public static void main(String[] args) {
        
    }
}
