#include<iostream>
#include<vector>
using namespace std;
int coin_change1(vector<int>arr , int  n,string ans){
    if(n==0){
        cout<<ans<<" ";
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
int coin_change_onlyone(vector<int>arr ,int vidx, int  n,string ans){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    }
    if(n<0){
        return 0;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){
        int a = arr[i];
        count += coin_change_onlyone(arr,i+1,n-a,ans+to_string(a));
    }
    return count;
}

int coin_change_target(vector<int>arr ,int vidx, int  n,string ans){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    }
    if(n<0){
        return 0;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){
        int a = arr[i];
        count += coin_change_target(arr,i,n-a,ans+to_string(a));
        count += coin_change_target(arr,i+1,n,ans);
        
    }
    return count;
}
int main(){
    vector <int> arr={2,3,5,7};
    int n =10;
    int t =n;
    vector <bool> check{false,false,false,false};
    // cout<<coin_changetargetpermu(arr,check,n,"");
    // cout<<coin_changecombination(arr,n,t,"")
    // cout<<coin_change_target(arr,0,n,"");
    return 0;
}