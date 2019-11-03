#include<iostream>
#include<vector>

using namespace std;
int coin_change1(vector<int>arr , int  n,string ans){
    if(n==0){
        return 1;
    }
    if(n<0){
        return 0;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
        int a = arr[i];
        count += coin_change1(arr,n-a,ans+to_string(a));
    }
    return count;
}

int main(){
    vector <int> arr={2,3,5,7};
    int n =10;
    cout<<coin_change1(arr,n,"");
    return 0;
}