#include<iostream>
using namespace std;

int fact(int n){
    
    if(n==0 || n==1){
        return 1;
    }
    
   
    int rem=n*fact(n-1);
     cout<<n<<endl;
    return rem;
}

int main(){
    cout<< fact(6);
    return 0;
}