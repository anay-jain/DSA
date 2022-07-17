#include<bits/stdc++.h>
using namespace std;
void solve(){
int pa , pb, qa, qb;
cin>>pa>>pb>>qa>>qb;
int a = max(pa,pb);
int b =max(qa, qb);
if(a>b)cout<<"Q";
else if(b>a)cout<<"P";
else cout<<"TIE";
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
