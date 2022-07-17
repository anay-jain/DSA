package amazon;

public class ifSubtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(isSame(root, subRoot)){
            return true;
        }
        if(root == null)
            return subRoot == root;

        return isSubtree(root.left , subRoot) || isSubtree(root.right ,subRoot);
        }

        public static boolean isSame(TreeNode root , TreeNode subRoot){
            if(root == null && subRoot == null){
                return true;

            }
            if(root == null || subRoot == null){
                return false;
            }
            if(root.val != subRoot.val)
            {
                return false;
            }
            return isSame(root.left, subRoot.left) || isSame(root.right, subRoot.right);    
        }
    }
  
