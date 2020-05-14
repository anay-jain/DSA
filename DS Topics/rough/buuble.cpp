#include<iostream>
#include<vector>

using namespace std;
void display(vector<int> &v){
    for(int i =0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
}
vector<int> bubble(vector<int> &v){
    int n=v.size();
    int flag= false;
    for(int i =0;i<n;i++){
        flag=false;
        for(int j=1;j<n-i;j++){
            if(v[j-1]>v[j]){
                flag=true;
                swap(v[j-1],v[j]);
            }
        }
        if(flag==false){
            break;
        }
    }
    return v;
}

int main(){
    vector<int> v = {4,5,4,45,1,5,56,2,5,2,5,125,40};
    bubble(v);
    display(v);
}