#include<bits/stdc++.h>
using namespace std;
// creating a array that will count operations
const int N = 2005;
vector<int> op(N);
void once(){
    queue<int> q;    
    q.push(1);
    int level = 1;
    while(!q.empty()){
        int ele = q.front();
        int size = q.size();
        
        for(int j=1;j<=N;j++){
           int d= ele/j;   
        //    cout<<d;  
           if(ele+d < N && op[ele+d]==0)
           {
                op[ele+d]= op[ele]+1;
                q.push(ele+d);
                // cout<<ele+d;
           }
            
            else if(ele+d > N) return;
            
        }
        q.pop();
        
        
    }
   

}

void solve(){
    int n ,k;
    vector<int>b(n), c(n);
    for(int i =0;i<n;i++){
        cin>>b[i];

    }
    for(int i=0;i<n;i++){
        cin>>c[i];
    }


}

int main(){
    int t=1;
    cin>>t;
    once();
     for(int i =0;i<N;i++){
        cout<<op[i]<<endl;
    }
    while(t-->0)
    // solve();

    return 0;
}