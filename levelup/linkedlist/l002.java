import javax.management.ListenerNotFoundException;

public class l002{

    // 1st approach  --> ( by iterating twice)
    public ListNode middleNode(ListNode head) {
        int no_of_nodes=0;
        ListNode curr = head;
        while(curr!=null){
            no_of_nodes++;
            curr = curr.next;
        }
        int mid  = (no_of_nodes/2) +1 ;
        curr = head;
        int ptr = 0;
        while(ptr!=mid-1){
            curr = curr.next;
            ptr++;
        }
        return curr;
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = null;
        ListNode curr = head;
        ListNode succ = curr.next;
        ListNode succ1 = succ.next.next;

        while(succ != null){
             succ.next = curr;
            curr = succ;
            succ = succ1;
            if(succ1!=null) succ1 = succ1.next;
        }
        return curr
      
    } 
    public  ListNode midList(ListNode list){
        if(list == null || list.next == null) return list;
        ListNode fast = list.next.next;
        ListNode slow = list.next;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;


        }
        return slow;
    }
    public ListNode mergeTwoLists_(ListNode list1 ,ListNode list2){
        if(list1.next==null){
            return list2;
        }
        if(list2.next == null) return list1;
        // now merge two list
        
        ListNode headList1= list1;
        ListNode headList2= list2;
        ListNode head = null;
        if(headList1.val > headList2.val){
            head = headList1;
            headList1 = headList1.next;

        }
        else{
            head= headList2;
            headList2 = headList2.next;
        }
        ListNode nhead= head;
        while(headList1 != null && headList2 !=null ){
            if(headList1.val > headList2.val){
                head.next = headList1;
                headList1 = headList1.next;
                head = head.next;
            }
            else{
                head.next = headList2;
                headList2 = headList2.next;
                head = head.next;
            }
        }

        if(headList1 != null){
            head.next = headList1;
            headList1 = headList1.next;
            head = head.next;
        }
        else{
            head.next = headList2;
            headList2 = headList2.next;
            head = head.next;

        }
        return nhead;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if(list1 == null ) return list2;
            if(list2 == null) return list1;
        ListNode midList1 = midList(list1);
        ListNode midList2=midList(list2);
        ListNode left = mergeTwoLists_(list1, list2);
        ListNode right = mergeTwoLists_(midList1, midList2);
        ListNode mergedList = 
        
    
    }
  
    public static void main(String[] args) {
        
    }
}