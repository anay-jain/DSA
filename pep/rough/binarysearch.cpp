#include<iostream>
#include<vector>
using namespace std;
int bs(vector<int> &arr, int data){
int si=0, ei=arr.size();
// int mid = ei%2==0?ei/2:ei+1/2;

while(si<=ei){
    int mid= (si+ei)/2;
    if(arr[mid]==data){
        return mid;
    }
    else if(arr[mid]>data){
        ei=mid-1;
    }
    else{
        si=mid+1;
    }
}

}
// lower bound in binary search 
int lowerbound(vector<int> &v,int data){
    int si=0,ei=v.size();
    while(si<=ei){
        int mid = (ei+si)/2;
        if(v[mid]==data){
             if(mid-1>=0 && v[mid-1]==data){
            ei=mid-1;
        }
        else{
            return mid;
        }
        }
       
        else if(v[mid]>data){
            ei=mid-1;
        }
        else{
            si=mid+1;
        }
    }

}

int nearestelement(vector<int> &v,int data){
    
}
int main(){
    vector<int> arr = {1,2,3,3,3,3,3,3,4,5,6};
cout<<lowerbound(arr , 3);
return 0;
}