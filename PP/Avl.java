public class avl {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        int height = 0;
        int bal = 0;

        Node() {

        }

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null)
      