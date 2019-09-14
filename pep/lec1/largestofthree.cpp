#include <iostream>
using namespace std;
int main(){
    int a =2 ; b=3;c=32;
    if(a>b && a>c){
        cout<<a<<endl;
    }
    else if(b>c && b>a){
        cout<<b<<endl;
    }
    else{
        cout<<c<<endl;
    }
}