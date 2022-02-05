public class l001{

    public static class linkedlist{
        public class Node{
            int data ;
            Node next =null;
            Node(int data){
                this.data = data;

            }

            // As linked list will have only one head and tail

            Node head= null;
            Node tail = null;

            int size =0;
            public boolean isEmpty(){
                return this.size == 0;

            }
            
            public int size(){
                return this.size();
            }
            @Override
            public String to_String(){
                Node curr = this.head;
                String str = "";
                while(curr!=null){
                    str+=(curr.data+" ->");
                    
                }
                return str;
            }
        }
    }

}