#include<iostream>
#include<vector>

using namespace std;

int coin_change(vector<int> &arr , int n , string ans ){
    if(n==0){
        cout<<ans<<" ";
        return 1;
    
    }
    if(n<0){
        return 0;
    }
    int count =0;
    for(int i=0;i<arr.size();i++){
        count+=coin_change(arr , n-arr[i],ans+to_string(arr[i]));
    }
    return count;
}
// coin change and with combination
int coin_change_combination(vector<int> &arr ,int vidx,  int n , string ans ){
    // vidx because so that we can keep track of the elements we have gone thorugh;
    
}
int main(){
    vector<int> arr={2,3,5,7};
   coin_change(arr, 10,"");
    return 0; 
}