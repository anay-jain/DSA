#include<iostream>
#include<vector>
using namespace std;


 int coin_change1(vector<int> &arr, int n , string ans ){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    }
    int count=0;
    for(int i=0;i<arr.size();i++){
        int t=arr[i];
        if(n-t>=0){
            count+=coin_change1(arr,n-t,ans+to_string(t));
        }
        
    }
    return count;
 }
 int coin_change_combi(vector <int> arr , int vidx , int n , string ans){
     if(n==0){
         cout<<ans<<" ";
         return 1;
     }
     if(n<0){
         return 0;
     }
     int count=0;
     for(int i=vidx;i<arr.size();i++){
         count+=coin_change_combi(arr, i, n-arr[i],ans+to_string(arr[i]));
     }
     return count ;
 }

int main(){
    vector<int> arr={2,3,5,7};
    int n=10;
    // cout<<coin_change1(arr,10,"");
cout<<coin_change_combi(arr, 0,n,""); 
    return 0;
}