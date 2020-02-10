#include<iostream>
#include<list>
#include<unordered_map>
using namespace std;
class LinkedList{
    public:
    class Node{
    public:
    int data=0;
    Node* next = nullptr;
    
    Node(){
        // default constructor
    }
    Node(int data){
        this->data= data;
    }
};
private: 
    Node* head = nullptr;
    Node* tail = nullptr;// pointer that contais address
    int size=0;
public:
    ~LinkedList(){
        Node* temp = head;
        while (head!=nullptr)
        {
            head = head->next;
            delete temp;
            temp = head;
            /* code */
        }
        
    }
    int Size(){
        return this->size;
    }
    bool isEmpty(){
        return this->size==0;
    }
    void addFirst(int data){
        Node* node  = new Node(data);
        if(head == nullptr){
            tail = node;
            head =node;
        }
        else{
            node->next = head;
            head = node;
        } 
        size++;
    }
    void addLast(int data){
        Node* node = new Node(data);
        if(tail == nullptr){
            head = node;
            tail = node;
        }
        else{
            tail->next = node;
            tail = node;
        }
    size++;
    }
    int removeFirst(){
        Node * rn = nullptr;
        if(head != nullptr){
            if(size==1){
                tail = nullptr;
            }
            rn = head;
            head = head->next;
        }
        int rdata = rn==nullptr?-1:rn->data;
        size--;
        // rn->next=nullptr; not needed 
        delete rn;
        return rdata;

        
    }
    Node* getNodeAt(int idx){
        if(idx==0){
            return nullptr;
        }
        Node* temp = head;
        while(idx){
         temp =temp->next;
            idx--;
        }
        return temp;
    }
    int removeLast(){
        if(size==0)
        return -1;
        Node* rn = nullptr;
        if(size ==1){
            rn = tail;
            tail = nullptr;
            head = nullptr;
        }
        else{
           Node* temp = getNodeAt(size-2);
           // because size last node ke aage hai
        //    cout<<temp->data<<endl;
           rn = temp->next;
            tail = temp;
           temp->next=nullptr;
        }
        int rdata = tail!=nullptr?rn->data:-1;
        delete rn;
        size--;
        return rdata;
    }
    void addAt(int idx , int data){
        if(idx<0 || idx>size){
            return ;
        }
        if(idx==0){
            addFirst(data);
        }
        else if(idx == size){
            addLast(data);
        }
        else{
           Node* getNode1  = getNodeAt(idx-1);
        Node* getNode2 = getNode1->next;
        Node* node = new Node(data);
        getNode1->next = node;
        node->next = getNode2;
        size++;


        }
    }
        void removeAt(int idx){
            if(idx<0 || idx>size){
                return ;
            }
            if(idx==0){
                removeFirst();
            }
            else if(idx==size){
                removeLast();
            }
            else{
                Node* getNode1 = getNodeAt(idx-1);
                Node* currNode = getNode1->next;
                getNode1->next = currNode->next;
                size--;
                delete currNode;
            }
           
            
        }
        Node* mid(){
            Node* slow = head;
            Node* fast = head;
            while(fast!=nullptr && fast->next !=nullptr && fast->next->next!=nullptr){
                slow = slow->next;
                fast = fast->next->next;

            }
            return slow;
        }
        private:
        class pairRec{
            public:
            Node* prevNode = nullptr;
            // vs taki ye heap pr pahuch jaye 
            pairRec(){
                
            }
        };
        void reverseDataRec(Node* node , pairRec* prev, int level){
        if(node  == nullptr){
            return ;
            }
        // call lagao 
        reverseDataRec(node->next, prev, level+1);
        // jab level half size se bda hai tab tak swap karna hai 
        if(level>=this->size/2){
                //prevNode private hota to hme pairRec ki class mei hi usse aise use kar ste hai.
                int temp= prev->prevNode->data;
                prev->prevNode->data = node->data;
                node->data= temp;
                prev->prevNode = prev->prevNode->next;
                // prev ka prevNode kisse reflect 
                // cout<<"d";
        }
    }
    public:
     void display(){
        while (head!=nullptr)
        {
            cout<<head->data<<"->";
            head = head->next;
        }
        
    }
    void reverseDataRec_(){
        pairRec* prev = new pairRec(); 
        prev->prevNode = head;
        reverseDataRec(head,prev, 0 );
    }
   Node* reversepointer(Node* node){
        if(node == nullptr){
            return nullptr;
        }
        
        Node *prev = nullptr;
        Node *curr = node;

        while (curr != nullptr)
        {
            Node *forw = curr->next;
            curr->next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    

    }
  
    bool isPalindrome(){
        // Node*  node = head;
        Node* midNode= mid();
        Node* nhead = midNode->next;
        midNode->next = nullptr;
        Node* prev= reversepointer(nhead);
        Node* list1 = head;
        Node* list2 = prev;
        bool flag = true;
        while(list1!=nullptr && list2!=nullptr){
            if(list1->data != list2->data){
                flag= false;
            }
            list1=list1->next;
            list2=list2->next;
        }
        prev = reversepointer(prev);
        midNode->next = nhead;
        // kyuki hmne beech mei link todd dia ta
        return flag;

    
    }   
    
};
class LRU{
    list<int> ll;
    unordered_map<int,char> map;
    int defaultSize =4;
    void set(int key , char val){
        if(map.find[key]==map.end()){
            
        }
    }



};

int main(){
    LinkedList ll ;
    for(int i=1;i<=10;i++){
        ll.addFirst(i*10);
    }
    for(int i =10;i>=1;i--){
        ll.addFirst(i*10);

    }

    // cout<<ll.Size();
    // cout<<ll.removeLast()<<endl;
    // cout<<ll.removeLast()<<endl;cout<<ll.removeLast()<<endl;
    // ll.display();
    // cout<<ll.Size();
    // ll->Node* midData = ll.mid(); // problm
    // ll.reverseDataRec_();
    // ll.display();
    cout<<ll.isPalindrome();

    return 0;
}