#include<iostream>
#include<vector>
using namespace std;

int jose(vector<int>&a ,int n , int k){
    if(a.size()==1){
        return a[0];
    }
    if(k>n){
        k=k%n;
    }
     a.erase(a.begin()+k);
    
    
    //pop of k
   
    int recAns = jose(a,n,k+k);
    return recAns;

}
int main(){
    vector<int> a = {1,2,3,4,5};
    cout<<"h";
    cout<<jose(a,5,3);
    return 0;


}