#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
void isprime(int n){
    int flag=0;
    for(int i=2;i*i<=n;i++){
        flag=0;
        if(n%i==0){
            flag=1;
            
        }
    }
    if(flag==1){
        cout<<"Not Prime";
    }
    else{
        cout<<"Prime";
    }
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n ;
    cin>>n;
    isprime(n);
    return 0;
}
