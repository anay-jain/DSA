#include<iostream>
#include<vector>
using namespace std;
int maximumele(vector<int>& arr,int vidx){
    if(vidx==arr.size()){
        return arr[vidx];
    }
    int recAns = maximumele(arr,vidx+1);
    return max(recAns,arr[vidx]) ;
}
int lastindex(vector<int> &arr,int vidx,int data){
    // we will return index and -1
    
    if(vidx==arr.size()) return -1;
    int recAns= lastindex(arr,vidx+1,data);
    if(recAns != -1){
        return recAns;
    }
    else{
        return (arr[vidx]==data?vidx:-1);
    }

}   

void display(vector<int> &arr,int vidx){
    if(vidx==arr.size()){
        return;
    }
    cout<<arr[vidx]<<" "; // above the function calls
    display(arr,vidx+1);
}
bool findele(vector<int> &arr,int vidx ,int data){
    if(vidx==arr.size()){
        return false; // we havent founded that element and the array ends
    }
    if(arr[vidx]==data){
        return true;
    }
    return findele(arr,vidx+1,data);
}

void solve()
{   vector<int> arr={1,5,4,1,2,8,8,56,8,8,2};    
    // display(arr,0);
    // findele(arr,0,2);
    // cout<<maximumele(arr,0);
    // cout<<lastindex(arr,0,8);
    
}
int main(){
    solve();
    return 0;
}