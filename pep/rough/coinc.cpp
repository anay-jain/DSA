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
bool isSafeToPlace(vector<vector<bool>> &boxes, int x, int y)
{

    int dir[4][2] = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    for (int d = 0; d < 4; d++)
    {

        for (int rad = 1; rad < boxes[0].size(); rad++)
        {
            int r = x + rad * dir[d][0];
            int c = y + rad * dir[d][1];
            if (r >= 0 && c >= 0 && r < boxes.size() && c < boxes[0].size() && boxes[r][c])
            {
                return false;
            }
        }
    }

    return true;
}

int nQueen(vector<vector<bool>> &boxes, int tnq, int qloc, int qpsf, string ans)
{
    if (qpsf == tnq)
    {
        cout << ans << endl;
        return 1;
    }

    int count = 0;
    for (int i = qloc + 1; i < boxes.size() * boxes[0].size(); i++)
    {
        int x = i / boxes.size();
        int y = i % boxes.size();
        if (isSafeToPlace(boxes, x, y))
        {
            boxes[x][y] = true;
            count += nQueen(boxes, tnq, i, qpsf + 1, ans + "(" + to_string(x) + ", " + to_string(y) + ")" + "@" + to_string(qpsf) + " ");
            boxes[x][y] = false;
        }
    }
    return count;
}

void solve(){
    // vector<int>arr = {2,3,5,7};
    // vector<bool>isUsed(arr.size(),false);
    // cout<<coinchange_permu02_unique(arr,10,isUsed,"");
    // cout<<coinchange_permu01(arr,10,"");
    // cout<<coinchange_combi01(arr, 0,10,"");
    
    vector<vector<bool>> boxes(4, vector<bool>(4, false));
    cout << nQueen(boxes, 4, -1, 0, "") << endl;
}

int main(){

    solve();
}