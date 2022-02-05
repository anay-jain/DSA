#include<bits/stdc++.h>
using namespace std;

void solve(){
    string s;
    cin>>s;
    if(s.size()<=2) cout<<0<<endl;
    else{

    
    int czero =0, cone=0;
    for(int i=0;i<s.size();i++){
        if(s[i]=='0')
        czero++;
        else
        cone++;
    }
    if(czero==cone){
        cout<<--czero<<endl;
    }
    else{
        cout<<min(czero,cone)<<endl;
    }
    }

}

int main(){
    int t;
    cin>>t;
    while(t-->0)
    solve();

    return 0;
}