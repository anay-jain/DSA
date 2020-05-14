#include<iostream>
using namespace std;
void printincre(int st , int end){
    if(st==end+1) return;
    cout<<st<<" ";
    printincre(st+1,end);
}
void printdre(int st,int end){
    if(st==end+1) return ;
    cout<<st<<endl;
    printdre(st+1,end);
    cout<<st<<" ";
    st+=10; // even after incrementing , we will not see chnage

}
int printincre2(int st , int end){
    if(st==end+1) return;
    return printincre2(st+1,end);
}
int main(){
    int n = 1 , end=10;
    printdre(n,end);
    return 0;
}