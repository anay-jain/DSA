#include<iostream>
#include<vector>
using namespace std;

int jose(vector<int>&a ,int k , int i){
    int n=a.size();
    if(a.size()==1){
        return a[0];
    }
        i=i%(n);
     (i==0)?a.erase(a.begin()+(i)):a.erase(a.begin()+(i-1));

    int recAns = jose(a,k,i+k);
    return recAns;

}
int main(){
    vector<int> a = {1,2,3,4,5,6,7,8,9};
    cout<<jose(a,3,3);
    return 0;


}