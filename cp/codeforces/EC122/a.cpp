#include<bits/stdc++.h>
using namespace std;

void solve(int n){
    int rem = n%7;
    if(rem!=0){
        if(n%10-rem>=0 ){
            cout<<n-rem<<endl;
        }
        else{
            cout<<n+(7-rem)<<endl;
        }
    }
    else{
        cout<<n<<endl;
    }


}

int main(){
    int t;
    cin>>t;
    while(t-->0){
        int n;
        cin>>n;
         solve(n);
    }
   

    return 0;
}