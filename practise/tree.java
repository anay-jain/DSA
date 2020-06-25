import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
public class tree{
	 static class Node{
		int data ;
		Node left = null;
		Node right = null;
		Node(int data){
			this.data = data;
		}
	}
	static int idx = 0;
	public static Node construct(int[] arr){
		if(arr[idx]==-1 || idx== arr.length){
			idx++;
			return null;
		}
		Node node = new Node(arr[idx]);
		idx++;
		node.left = construct(arr );
		node.right = construct(arr);
		return node;
	}
	public static void display(Node node){
			if(node==null) return;
			String s = "";
			s += node.left==null?".":node.left.data;
			s+="< - ";
			s += node.data;
			s+= " - > ";
			s += node.right==null?".":node.right.data;
			System.out.println(s);
			display(node.left);
			display(node.right);


	}
		public static List<Double> averagelevel(Node root){
			if(root == null) return new ArrayList<>();
			LinkedList<Node> que = new LinkedList<>();
			List<Double> arr = new ArrayList<>();
			que.add(root);
			int level =0;
			while(que.size()>0){
				int size = que.size();
				int t = size;
				double sum =0;
				while(size-->0){
					Node node = que.remove();
					sum+=node.data;
					if(node.left!=null) {que.add(node.left);}
					if(node.right != null) {que.add(node.right);}

				}
				arr.add((double)sum/t);
				level++;

			}
			return arr;
		}


	public static void main(String[] args){

		 int[] arr = { 10, 20, 30, -1, -1, 40, -1, -1, 50, 60, 80, -1, -1, -1, 70, 90, -1, 100, -1, -1, -1 };
		 Node root = construct(arr);
		 display(root);
		 System.out.println(averagelevel(root));
	}
}