#include<iostream>
#include<vector>
using namespace std;
int bs(vector<int> &arr, int data){
int si=0, ei=arr.size()-1;
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
    int si=0,ei=v.size();
    while(si<=ei){
        int mid= (si+ei)/2;
        if(v[mid]==data){
            break;
        }
        else if(v[mid]>data){
            ei=mid-1;
        }
        else{
            si=mid+1;
        }
    }
    if(data-v[si]>v[ei]-data){
        return ei;
    }
    else{return ei;}
}
int paired(vector<int> &v){
    int si=0,ei=v.size()-1;
    while(si<=ei){
        int mid = (si+ei)/2;
        if(mid+1<=ei && v[mid]==v[mid+1]){
            ei=mid-1;
        }
        else if(mid-1>=si && v[mid-1]==v[mid]){
            si=mid+1;
        }
        else{
            return v[mid];
        }


    }
}
int main(){
    vector<int> arr = {1,2,2,3,3,4,4};
cout<<paired(arr);

return 0;
}