#include<bits/stdc++.h>
using namespace std;
void solve(){
int x, y;
cin>>x>>y;
int count =0;
if(x>y){
    if((x-y)%2 != 0) {
        count++;
        x++;
    }
    count  += ((x-y)/2);
}
else{
    count +=(y-x);
}
cout<<count;
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
