#include<iostream>
#include<vector>
using namespace std;

bool binarysearch(vector<int>& v,int data , int si,int ei){
    while(si<=ei){
        int mid=(si+ei)/2;
         cout<<v[mid];
        if(data == v[mid]){
            return true;
        }
        else if(v[mid] > data){
            ei = mid-1;
        }
        else{
            si= mid+1;
        }
    }
    return false;
}

void input(vector<int>& v ,int n){
    for(int i=0;i<n;i++){
        cin>>v[i];
    }
}
int main(){
    int n,data ;
    cin>>n;
    vector<int> v(n,0);
    input(v,n);
    cin>>data;
    cout<<binarysearch(v,data,0,n);

    return 0;
}