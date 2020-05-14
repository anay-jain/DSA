#include<iostream>
using namespace std;

int main(){
    int n,count=0;
    cin>>n;
    while(n){
        n = n/10;
        count++;
    }
    cout<<count;
    cout<<(-1%5);
    return 0;
}