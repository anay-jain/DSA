 public static void display(Node node) {
        if (node == null)
            return;
        String ans = "";
        ans += node.left != null ? node.left.data : ".";
        ans += " -> " + node.data + " <- ";
        ans += node.right != null ? node.right.data : ".";
        System.out.println(ans);

        display(node.left);
        display(node.right);
    }

    public static boolean findData(Node node, int data) {
        if (node == null)
            return false;
      