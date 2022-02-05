#include<bits/stdc++.h>
using namespace std;

void solve(){
int a , b,c , p , q , r;
cin>>a>>b>>c>>p>>q>>r;
int allvotes = (p+q+r)/2;
int po=p;
int qo = q;
int ro = r;
p = p-a;
q= q-b;
r=r-c;
if(p>=q && p>=r){
   if( allvotes < (b + c + po)){
       cout<<"YES"<<endl;
   }
   else{
       cout<<"NO"<<endl;
   }
}
else if(q>=p && q>=r){
   if( allvotes < (a + c + qo)){
       cout<<"YES"<<endl;
   }
    else{
       cout<<"NO"<<endl;
   }
}
else if(r>=q && r>=p){
   if( allvotes < (b + a + ro)){
       cout<<"YES"<<endl;
   }
    else{
       cout<<"NO"<<endl;
   }
}
}

int main(){
    int t=1;
    cin>>t;
    while(t-->0)
    solve();

    return 0;
}