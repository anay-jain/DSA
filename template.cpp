#include<bits/stdc++.h>
using namespace std;
void solve(){
    string s;
    cin>>s;
    int arr[26]= {0};
    for(int i =0;i<s.size();i++){
        arr[(int)s[i]-'a']++;
    }
    int flag=0;
    for(int i =0;i<26;i++)
{
        if(arr[i]==0){
            char ch = (char)'a'+i;
            cout<<ch<<endl;
            flag = 1;
            break;
        }
}
if(flag==0) {
    cout<<-1<<endl;
}

}
int main(){
    int t;
    cin>>t;
    while(t--){
        solve();
    }

    return 0;
}
