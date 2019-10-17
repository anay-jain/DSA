#include<iostream>
#include<vector>
using namespace std;

int fact(int n ){
    if(n==0 || n==1){
        return n;
    }
    int factAns = n*fact(n-1) ;
    return factAns;
}   
int apowerb(int a,int b){
    if(b==1){
        return a;
    }
    int recAns = a* apowerb(a,b-1);
    return recAns;
}
int betterapowerb(int a,int b){
    if(b==0){
        return 1;
    }
   
    int recAns1 = betterapowerb(a,b/2);
    // recAns*=recAns;
    // cout<<recAns<<"  ";
    return (b&1==0)?recAns1*recAns1:recAns1*recAns1*a;
}


int main(){
    cout<<betterapowerb(2,5);

    return 0;
}