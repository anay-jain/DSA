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
void bionomailpattern(int n ){
    for(int i=0;i<=n;i++){
        float nck=1;
        for(int k=0;k<=i;k++){
            cout<<nck<<" ";
            nck=(nck*(i-k))/(k+1)];
        }
        cout<<endl;
    }
}
int main(){
    bionomailpattern(5);
    return 0;
}
