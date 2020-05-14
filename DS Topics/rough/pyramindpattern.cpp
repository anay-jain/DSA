#include<iostream>
using namespace std;

void pyramidpattern(int n){
    int nsp=n-1,nst=1;
    for(int i=1;i<=n*2-1;i++){
        for(int csp=1;csp<=nsp;csp++){
            cout<<" ";
        }
        int temp=1;
        for(int cst=1;cst<=nst;cst++){
            
            if(cst<=nst/2){
                cout<<temp;
                temp++;
            }
            else{
                cout<<temp;
                temp--;
            }
            
        }
        if(i<n){
            nst+=2;
            nsp--;
        }
        else{
            nst-=2;
            nsp++;
        }

    cout<<endl;
    }

}

int main(){
pyramidpattern(3);

return 0;
}
