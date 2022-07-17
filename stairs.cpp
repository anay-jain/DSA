#include<bits/stdc++.h>
using namespace std;
void solve(){
int n , m;
cin>>n>>m;
int arr[n][m+2]={0};
int ans[n]={0};
m=m+2;
for(int i=0;i<n;i++){
    string s;
    cin>>s;

    for(int j=0;j<m;j++){
        if(s[j]=='1')  arr[i][j]=1;
        
        if(arr[i][j]==1){
            ans[i]=j;
        }
    }
}
// cout<<"ds";
int i =0;
int count =0;
int mid = m/2;
while(i<n){
    // cout<<count;
    int c = i+1;
   if(ans[i+1]==0){
       c++;
       count++;
   }
    // left nd left
    else if(ans[i]<mid && ans[c]<mid){
        count +=ans[i];
        count +=ans[c];
    }
    else if(ans[i]<mid && ans[c]>mid){
        count+=(n-ans[i]);
        count+=(n-ans[c]);

    }
    // right left
    else if(ans[i]>mid && ans[c]<mid){
             count+=(n-ans[i]);
        count+=(n-ans[c]);
    }
    else{
          count+=(n-ans[i]);
        count+=(n-ans[c]);
    }
    i=c;
}
count +=ans[0];
cout<<count<<endl;
}
int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
