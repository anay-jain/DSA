public class trieImpl {
    static class Trie{
        Trie[] trie;
        boolean flag;
        Trie(Trie[] trie , boolean flag){
            this.trie = trie;
            this.flag = flag;
        }
    }
        // Initialize trie
        Trie root;
        trieImpl(){
            root = new Trie(new Trie[26], false);
        }
        
        public void insert(String s){
            if(s.length()==0)return;
            Trie root1 = root;
            Trie node;
            for(int i =0;i<s.length();i++){
                int idx = (int)s.charAt(i)-'a';
                
               
                if(root1.trie[idx] == null){

                    node = new Trie(new Trie[26] , false);
                    root1.trie[idx] = node;
                }
                else{
                    node = root1.trie[idx];
                }
                if(i==s.length()-1){
                    node.flag = true;
                }
                root1 = node;
            }
        }
        private boolean ifWordExists(String s ,int i, Trie root1){
            if(i==s.length()) {
               return root1.flag ;
            }
            boolean ans = false;
            if(s.charAt(i)=='.'){
                for(int j =0;j<26;j++){
                    if(root1.trie[j]!=null)
                     ans = ifWordExists(s, i+1, root1.trie[j]);
                    if(ans==true) return true;
                }          
            }
            else{
                int idx =(int)s.charAt(i)-'a';
                if(root1.trie[idx]!=null){
                    ans = ifWordExists(s, i+1, root1.trie[idx]);
                }
                if(ans==true) return true;
            }
            return false;
    }
        public boolean search(String s){    
            if(s.length()==0) return false;
            Trie root1 = root;
            return ifWordExists(s, 0, root1) ;
        }
    
    public static void main(String[] args) {
        trieImpl t = new trieImpl();
        t.insert("anay");
        t.insert("an");
        System.out.println(t.search("a.a."));
    }
}
