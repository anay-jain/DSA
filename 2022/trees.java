import java.util.ArrayList;
import java.util.List;

public class trees {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null ) return new List<>();
        List<Integer> ans = new List<>();
        List<Integer> left =  inorderTraversal(root.left);
        if(left.size()!=0) 
        for(int i =0;i<left.size();i++){
            ans.add(left.get(i));

        }
        ans.add(root.val);
        if(right.size()!=0) 
        for(int i =0;i<right.size();i++){
            ans.add(right.get(i));
        }
        return ans;
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // find ele
        if(root == null) return null;
        TreeNode curr = root;
        TreeNode inorder = null;
        while(curr!=null && curr!=p ){
            if(curr.val > p.val){
                inorder = curr;
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }
        if(curr == null) return null;
        if(p.right !=null){
            if(p.right.left!=null){
            TreeNode curr1 = p.right.left;
            while(curr1.left != null){
              curr1 = curr1.left; 
            
            }
            return curr1;
        }
        else{
            return p.right;
        }
        }
        return inorder;
        // write your code here
    }


    public static ArrayList<Integer> leftBoundary(Node node){
        if(node == null) return new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();

        while(node.left.left != null){
            ans.add(node)
       }

        
    }
    public static ArrayList <Integer> boundary(Node node)
	{
	    if(node == null) return new ArrayList<>();
        // left boundary
        ArrayList<Integer> left = leftBoundary(node.left);
    
    }
    static int moves =0;
    public int distributeCoins_(TreeNode root) {
        if(root == null) return 0;

        int leftCoins = distributeCoins_(root.left);
        int rightCoins = distributeCoins_(root.right);
        int myCoins = root.val;
        moves += Math.abs(leftCoins) + Math.abs(rightCoins);
        return leftCoins+rightCoins+myCoins-1;
    }
    public int distributeCoins(TreeNode root) {
        moves=0;
        distributeCoins_(root);
        return moves;
        
        }      

        public TreeNode deleteNode_(TreeNode root){
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left!=null && root.right != null){
                // first find the smallest in the right subtree
                TreeNode curr = root.right;
                while(curr.left!=null){
                    curr= curr.left;
                }
                curr.left= root.left;
                return root.right;
            }
            if( root.left != null){
                return root.left;
            }
  

                return root.right;
            

        }
        public TreeNode deleteNode(TreeNode root, int key) {
        
            if(root.val == key){
                root = deleteNode_(root);
            }
            else if(root.val >key){
               root.left =  deleteNode(root.left, key);
            }
            else{
               root.right=  deleteNode(root.right, key);
            }
            return root;
        
        }
        int idx = 0;
        public TreeNode buildTree_(int[] preorder , int[] inorder , int l , int r ){
            if(l>r)return null;
            if(l==r){
                TreeNode node = new TreeNode(preorder[idx]);
                idx++;
                return node;
            }
            int value = preorder[idx];
            TreeNode node = new TreeNode(value);
            idx++;
            int cidx=0;
            for(int i=l;i<=r;i++){
                if(inorder[i]==value){
                    cidx = i;
                }
            }
            node.left = buildTree_(preorder, inorder, l , cidx-1);
            node.right = buildTree_(preorder, inorder, cidx+1, r);
            return node;
        }
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            idx=0;
            return buildTree_(preorder, inorder, 0 , inorder.length-1);
        }

        public TreeNode buildTreepost_(int[] preorder , int[] inorder , int l , int r ){
            if(l>r)return null;
            if(l==r){
                TreeNode node = new TreeNode(preorder[idx]);
                idx++;
                return node;
            }
         
            TreeNode node = new TreeNode();
          
            int cidx=0;
            for(int i=l;i<=r;i++){
                if(inorder[i]==value){
                    cidx = i;
                }
            }
            node.left = buildTreepost_(preorder, inorder, l , cidx-1);
            node.right = buildTreepost_(preorder, inorder, cidx+1, r);
            int value = preorder[idx];
            node.val = value;
            idx++;
            return node;
        }
        public TreeNode buildTreepost(int[] preorder, int[] inorder) {
            idx=0;
            return buildTreepost_(preorder, inorder, 0 , inorder.length-1);
        }
    public static void main(String[] args) {
        
    }
}
