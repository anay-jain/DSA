#include<iostream>
#include<vector>

using namespace std;

int maximumele(vector<int> &arr,int vidx){
    int temp= 0;
    if(vidx==arr.size()){
        return temp;
    }
    
    temp = maximumele(arr,vidx+1);
    temp=temp>arr[vidx]?temp:arr[vidx];
   
    
}
int lastindexfromlast(vector<int> &arr, int vidx,int data){
     if(data==arr[vidx]){
        return vidx;
    }
    if(vidx==-1) return 0;
    lastindexfromlast(arr,vidx-1,data);
    // return res;
   
    
}
int lastindex(vector<int> &arr,int vidx,int data){
    int temp=0;
    if(vidx==arr.size()){
        return temp;
    }
    if(
        temp==arr[vidx])
    return 

}

bool findele(vector<int> &arr, int vidx,int data){
    if(vidx==arr.size()) return false;
    if(data==arr[vidx]){
        return true;
    }
    
    return findele(arr,vidx+1,data);

}

void solve(){
     vector<int> arr={10,6,8,10,4,5,5,6,8,-3,2,12,5,8,3};
    //  cout<<maximumele(arr,0);
    //  cout<<findele(arr,0,3);
    // basic();
    cout<<lastindex(arr,14,8);
}


int main(int args , char **argv){
    solve();
    return 0;


    return 0;
}