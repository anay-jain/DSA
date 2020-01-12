#include<iostream>
#include<vector>
using namespace std;
class Node{
    public:
    int node=0;
    Node* lnode = NULL;
    Node* rnode = NULL;
    Node(int node , Node* lnode , Node* rnode ){
        this->node = node;
        this->lnode= lnode;
        this->rnode = rnode;
    }
    Node(){

    }
};
// Node type because when node left will call it with return a node that will get connected with the node
Node* construction(int idx ,vector<int> arr){
    if(idx==arr.size){
        return ;
    }
    if(arr[idx]==-1){
        idx++;
        return NULL;
    }
    Node* nnode = new Node(arr[idx],nullptr , nullptr);
    idx++;
    nnode->lnode=construction(idx , arr);
    nnode->rnode=construction(idx , arr);
    return nnode;
}
Node* display(Node* node ){
    string str="";
    str+=node->lnode==nullptr?" . ":node->lnode->node;
    str+=
}
int main(){

    return 0;
}