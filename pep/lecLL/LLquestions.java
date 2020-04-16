public class LLquestions{
    public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
             @Override
             public String toString(){
                 return this.val+"";
             }
        }
 // Leetcode 234 -----------------------------------------------------------------
        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null)return true;
            ListNode node = head;
            ListNode nhead = mid(node);
            ListNode prev = reverse(nhead);
            boolean flag = true;
            while(prev!=null && node!=null){
                if(prev.val != node.val){
                    flag=false;
                    break;
                }
                prev=prev.next;
                node=node.next;
            }
            return flag;
        }   

    // Leetcode 143 -------------------------------------------------------------------------
    public void reorderList(ListNode head) {
        if(head==null || head.next == null )return;
           ListNode n = head;
           ListNode mid = mid(n);
           ListNode nhead = mid.next;
           mid.next=null;
           ListNode nd = reverse(nhead);
           while(n!=null && nd!=null){
               ListNode f = n.next;
               ListNode fd = nd.next;
               n.next=nd;
               nd.next=f;
               nd=fd;
               n=f;
   
           }
       }    
           public ListNode mid(ListNode node){
           ListNode slow = node;
           ListNode fast = node;
           while(fast!=null && fast.next!=null && fast.next.next!=null){
               slow = slow.next;
               fast=fast.next.next;
           }
           return slow;
           }
           public ListNode reverse(ListNode node){
               ListNode prev = null;
               ListNode curr = node;
               while(curr!=null){
                   ListNode forward = curr.next;
                   curr.next=prev;
                   prev=curr;
                   curr=forward;
                   // forward= forward.next;
   
               }
               return prev;
           }

           // leetcode - 61 --------------------
           public ListNode rotateRight(ListNode head, int k) {
            if(head==null || head.next==null || k==0) return head;
                ListNode curr = head;
                int size =0;
                ListNode tail = null;
                while(curr!=null){
                    tail=curr;
                    curr=curr.next;
                    size++;
                }
             if(k==0)return head;
                k = k%size; // -> make it in range
                if(k<0) k+=size;
                int n = size-k;
                int count=1;
                curr=head;
                while(count<n){
                    curr=curr.next;
                    count++;
                }
                tail.next=head;
                head=curr.next;
                curr.next=null;
                return head;
            }
// leetcode 141 ----------------------------------------------------------------------
public boolean hasCycle(ListNode head) {
        if(head == null || head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
}

// leetcode 142---------------------------------------------------------------------
public ListNode detectCycle(ListNode head) {
    if(head == null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean flag =false;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                flag=true;
                break;
            }
        }
        if(flag==false) return null;
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;

        }
        return slow;
}

// leetcode 160----------------------------------------------------------------------
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA==null || headB == null)return null;
    
ListNode curr = headA;
ListNode tail = null;
while(curr!=null){
    tail=curr;
    curr=curr.next;
}
tail.next=headB;
ListNode node = detectCycle(headA);
tail.next=null;
    return node;

}
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1==null)return l2;
    if(l2==null) return l1;
    ListNode head = new ListNode(-1); // dummy node to manage null  
    ListNode curr = head;
    while(l1 !=null && l2!=null){
        if(l1.val<=l2.val){
            curr.next=l1; // phele wala curr ka next hai ye.. 
            curr=l1; // curr ko aage badao
            l1=l1.next; // l1 ko bhi aage badao
        }
        else{
            curr.next=l2;
            curr=l2;
            l2=l2.next;
    
        }
    }
        if(l1!=null){
            curr.next=l1;
        }
        else if(l2!=null){
            curr.next=l2;
        }
        return head.next;
    

}

public ListNode sortList(ListNode head) {
    if(head==null || head.next==null) return head;
        ListNode mid = head;
        ListNode nhead = mid.next;
        mid.next=null;
        return mergeTwoLists(sortList(head), sortList(nhead));

    }
    // leetcode 138--------------------------------------------------------------------
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        // part one
        while(curr!=null){
            Node forward = curr.next;
            Node nnode = new Node(curr.val);
            curr.next=nnode;
            nnode.next=forward;
            curr=forward;
        }
        // part two
        curr= head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random= curr.random.next;
            curr=curr.next.next;
        }
        // part three
        // creating a dummy node 
        curr=head;
        Node node =new Node(-1);
        Node newCurr = node;
        while(curr!=null){
            Node forward = curr.next.next;
            Node copyNode = curr.next;
            newCurr.next=copyNode;
            curr.next=forward;
            newCurr=copyNode;
            curr=forward;
        }

    
        return node.next; 
     }  

     public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0) return null;
        if(n==1 && head.next ==null) return null;
        ListNode slow =head, fast = head;
        while(n-->0){
          fast= fast.next;

        }
        if(fast==null) return head.next;
        while(fast.next!=null){
            slow = slow.next;
            fast=fast.next;
        }
     // ListNode temp=slow.next;
        slow.next=slow.next.next;
        // temp.next=null;
        return head;

    }
        
}