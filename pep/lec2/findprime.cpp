#include<iostream>
using namespace std;

int main(){
    int flag=1;
    int n ;
    cin>>n;
    for(int i=2;i*i<=n;n++){
        if(n%i == 0){
            flag=1;
            break;
        }
        else{
            flag=0;
        }
    }
    if(flag==0){
        cout<<"Not prime";
    }
    else{
        cout<<"prime";
    }
    return 0;
}