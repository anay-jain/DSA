#include<iostream>
#include<bits/stdc++.h>
using namespace std;

 
     struct ListNode {
         int val;
         ListNode *next;
         ListNode() : val(0), next(nullptr) {}
         ListNode(int x) : val(x), next(nullptr) {}
         ListNode(int x, ListNode *next) : val(x), next(next) {}
     };
// class Node {
// public:
//     int val;
//     Node* next;
//     Node* random;
    
//     Node(int _val) {
//         val = _val;
//         next = NULL;
//         random = NULL;
//     }
// };
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Node {
public:
	int data;
	Node* next;
	Node* child;

	Node(int data) {
		this->data = data;
		this->next = NULL;
		this->child = NULL;
	}
};
   
    Node* copyRandomList1(Node* head) {
        if(head == nullptr) return head;
        unordered_map<Node*,Node*> umap;
        Node* curr = head;
        while(curr != nullptr){
            Node* newnode = new Node(curr->val);
            umap[curr] = newnode;
            curr = curr->next;
        } 
        curr = head;
        while(curr != nullptr){
            umap[curr]->next = umap[curr->next];
            if(curr->random!=nullptr)umap[curr]->random = umap[curr->random];
            curr = curr->next;
        }
        return umap[head];
    }
    ListNode* sortList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head;
        
         
    }
 Node* copyRandomList(Node* head) {
     if(head == nullptr) return head;


 }
 Node* flattenLinkedList(Node* head) 
{   
	if(head == nullptr ) return head;
    priority_queue<Node* , vector<Node*> , greater<Node*>> pq;
    Node* curr = head;
    while(curr != nullptr)
    {
        pq.push(curr);
        curr = curr ->next;
    }
    
    
}
    void reorderList(ListNode* head) {
        if(head == nullptr && head->next == nullptr && head->next->next == nullptr)  return ;
        ListNode* c1 = head;
        ListNode* midnode = midNode(head);
        ListNode* c2 =  reverseList(midnode->next);
        ListNode* nhead = c2;
        midnode->next = nullptr;
         ListNode* fc1 = c1;
         ListNode* fc2  = c2;
        while(c1 !=nullptr){
             fc1 = c1->next;
           fc2  = c2->next;
            c1->next = c2;
            if(c2 != nullptr)c2->next = fc1;
            c1=fc1;
            c2= fc2;
        }
      reverseList(nhead);
      nhead->next = midnode;
    }   
     bool isPalindrome(ListNode* head) {
     if(head == nullptr)  return false;
        ListNode* head_dup = head;
        ListNode* nhead= midNode(head);
        ListNode* nnhead= reverseList(nhead);
        nhead->next = nullptr;
        ListNode* newhead = nnhead;
        while(nnhead!=nullptr){
            if(head_dup->val != nnhead->val){
                return false;
            }
            if(head_dup != nullptr)head_dup = head_dup->next;
            nnhead = nnhead->next;
        }
        reverseList(newhead);
        return head;
    }
 ListNode* oddEvenList(ListNode* head) {
         if(head == nullptr || head->next==nullptr || head->next->next == nullptr) return head;
         ListNode* c1 = head;
         ListNode* c2 = head->next;
         ListNode* evenhead = head->next;
         while(c1->next != nullptr && c2->next!=nullptr){
             c1->next = c1->next->next;
              c2->next = c2->next->next;
             c1 = c1->next;
             c2= c2->next;

         }
       
         c1->next = evenhead;
         return head;
    }
      ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
       ListNode* head = headA;
       
       while(headA->next!=nullptr){
           headA=headA->next;
       }
       headA->next = headB;
       ListNode* c  = detectCycle(head);
       if(c==nullptr) return nullptr;
       head->next=nullptr;
       return c;
    }
