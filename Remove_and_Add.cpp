#include<bits/stdc++.h>
using namespace std;
void solve(){
int n,k;
cin>>n;
unordered_map<int, vector<int>> umap;
for(int i=0;i<n;i++){
    cin>>k;
  if(umap.find(k) == umap.end()){
      umap[k]= vector<int>();
}
else{
    umap[k].push_back(i);
}

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
