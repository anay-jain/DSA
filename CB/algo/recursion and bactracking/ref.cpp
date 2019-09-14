#include<iostream>
using namespace std;

int* createArr(){
    int a[] = {1,2,3};
    cout<<a<<endl;
    for(int i =0;i<3;i++){
        cout<<a[i]<<"  ";
    }
}

int main(){
    int *b = createArr();
    cout<<b<<endl;
    cout<<b[1];


    return 0;
}