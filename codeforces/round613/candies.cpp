#include<iostream>
using namespace std;
long long int candies(long long int n , long long int k){
    long long int kby2 = k/2;
    long long int ans = n/k;
    ans=ans*k;
    if(n%k>(kby2)){
        return ans+kby2;
    }
    else{
        return (n%k)+ans;
    }

 
}
int main(){
    int t;
    cin>>t;
    while(t--){
        long long int k,n;
        cin>>n>>k;
        cout<<candies(n,k)<<endl;
    }
    return 0;
}