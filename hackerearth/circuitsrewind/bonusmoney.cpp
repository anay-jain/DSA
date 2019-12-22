#include<iostream>
#include<vector>
using namespace std;
int bonuspoint(int nsofar ,int n , int msofar,int m,int maxsofar, vector<vector<int>>& memo){
    
        if(nsofar==n-1){
    if(msofar==m){
            return 1;
        }
        return 0;
    }
    if(memo[nsofar][msofar]!=-1){
        return memo[nsofar][msofar];
    }
    if(msofar>m  || nsofar>n){
        return 0;
    }
    int count=0;
    for(int i=maxsofar;i<=m;i++){
        count+=bonuspoint(nsofar+1 , n , i+msofar,m,i,memo);
        memo[nsofar][msofar]=count;
    }
    return count;
}
int main(){
    int t, p;
    cin>>t>>p;
    while(t--){
        int n , m;
        cin>>n>>m;
        vector<vector<int>> memo(n+1 , vector<int>(m+1,-1));
    cout<<bonuspoint(-1,n,0,m,0,memo)%p<<endl;
    }
    return 0;
}