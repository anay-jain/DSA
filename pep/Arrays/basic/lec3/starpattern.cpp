#include<iostream>
using namespace std;


int main(){
    int n=5;
    int nsp =1;
    int nst=n-1;
    for(int i=0;i<n;i++){
        for(int i=0;i<nst;i++){
            cout<<"*";
            
        }
        cout<<endl;
        nst--;
    }    
    return 0;
}