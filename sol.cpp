#include<bits/stdc++.h>
using namespace std;

void solve(int t){
string p , k;
cin>>k>>p;
    int i =0, j=0;
    int count =0;
    while(i<k.size() && j < p.size()){
        if(p[j]==k[i]){
            i++;
            j++;
        }
        else{
            count++;
            j++;
        }
    }
    if(i==k.size()){
        cout<<"Case #"<<t<<": "<<count+(p.size()-j)<<endl; 
        
    }
    else{
       cout<<"Case #"<<t<<": "<<"IMPOSSIBLE"<<endl;
    }

return;
}

int main(){
    int t=1;
    cin>>t;
    while(t-->0)
    solve(t);

    return 0;
}