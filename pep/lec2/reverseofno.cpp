#include<iostream>
using namespace std;

int main(){
    int n,t=0,count=0;
    cin>>n;
    while(n){
       t= (t*10) + (n%10)
       n= n/10;
    }
    cout<<t;
    return 0;
}