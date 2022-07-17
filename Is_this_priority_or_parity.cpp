#include<bits/stdc++.h>
using namespace std;
void solve(){
long long n,k;
cin>>n>>k;
if(k==2){
    cout<<"ODD";
}
else if(k==1) { 
    if(n%2==0)
    cout<<"EVEN";
    else   
    cout<<"ODD";
}
else{
    cout<<"EVEN";
}   


cout<<endl;
}
int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
