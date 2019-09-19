#include<iostream>
using namespace std;
int main(){
    int n=6;
    int nst=1;
    int nsp= n/2;
    for(int i=0;i<n/2;i++){
        for(int csp =0;csp<nsp;csp++){
            cout<<" ";

        }
        for(int ns=0;ns<nst;ns++){
            cout<<"*";
            


        }
        for(int csp1=0;csp1<nsp;csp1++){
            cout<<" ";
        }
        cout<<endl;
        nst+=2;

        nsp--;
    }
    return 0;
}