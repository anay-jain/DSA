#include<iostream>
using namespace std;

int fun(int &a){
    int* b = &a;
    int c = 10;
    int *d = &c;

    return d-b;
}
int main(){
int a =0;
// int *b=&a;
cout<<fun( a);

}