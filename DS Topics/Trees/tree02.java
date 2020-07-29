public class tree02 {
    static int max = -1e6;
    public int maxPathSum(TreeNode root) {
        if(root == null ) return 0;
        if(root.left == null && root.right == null){
            return root.val;
        }
        int left  = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        // int temp1 = Math.max(right , left);
        int temp2 = Math.max(left+root.data,right+root.data);
        max = Math.max(max, temp2);
        max = Math.max(max , left+right+root.data);
        max = Math.max(max , root.data);
        return temp1;
    }
}