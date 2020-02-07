#include<iostream>
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
    int size;
public:
   
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
    void display(){
        while (head!=nullptr)
        {
            cout<<head->data<<"->";
            head = head->next;
        }
        
    }

};

int main(){
    LinkedList ll ;
    for(int i=1;i<=10;i++){
        ll.addFirst(i*10);
    }
    ll.display();
    return 0;
}