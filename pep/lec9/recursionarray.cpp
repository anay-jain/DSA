#include<iostream>
#include<vector>
using namespace std;

int stairs(int n){
    if(n==0){
        return 1;
    }
    int count=0;
    if(n-1>=0){
        count+=stairs(n-1);
    }
    if(n-2>=0){
        count+=stairs(n-2);

    }
    if(n-3>=0){
        count+=stairs(n-3);
    }
    return count;
}
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
vector<int> allindex(vector<int> &arr,int vidx,int data,int size){
    if(vidx==arr.size()){
        // a good chance to create an array that will intialze only one time
        vector<int>aindex(size,0);
        return aindex;
    }
    // before recursive calls , count all times we have number qual to data
    if(data==arr[vidx]){
        size++;
    }
    vector<int> aindex=allindex(arr,vidx+1,data,size);
    //after recursive calls , put equal data element 
    if(arr[vidx]==data){
        aindex[size] = vidx;
    }
    return aindex;
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
{   vector<int> arr={10,6,8,10,4,5,5,6,8,-3,2,12,5,8,3};    
    // display(arr,0);
    // findele(arr,0,2);
    // cout<<maximumele(arr,0);
    // cout<<lastindex(arr,0,8);
    // vector<int> a = allindex(arr,0,8,0);
    // display(a,0);
    cout<<stairs(4);
    
}
int main(){
    solve();
    return 0;
}