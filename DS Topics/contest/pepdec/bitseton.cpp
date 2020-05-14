#include<iostream>
using namespace std;


int main(){
    int n,k;
    cin>>n>>k;
    k = 1<<k;
    n = (n | k);
    cout<<n;

    return 0;
}