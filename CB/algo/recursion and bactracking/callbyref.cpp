#include<iostream>
using namespace std;
void increment(int &x , int y){
    // x=&y;
    cout<<x<<endl;
    cout<<y<<endl;
}


int main(){
    int x = 45 , y=10;
    increment(x,y);
    return 0;
}