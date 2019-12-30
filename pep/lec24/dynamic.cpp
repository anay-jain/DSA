#include<iostream>
#include<vector>
using namespace std;
vector<vector<int>> mul(vector<vector<int>> F[2][2] , vector<vector<int>> M[2][2]){
    int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0]; 
  int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1]; 
  int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0]; 
  int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1]; 

    F[0][0]=x;
    F[0][1] = y; 
        F[1][0] = z; 
F[1][1] = w; 


    
}
int apower2(int F[2][2] , int b ){
    if(b==0){
        return 1;
    }
    int idn[2][2]={{1,1},{1,0}};
    (b%2)==0?mul(F,F):mul(mul(F,F),idn);
}
int main(){


    return 0;
}