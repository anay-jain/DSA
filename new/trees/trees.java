import javax.swing.tree.TreeNode;

import org.w3c.dom.Node;

import java.util.*;
public class trees{
    Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        String s = scn.nextInt();
    }

    static HashMap<TreeNode,TreeNode> hm = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    // create a hashmap
       
       createParentHashMap(root , null );
    // level order
    HashSet<TreeNode> hs = new HashSet<>();
      Queue<TreeNode> que = new LinkedList<>();
      que.add(target);
    while(que.size() != 0){
        int size = que.size();
        int level =0;
        while(size --> 0)
        {
            TreeNode node = que.remove();

            if(node.left != null && !hs.contains(node.left)) {
                que.add(node.left);
                hs.add(node.left);
            }
            if(node.right != null  && !hs.contains(node.right))
            {
                que.add(node.right);
                hs.add(node.right);
            }
            if(hm.get(node)!=null && !hs.contains(hm.get(node))){
                que.add(hm.get(node));
                hs.add(hm.get(node));
            }
            level++;

        }
        if(level==k){
            break;
        }
    }
    while(que.size()!=0){
        System.out.print(que.remove())+ " ";
    }

    }
    public static void createParentHashMap(TreeNode root , TreeNode parent){
        if(root == null) return;
        //  set my parent and then call my childs
        hm.put(root, parent);
        createParentHashMap(root.left, root);
        createParentHashMap(root.right, root);

    }
}