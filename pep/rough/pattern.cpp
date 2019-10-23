#include<iostream>
using namespace std;

void pattern1(int n){
    int nsp=n-1;
    int nst=1;
    while(n--){
    for(int i=1;i<=nsp;i++){
    cout<<" ";        
    }
    for(int i=1;i<=nst;i++){
        cout<<"*";
    }
    cout<<endl;
    nsp--;
    nst++;
}
}
int main(){
    pattern1(5);
    return 0;
}
