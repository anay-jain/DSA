#include<iostream>
#include<vector>
using namespace std;
int coinchange_permu01(vector<int> &arr,  int target , string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count =0;
    for(int ele:arr){
        if(target>=ele){
        count+=coinchange_permu01(arr, target-ele,ans+to_string(ele));
        }
    }
    return count;
}
void solve(){
    vector<int>arr = {2,3,5,7};
    cout<<coinchange_permu01(arr,10,"");
}

int main(){

    solve();
}