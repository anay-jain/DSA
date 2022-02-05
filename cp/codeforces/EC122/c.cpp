#include<bits/stdc++.h>
using namespace std;

void solve(){
    long hc,dc,hm , dm,k,w,a  ;
    cin>>hc>>dc>>hm>>dm>>k>>w>>a;
    hc = hc+(a*k);
    dc= dc+(k*w);
    long monster = hm/dc;
    long ch = hc/dm;
    if(monster>ch){
        cout<<"NO"<<endl;
    }
    else {
        cout<<"YES"<<endl;
    }
    

}

int main(){
    int t;
    cin>>t;
    while(t-->0)
    solve();

    return 0;
}