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
    public int k
}