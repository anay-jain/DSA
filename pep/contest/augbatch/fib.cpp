#include<iostream>
using namespace std;


int main(){
    int a =0,b=1;
    int n;
    cin>>n;
    while(a<=n){
        cout<<a<<" ";
        int temp=a;
        a=a+b;
        b=temp;
    }
    
    return 0;
}