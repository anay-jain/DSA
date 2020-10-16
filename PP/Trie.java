public class TrieBasic{
    public class Node{
        int WordEnd=0;
        Node[] childs;

        Node(){
            this.childs=new Node[26];
            this.WordEnd=0;
        }
    }

    Node root=null;

    public void insert(String word){
        Node curr=root;
        int n=word.length();
        for(int i=0;i<n;i++){
            int idx = word.charAt(i) - 'a';
            if(curr.childs[idx]==null) curr.childs[idx]=new Node();

            curr=curr.childs[idx];
        }
        