ListNode *detectCycle(ListNode *head) {

        if(head == nullptr || head->next==nullptr){
            return nullptr;
        }
        ListNode* slow = head;
        ListNode* fast = head;
     bool flag = false;
        while(fast != nullptr && fast->next!=nullptr){
            slow = slow->next;
            fast = fast->next->next;

            if(slow == fast ){
                flag= true;
                break;
            }

        }
        if(flag){
            slow = head;
            while(slow!=fast){
                slow = slow->next;
                fast = fast->next;
            }
            return slow;
        }
        return nullptr;
    }
       bool hasCycle(ListNode *head) {
           if(head == nullptr || head->next==nullptr) return false ;

           ListNode* slow = head;
           ListNode* fast = head;

           while(fast != nullptr && fast->next!=nullptr){
               slow =slow->next;
               fast = fast->next->next;
               if(slow== fast){
                   return true;
               }
           }
    return false;
    }

    
     ListNode* reverseList(ListNode* head) {
        if(head == nullptr || head->next == nullptr) return head;
    
    // Prev at NULL , Curr at 1st Node and Succ at 2nd node 
    ListNode* prev = nullptr;
    ListNode* curr = head;
    ListNode* succ = curr->next;
    while(curr!=nullptr){
        curr->next = prev;
        prev = curr;
        curr=succ;
        if(succ!=nullptr) succ = succ->next;
    }
    return prev;
    }

    ListNode* midNode(ListNode* head){
         if(head == nullptr || head->next == nullptr){
            return head;
        }

        ListNode* slow= head;
        ListNode* fast = head;

        // IMP for lower bound in even , you need to give fast->next->next also , otherewise no
        while(fast!=nullptr && fast->next!=nullptr && fast->next->next!=nullptr){
            slow= slow->next;
            fast = fast->next->next;
        }

        return slow; 
    }
     ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        // Think like a equation here n+gap = length
        // fast will reach length and slow will reach n because there is a gap 
        if(head == nullptr || n ==0) return nullptr;
        if(head->next == nullptr && n==1) return nullptr;
        ListNode* slow = head;
        ListNode* fast = head;
        for(int i =1;i<=n;i++){
            fast = fast->next;
        }
        // very imp condition
        if(fast == nullptr) return head->next;
        while(fast->next!=nullptr){
            slow= slow->next;
            fast = fast->next;
        }
        
        slow->next= slow->next->next;


        return head;
    }   
class Solution {
public:
        ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int carry =0;
        ListNode* root = nullptr;
        ListNode* prev = new ListNode(); 
        while(l1!=nullptr && l2!= nullptr){
            int value = l1->val+l2->val+carry;
           
            carry = value/10;
            value = value%10;
            prev->next= new ListNode(value);
            
            if(root == nullptr)  root = prev;  
             cout<<root->val;
            
            prev = prev->next;
            
         l1 = l1->next;
         l2= l2->next;
        }
        if(l2!=nullptr){
            prev = l2;
            l2=l2->next;
            prev = prev->next;
        }
        if(l1!=nullptr){
            prev=l1;
            l1=l1->next;
            prev=prev->next;
        }
    return root->next;

    }

};
  int lengthOfLongestSubstring(string s) {
        vector<int> map(256,0);
        int si=0;
        int count =0;
        for(int i=0;i<s.size();i++){
            map[s[i]]++;
            while(map[s[i]]>1) {
                map[s[si]]--;
                si++;
            }
            count = max(count , i-si+1);
        }
        return count;
    }


ListNode* mergeKLists(vector<ListNode*>& lists) {
    priority_queue<int,vector<int>,greater<int>> pq ;
    for(auto i:lists){
        while(i){
            pq.push(i->val);
            i=i->next;
        }
    }
    ListNode* root = nullptr;
    ListNode* prev = nullptr;
    while(pq.size()){
        if(root == nullptr){
            root = new ListNode(pq.top());
            prev = root;
        }
        else{
            prev->next = new ListNode(pq.top());
            prev = prev->next;


        }
        pq.pop();

    }
return root;

}
 int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(),verticalCuts.end());
        int hmax=0;
        int vmax=0;
        for(int i=1;i<horizontalCuts.size();i++){
            if(i==horizontalCuts.size()){
                hmax = max(h-horizontalCuts[i-1],hmax);
            }
            else
            hmax = max(horizontalCuts[i]-horizontalCuts[i-1],hmax);
            
        }
              for(int i=1;i<verticalCuts.size();i++){
            if(i==verticalCuts.size()){
                vmax = max(w-verticalCuts[i-1],vmax);
            }
            else
            vmax = max(verticalCuts[i]-verticalCuts[i-1],vmax);
            
        }
        int m= 1e9+7;
        int ans =( hmax%m * vmax%m)%m;
        return ans;


        
    }


// Merge intervals

vector<vector<int>> merge(vector<vector<int>>& intervals) {
    sort(intervals.begin(), intervals.end());     
    vector<vector<int>> ans;
    vector<int> pair(2,0);
    pair[0] = intervals[0][0];
    pair[1] = intervals[0][1];

    for(int i =1;i<intervals.size();i++){
      
                if(pair[1]>=intervals[i][0] ) 
                    pair[1] = max(intervals[i][1],pair[1]);
                    
                else
                {
                    ans.push_back(pair);
                      pair[0] = intervals[i][0];
                        pair[1] = intervals[i][1];
                }
    }
    ans.push_back(pair);
return ans;

    }
    


int main(){



    return 0;
}