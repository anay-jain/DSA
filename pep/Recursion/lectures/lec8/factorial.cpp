#include<iostream>
using namespace std;
int fact(int n){
    if(n==1){
        return 1;
    }
    int res =  n*fact(n-1);
    return res;

    // int res = fact(n-1);
    // return res*n;
}

int main(){ 
    cout<<fact(5);
    
    return 0;
}