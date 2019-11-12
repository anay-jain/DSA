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
int coinchange_combi01(vector<int> arr , int vidx , int target , string ans){
  if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){

        if(arr[i]<=target){
            // i+1 for unique coins only
            count+=coinchange_combi01(arr, i, target-arr[i], ans+to_string(arr[i]));
        }
    }
    return count;
}
int coinchange_combi02_unique(vector<int> arr , int vidx , int target , string ans){
  if(target==0){
        cout<<ans<<endl;
        return 1;
    }
    int count=0;
    for(int i=vidx;i<arr.size();i++){

        if(arr[i]<=target){
            // i+1 for unique coins only
            count+=coinchange_combi02_unique(arr, i+1, target-arr[i], ans+to_string(arr[i]));
        }
    }
    return count;
}
int coinchange_permu02_unique(vector<int> arr , int target , vector<bool> isUsed , string ans){
    if(target==0){
        cout<<ans<<endl;
        return 1;
    }

    int count=0;
    for(int i=0;i<arr.size();i++){
        if(target-arr[i]>=0 && !isUsed[i]){
            isUsed[i]=true;
            count+=coinchange_permu02_unique(arr,target-arr[i],isUsed,ans+to_string(arr[i]));
            isUsed[i]=false;
        }
    }
    return count;
}
int nqueenPermu_sub(int boxes, int tnq, int qloc, vector<bool> &loc, int qpsf, string ans)
{
    if (qpsf == tnq || qloc > boxes)
    {
        if (qpsf == tnq)
        {
            cout << ans << endl;
            return 1;
        }
        return 0;
    }
    int count_ = 0;
    if (!loc[qloc])
    {
        loc[qloc] = true;
        count_ += nqueenPermu_sub(boxes, tnq, 0, loc, qpsf + 1, ans + "b" + to_string(qloc) + "q" + to_string(qpsf) + " ");
        count_ += nqueenPermu_sub(boxes, tnq, qloc + 1, loc, qpsf, ans);
        loc[qloc] = false;
    }
    
    return count_;
}
void solve(){
    // vector<int>arr = {2,3,5,7};
    // vector<bool>isUsed(arr.size(),false);
    // cout<<coinchange_permu02_unique(arr,10,isUsed,"");
    // cout<<coinchange_permu01(arr,10,"");
    // cout<<coinchange_combi01(arr, 0,10,"");
    vector<bool> loc(8, false);
     cout << nqueenPermu_sub(7, 3, 0, loc, 0, "") << endl;
}

int main(){

    solve();
}