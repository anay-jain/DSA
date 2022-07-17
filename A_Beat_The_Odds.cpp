#include<bits/stdc++.h>
using namespace std;
void solve(){
int n;
cin>>n;
int even=0, odd =0;
for(int i =0;i<n;i++){
int num;
cin>>num;

if(num%2==0) even++;
else odd++;
}
if(odd>even)cout<<even<<endl;
else cout<<odd<<endl;

}
int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
