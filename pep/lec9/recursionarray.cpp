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
    return 0;

}

bool findele(vector<int> &arr, int vidx,int data){
    if(vidx==arr.size()) return false;
    if(data==arr[vidx]){
        return true;
    }
    
    return findele(arr,vidx+1,data);

}
int jumps(int n,int count){
   int count=0;
    if(n>0) return 0;
    if(n==0) return 1 ;
    int count1 = jumps(n-1,count)+jumps(n-2,count)+jumps(n-3,count);
    return count1+1;

}
void solve(){
    //  vector<int> arr={10,6,8,10,4,5,5,6,8,-3,2,12,5,8,3};
    //  cout<<maximumele(arr,0);
    //  cout<<findele(arr,0,3);
    // basic();
    // cout<<lastindex(arr,14,8);
    cout<<jumps(4,0);
}


int main(int args , char **argv){
    solve();
    return 0;


    return 0;
}