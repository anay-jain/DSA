#include<iostream>
using namespace std;
void poweroftwo(int n){
    if(n&(n-1)==0){
        cout<<"Yes it is";
    }
    else{
        cout<<"No";
    }
}
void poweroftwo1(int n){
    n ^= (~(n));
    cout<<n;
    if(n==-1){
        cout<<"Yes its a sqaure";
    }
    else{
        cout<<"No,It's not";
    }
}
int main(){
    int n ;
    cin>>n;
    poweroftwo1(n);


    return 0;
}