#include<bits/stdc++.h>
using namespace std;
void solve(){
int n,k;
cin>>n;
cin>>k;
if(n%2==0){
    cout<<"YES";

}
else{
    if(k==0)
    cout<<"NO";
    else
    cout<<"YES";
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
